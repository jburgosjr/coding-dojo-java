package com.JairoBurgos.Lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.JairoBurgos.Lookify.models.Music;
import com.JairoBurgos.Lookify.services.MusicService;

@Controller
public class MusicControler {
	private final MusicService musicService;

	public MusicControler(MusicService musicService) {
		this.musicService = musicService;
	}
	
	@RequestMapping("/")
	public String start() {
		return "views/start.jsp";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(@ModelAttribute("songName") Music song, Model model){
		List<Music> songs = musicService.allSongs();
		model.addAttribute("songs",songs);
		return "views/dashboard.jsp";
	}
	
	@PostMapping("songs/new")
	public String add(@Valid @ModelAttribute("music") Music song, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return"views/add.jsp";
		}
		else {
			musicService.addSong(song);
			return"redirect:/dashboard";
		}
	}
	
	@GetMapping("songs/new")
	public String add(@ModelAttribute("music") Music song) {
		return"views/add.jsp";
	}
	
	@DeleteMapping("/dashboard/{songId}")
	public String destroy(@PathVariable("songId") Long id) {
		musicService.deleteSong(id);
		return"redirect:/dashboard";
	}
	
	@RequestMapping("/songs/{songId}")
	public String info(@PathVariable("songId") Long id, Model model) {
		Music song = musicService.findSong(id);
		model.addAttribute("song",song);
		return "views/info.jsp";
	}
	
	@RequestMapping("search/topten")
		public String topTen(Model model) {
			List<Music> top = musicService.topTen();
			model.addAttribute("top",top);
			return "views/top.jsp";
			
	}
	
	@PostMapping ("/search")
	public String search(@ModelAttribute("songName") Music song) {
		return"redirect:/search/"+song.getName();
	}
	
	@RequestMapping("/search/{search}")
	public String result(@ModelAttribute("songName") Music song,@PathVariable("search")String search, Model model) {
		List<Music> results = musicService.searchBy(search);
		model.addAttribute("search",search);
		model.addAttribute("results",results);
		return "views/search.jsp";
	}
		
	
	

}
