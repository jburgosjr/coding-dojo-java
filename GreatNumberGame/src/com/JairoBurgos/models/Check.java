package com.JairoBurgos.models;

public class Check {
	
	private int random;
	private int guess;
	
	public Check() {
		
	}
	
	public Check(int random, int guess) {
		this.random = random;
		this.guess = guess;
	}

	public int getRandom() {
		return random;
	}

	public void setRandom(int random) {
		this.random = random;
	}

	public int getGuess() {
		return guess;
	}

	public void setGuess(int guess) {
		this.guess = guess;
	}
	
	public String checkGuess() {
		String status ="";
		
		if(this.guess > this.random) {
			status = "high";
		}
		if(this.guess < this.random) {
			status = "low";
		}
		
		if(this.guess == this.random) {
			status = "found";
		}
		
		return (status);
		
	}
	
	

}
