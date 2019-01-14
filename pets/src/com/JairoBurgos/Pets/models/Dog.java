package com.JairoBurgos.Pets.models;

public class Dog extends Animal implements Pet {
	
	public Dog() {
		super();
		
	}

	public Dog(String name, String breed, int weight) {
		super(name, breed, weight);
		
	}
	
	




	@Override
	public String showAffection() {
		int weight = getWeight();
		String petName = getName();
		String response="";
		
		if (weight < 10  ) {
			response = (petName+" hopped into your lap and cuddled you. Good Dog.");
		}
		
		if (weight > 10) {
			response = (petName+" sits next to you rubbing its head on your leg. Good Dog");
		}
		
		return (response);
	}
}

	
