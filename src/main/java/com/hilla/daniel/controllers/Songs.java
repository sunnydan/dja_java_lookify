package com.hilla.daniel.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hilla.daniel.models.Song;
import com.hilla.daniel.repositories.SongRepository;
import com.hilla.daniel.services.SongService;

@Controller
public class Songs {

	private final SongService songservice;

	public Songs(SongRepository songRepository) {
		this.songservice = new SongService(songRepository);
	}

	@RequestMapping("/songs")
	public String books(Model model) {
		model.addAttribute("songs", songservice.allSongs());
		System.out.println(songservice.allSongs());
		return "dashboard";
	}

	@RequestMapping("/topsongs")
	public String topten(Model model) {
		model.addAttribute("songs", songservice.getTopTen());
		System.out.println(songservice.allSongs());
		return "topten";
	}

	@RequestMapping("/songs/{index}")
	public String findBookByIndex(Model model, @PathVariable("index") Long index) {
		model.addAttribute("song", songservice.findSongByIndex(index));
		return "showSong";
	}

	@RequestMapping("/songs/new")
	public String newSong(@ModelAttribute("song") Song song) {
		return "newSong";
	}

	@PostMapping("/songs/new")
	public String createSong(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if (result.hasErrors()) {
			return "newBook";
		} else {
			this.songservice.addSong(song);
			return "redirect:/songs";
		}
	}

	@RequestMapping("/songs/edit/{id}")
	public String editSong(@PathVariable("id") Long id, Model model) {
		Song song = songservice.findSongByIndex(id);
		if (song != null) {
			model.addAttribute("song", song);
			return "editSong";
		} else {
			return "redirect:/songs";
		}
	}

	@PostMapping("/songs/edit/{id}")
	public String updateSong(@PathVariable("id") Long id, @Valid @ModelAttribute("song") Song song,
			BindingResult result) {
		if (result.hasErrors()) {
			return "editSong";
		} else {
			songservice.updateSong(song);
			return "redirect:/songs";
		}
	}

	@RequestMapping("/songs/delete/{id}")
	public String destroySong(@PathVariable("id") long id) {
		songservice.destroySong(id);
		return "redirect:/songs";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String search(@RequestParam("artist") String artist, Model model) {
		ArrayList<Song> songs = songservice.searchByArtist(artist);
		if (songs.isEmpty()) {
			return "redirect:/dashboard";
		} else {
			model.addAttribute("songs", songservice.searchByArtist(artist));
			return "result";
		}
	}
}
