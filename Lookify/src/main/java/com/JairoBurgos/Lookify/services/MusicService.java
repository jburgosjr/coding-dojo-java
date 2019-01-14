package com.JairoBurgos.Lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.JairoBurgos.Lookify.models.Music;
import com.JairoBurgos.Lookify.repositories.MusicRepo;

@Service
public class MusicService {

	private final MusicRepo mR;

	public MusicService(MusicRepo mR) {
		this.mR = mR;
	}
	
	public List<Music> allSongs(){
		return mR.findAll();
	}
	
	public Music addSong(Music song) {
		return mR.save(song);
	}
	
	public Music findSong(Long id) {
		Optional<Music> optionalMusic = mR.findById(id);
		if(optionalMusic.isPresent()){
			return optionalMusic.get();
		}
		else {
			return null;
		}
	}
	
	public void deleteSong(Long id) {
		mR.deleteById(id);
	}
	
	public void updateSong(Music song) {
		mR.save(song);
	}
	
	public List<Music> topTen(){
		return mR.findTop10ByOrderByRatingDesc();
	}
	
	public List<Music> searchBy(String search){
		return mR.findByArtistContainsAllIgnoreCase(search);
	}
}
