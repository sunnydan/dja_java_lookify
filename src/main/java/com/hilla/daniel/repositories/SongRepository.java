package com.hilla.daniel.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.hilla.daniel.models.Song;


@Repository
public interface SongRepository extends CrudRepository<Song, Long> {
	List<Song> findByArtistContaining(String search);
	List<Song> findAll();
	List<Song> findTop10ByOrderByRatingDesc();
}
