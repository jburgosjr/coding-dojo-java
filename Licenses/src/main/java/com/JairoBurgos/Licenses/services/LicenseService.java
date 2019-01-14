package com.JairoBurgos.Licenses.services;



import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.JairoBurgos.Licenses.models.License;
import com.JairoBurgos.Licenses.models.Person;
import com.JairoBurgos.Licenses.repositories.LicenseRepo;
import com.JairoBurgos.Licenses.repositories.PersonRepo;

@Service
public class LicenseService {
	
	private final LicenseRepo lR;
	private final PersonRepo pR;
    public static int licenseNumber;
	
	public LicenseService(LicenseRepo lR, PersonRepo pR) {
		
		this.lR = lR;
		this.pR = pR;
		
	}
	
	public static Integer getLicenseNumber() {
		return licenseNumber;
	}

	public static void setLicenseNumber(Integer licenseNumber) {
		LicenseService.licenseNumber = licenseNumber;
	}

	public Person addPerson(Person person) {
		return pR.save(person);
	}
	
	public List<Person> allPersons() {
		return pR.findAll();
	}
	
	public License addLicense(License license){
		
		return lR.save(license);
	}
	
	public String stringLicenseNumber(int num) {
		String format = String.format("%06d", num);
		return format;
	}
	public String generateLicenseNumber() {
		if(lR.findTopByOrderByNumberDesc().isEmpty()) {
			licenseNumber +=1;
			return stringLicenseNumber(licenseNumber); 
		}
		else {
			List<License> top = lR.findTopByOrderByNumberDesc();
			licenseNumber = 1+(Integer.parseInt(top.get(0).getNumber()));
			return stringLicenseNumber(licenseNumber); 
		}
		
	}
	
	public Optional<License> getLicense(Long id) {
		return lR.findById(id);
	}
	
	
}
