package com.JairoBurgos.Languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.JairoBurgos.Languages.models.Language;
import com.JairoBurgos.Languages.services.LanguageService;

@Controller
public class LanguageController {
	private final LanguageService languageService;
	
	public LanguageController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@RequestMapping("/")
	public String reRoute() {
		return "redirect:/languages";
	}
	
	@RequestMapping("/languages")
	public String home(@ModelAttribute("lang") Language lang, Model model) {
		List <Language> language = languageService.allLanguages();
		model.addAttribute("langList",language);
		return "views/index.jsp";
	}
	
	@RequestMapping(value="/languages", method=RequestMethod.POST)
	public String add(@Valid @ModelAttribute("lang") Language lang, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List <Language> language = languageService.allLanguages();
			model.addAttribute("langList",language);
			return "views/index.jsp";
		}
		else
			languageService.addLanguage(lang);
			return"redirect:/languages";
			
	}
	
	@RequestMapping("/languages/{id}")
	public String info(@PathVariable("id") Long id, Model model) {
		Language lang = languageService.findLanguage(id);
		model.addAttribute("language",lang);
		return "views/info.jsp";
	}
	
	@RequestMapping(value="/languages/{id}", method=RequestMethod.DELETE)
	public String destroy(@PathVariable("id") Long id) {
		languageService.deleteLanguage(id);
		return"redirect:/";
	}
	
	@RequestMapping(value="/languages/{id}", method=RequestMethod.PUT)
	public String editLang(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("error here");
			return "views/edit.jsp";
		}
		else {
			languageService.updateLang(language);
			return"redirect:/languages";
		}
	}
	
	@RequestMapping("/languages/{id}/edit")
	public String editRender(@ModelAttribute("language") Language language, @PathVariable("id")Long id, Model model) {
		Language lang2 = languageService.findLanguage(id);
		model.addAttribute("language",lang2);
		return "views/edit.jsp";
	}

}
