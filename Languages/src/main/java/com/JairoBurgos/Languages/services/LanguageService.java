package com.JairoBurgos.Languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.JairoBurgos.Languages.models.Language;
import com.JairoBurgos.Languages.repositories.LangRepo;

@Service
public class LanguageService {
	private final LangRepo lR;
	
	public LanguageService(LangRepo lR) {
		this.lR = lR;
	}
	
	public List<Language> allLanguages(){
		return lR.findAll();
	}
	
	public Language addLanguage(Language lang) {
		return lR.save(lang);
	}
	
	public Language findLanguage(Long Id) {
		Optional<Language> optionalLanguage = lR.findById(Id);
		if(optionalLanguage.isPresent()) {
			return optionalLanguage.get();
		}
		else {
			return null;
		}
	}
	
	public void deleteLanguage(Long id) {
		lR.deleteById(id);
	}
	
	public void updateLang(Language lang) {
		lR.save(lang);
		
	}
}
