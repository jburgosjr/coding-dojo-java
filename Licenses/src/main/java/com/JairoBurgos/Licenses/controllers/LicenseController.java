package com.JairoBurgos.Licenses.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.JairoBurgos.Licenses.models.License;
import com.JairoBurgos.Licenses.models.Person;
import com.JairoBurgos.Licenses.services.LicenseService;

@Controller
public class LicenseController {
	private final LicenseService licenseService;

	public LicenseController(LicenseService licenseService) {
		this.licenseService = licenseService;
	}
	
	@RequestMapping("/")
	public String notHere() {
		return "redirect:/persons/new";
	}
	
	@GetMapping("persons/new")
	public String addPerson(@ModelAttribute("person") Person peroson) {
		return "views/personAdd.jsp";
	}
	
	@PostMapping("persons/new") 
	public String processAddPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if(result.hasErrors()) {
			return "views/personAdd.jsp";
		}
		else {
			licenseService.addPerson(person);
			return "redirect:/license/new";
		}
	}
	
	@GetMapping("license/new")
	public String addLicense(@ModelAttribute("license")License license, Model model) {
		List<Person> persons = licenseService.allPersons();
		model.addAttribute("persons",persons);
		return"views/licenseAdd.jsp";
		
	}
	
	@PostMapping("license/new")
	public String processLicense(@Valid @ModelAttribute("license") License license, BindingResult result,Model model) {
		if(result.hasErrors()) {
			List<Person> persons = licenseService.allPersons();
			model.addAttribute("persons",persons);
			return "views/licenseAdd.jsp";
		}
		else {
			String number = licenseService.generateLicenseNumber();
			license.setNumber(number);
//			System.out.println(license.getNumber());
//			System.out.println(license.getState());
//			System.out.println(license.getExpiration_date());
//			System.out.println(license.getPerson());
			licenseService.addLicense(license);
			return"redirect:/persons/"+license.getId();
			
		}
	}
	
	@RequestMapping("/persons/{personId}")
	public String setUpView(@PathVariable("personId")Long id,Model model) {
		Date date = licenseService.getLicense(id).get().getExpiration_date();
		String pattern ="MM/dd/yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		model.addAttribute("date",simpleDateFormat.format(date));
		model.addAttribute("license",licenseService.getLicense(id).get());
		return"views/info.jsp";
	}
	
	
	
}
