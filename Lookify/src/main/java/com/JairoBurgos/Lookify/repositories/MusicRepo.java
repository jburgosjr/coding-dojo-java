package com.JairoBurgos.Lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.JairoBurgos.Lookify.models.Music;

@Repository
public interface MusicRepo extends CrudRepository<Music, Long> {
	List<Music> findAll();
	List<Music> findTop10ByOrderByRatingDesc();
	List<Music> findByArtistContainsAllIgnoreCase(String search);
}
