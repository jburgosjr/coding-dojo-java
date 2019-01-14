package com.JairoBurgos.NinjaGold.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Processes {
	
	@RequestMapping(value="/getGold", method=RequestMethod.POST)
	public String getGold(@RequestParam(value="button")String button, HttpSession session) {
		if(button.equals("farm")) {
			
			int val = ThreadLocalRandom.current().nextInt(1,3);
			String format = "EEEEE dd yyyy KK:mm aa";
			SimpleDateFormat dateFormat= new SimpleDateFormat(format);
			
			if(val == 1) {
				int goldGenerate = ThreadLocalRandom.current().nextInt(1,9);
				String timeStamp = dateFormat.format(new Date());
				ArrayList<String> list = (ArrayList<String>) session.getAttribute("eventLog");
				list.add(0,"<p class=greentext>Got yourself a good crop this season. you've earned "+goldGenerate+" gold ("+timeStamp+")</p>");
				session.setAttribute("gold", (int)session.getAttribute("gold")+goldGenerate);
				session.setAttribute("logList", list);
				
			}
			
			if(val == 2) {
				int goldGenerate = ThreadLocalRandom.current().nextInt(1,9);
				String timeStamp = dateFormat.format(new Date());
				ArrayList<String> list = (ArrayList<String>) session.getAttribute("eventLog");
				list.add(0,"<p class=redtext>Your crop is trash. aint nobody gonna buy this stuff! you've lost "+goldGenerate+" gold ("+timeStamp+")</p>");
				session.setAttribute("gold", (int)session.getAttribute("gold")-goldGenerate);
				session.setAttribute("logList", list);
				
			}
			
		}
		
		if(button.equals("cave")) {
			
			int val = ThreadLocalRandom.current().nextInt(1,3);
			String format = "EEEEE dd yyyy KK:mm aa";
			SimpleDateFormat dateFormat= new SimpleDateFormat(format);
			
			if(val == 1) {
				int goldGenerate = ThreadLocalRandom.current().nextInt(1,11);
				String timeStamp = dateFormat.format(new Date());
				ArrayList<String> list = (ArrayList<String>) session.getAttribute("eventLog");
				list.add(0,"<p class=greentext>oh snap! is that a treasure box! you've found "+goldGenerate+" gold ("+timeStamp+")</p>");
				session.setAttribute("gold", (int)session.getAttribute("gold")+goldGenerate);
				session.setAttribute("logList", list);
				
			}
			
			if(val == 2) {
				int goldGenerate = ThreadLocalRandom.current().nextInt(1,11);
				String timeStamp = dateFormat.format(new Date());
				ArrayList<String> list = (ArrayList<String>) session.getAttribute("eventLog");
				list.add(0,"<p class=redtext>you hear some noises that scare you. you run away like a pansy loosing "+goldGenerate+" gold ("+timeStamp+")</p>");
				session.setAttribute("gold", (int)session.getAttribute("gold")-goldGenerate);
				session.setAttribute("logList", list);
				
			}
			
		}
		
		if(button.equals("loot")) {
			
			int val = ThreadLocalRandom.current().nextInt(1,3);
			String format = "EEEEE dd yyyy KK:mm aa";
			SimpleDateFormat dateFormat= new SimpleDateFormat(format);
			
			if(val == 1) {
				int goldGenerate = ThreadLocalRandom.current().nextInt(2,6);
				String timeStamp = dateFormat.format(new Date());
				ArrayList<String> list = (ArrayList<String>) session.getAttribute("eventLog");
				list.add(0,"<p class=greentext>Earned "+goldGenerate+" gold from looting a random person! you might want to re-evaluate your life.("+timeStamp+")</p>");
				session.setAttribute("gold", (int)session.getAttribute("gold")+goldGenerate);
				session.setAttribute("logList", list);
				
			}
			
			if(val == 2) {
				int goldGenerate = ThreadLocalRandom.current().nextInt(2,6);
				String timeStamp = dateFormat.format(new Date());
				ArrayList<String> list = (ArrayList<String>) session.getAttribute("eventLog");
				list.add(0,"<p class=redtext>The person you tried to mug fights back! serves you right. you loose "+goldGenerate+" gold ("+timeStamp+")</p>");
				session.setAttribute("gold", (int)session.getAttribute("gold")-goldGenerate);
				session.setAttribute("logList", list);
				
			}
			
		}
		
		if(button.equals("casino")) {
			
			int val = ThreadLocalRandom.current().nextInt(1,3);
			String format = "EEEEE dd yyyy KK:mm aa";
			SimpleDateFormat dateFormat= new SimpleDateFormat(format);
			
			if(val == 1) {
				int goldGenerate = ThreadLocalRandom.current().nextInt(10,101);
				String timeStamp = dateFormat.format(new Date());
				ArrayList<String> list = (ArrayList<String>) session.getAttribute("eventLog");
				list.add(0,"<p class=greentext>Earned "+goldGenerate+" gold from the casino! lady luck has been kind to you! ("+timeStamp+")</p>");
				session.setAttribute("gold", (int)session.getAttribute("gold")+goldGenerate);
				session.setAttribute("logList", list);
				
			}
			
			if(val == 2) {
				int goldGenerate = ThreadLocalRandom.current().nextInt(10,101);
				String timeStamp = dateFormat.format(new Date());
				ArrayList<String> list = (ArrayList<String>) session.getAttribute("eventLog");
				list.add(0,"<p class=redtext>you've lost "+goldGenerate+" gold from the casino! lady luck, why have you forsaken me! ("+timeStamp+")</p>");
				session.setAttribute("gold", (int)session.getAttribute("gold")-goldGenerate);
				session.setAttribute("logList", list);
				
			}
			
		}
		

		
		return"redirect:/";
	}
	
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

}
