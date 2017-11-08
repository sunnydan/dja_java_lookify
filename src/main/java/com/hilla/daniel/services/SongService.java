package com.hilla.daniel.services;

import java.util.ArrayList;

import com.hilla.daniel.models.Song;
import com.hilla.daniel.repositories.SongRepository;

public class SongService {

	private SongRepository songRepository;

	public SongService(SongRepository sr) {
		this.songRepository = sr;
	}

	public ArrayList<Song> allSongs() {
		return (ArrayList<Song>) songRepository.findAll();
	}

	public ArrayList<Song> getTopTen() {
		return (ArrayList<Song>) songRepository.findTop10ByOrderByRatingDesc();
	}

	public Song findSongByIndex(Long index) {
		return songRepository.findOne(index);
	}

	public void addSong(Song song) {
		songRepository.save(song);
	}

	public void updateSong(Song song) {
		songRepository.save(song);
	}

	public void destroySong(Long id) {
		songRepository.delete(id);
	}

	public ArrayList<Song> searchByArtist(String artist) {
		return (ArrayList<Song>) songRepository.findByArtistContaining(artist);
	}
}
