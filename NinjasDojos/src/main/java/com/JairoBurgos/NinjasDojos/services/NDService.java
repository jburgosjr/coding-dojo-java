package com.JairoBurgos.NinjasDojos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.JairoBurgos.NinjasDojos.models.Dojo;
import com.JairoBurgos.NinjasDojos.models.Ninja;
import com.JairoBurgos.NinjasDojos.repositories.DojoRepo;
import com.JairoBurgos.NinjasDojos.repositories.NinjaRepo;

@Service
public class NDService {
	
	private final NinjaRepo nR;
	private final DojoRepo dR;
	
	public NDService(NinjaRepo nR, DojoRepo dR) {
		
		this.nR = nR;
		this.dR = dR;
	}
	
	public Dojo addDojo(Dojo dojo) {
		return dR.save(dojo);
	}
	
	public List<Dojo> allDojos() {
		return dR.findAll();
	}
	
	public Ninja addNinja(Ninja ninja) {
		return nR.save(ninja);
	}
	
	public Dojo getDojo(Long id){
		Optional<Dojo> dojo = dR.findById(id);
		if(dojo.isPresent()) {
			return dojo.get();
			
		}
		else {
			return null;
		}
	}
	
	public Optional<Ninja> getNinja(Long id){
		return nR.findById(id);
	}
	
	
}
