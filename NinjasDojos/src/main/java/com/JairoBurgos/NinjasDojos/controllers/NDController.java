package com.JairoBurgos.NinjasDojos.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.JairoBurgos.NinjasDojos.models.Dojo;
import com.JairoBurgos.NinjasDojos.models.Ninja;
import com.JairoBurgos.NinjasDojos.services.NDService;

@Controller
public class NDController {
	private final NDService ndService;

	public NDController(NDService ndService) {
		this.ndService = ndService;
	}
	
	@RequestMapping("/")
	public String notHere() {
		return "redirect:/dojos/new";
	}
	
	@GetMapping("dojos/new")
	public String addDojo(@ModelAttribute("dojo") Dojo dojo) {
		return"jsp/addDojo.jsp";
	}
	
	@PostMapping("dojos/new")
	public String processAddDojo(@Valid @ModelAttribute("dojo")Dojo dojo,BindingResult result) {
		if (result.hasErrors()) {
			return "jsp/addDojo.jsp";
		}
		else {
			ndService.addDojo(dojo);
			return "redirect:/ninjas/new";
		}
	}
	
	@GetMapping("ninjas/new")
	public String addNinja(@ModelAttribute("ninja")Ninja ninja,Model model) {
		List<Dojo> allDojo = ndService.allDojos();
		model.addAttribute("dojos",allDojo);
		return "jsp/addNinja.jsp";
		
	}
	
	@PostMapping("ninjas/new")
	public String processAddNinja(@Valid @ModelAttribute("ninja")Ninja ninja, Model model, BindingResult result) {
		if(result.hasErrors()) {
			List<Dojo> allDojo = ndService.allDojos();
			model.addAttribute("dojos",allDojo);
			return "jsp/addNinja.jsp";
		}
		else {
			ndService.addNinja(ninja);
			return "redirect:/dojos/"+ninja.getDojo().getId();
		}
		
	}
	
	@GetMapping("dojos/{dojoId}")
	public String showDojo(@PathVariable("dojoId")Long id, Model model) {
		Dojo dojo = ndService.getDojo(id);
		model.addAttribute("dojo", dojo);
		return "jsp/list.jsp";
	}
	
	
}
