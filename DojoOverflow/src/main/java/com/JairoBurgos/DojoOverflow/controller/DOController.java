package com.JairoBurgos.DojoOverflow.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.JairoBurgos.DojoOverflow.models.Answer;
import com.JairoBurgos.DojoOverflow.models.Question;
import com.JairoBurgos.DojoOverflow.services.DOService;

@Controller
public class DOController {
	private final DOService dOS;
	
	public DOController(DOService dOS) {
		
		this.dOS = dOS;
	}

	@GetMapping("/")
	public String notHere() {
		return"redirect:/questions";
	}
	
	@GetMapping("/questions")
	public String dashBoard(Model model) {
		model.addAttribute("questions",dOS.allQuestions());
		return"jsp/dashboard.jsp";
	}
	
	@GetMapping("/questions/new")
	public String newQuestion(@ModelAttribute("addQuestion")Question question) {
		return"jsp/newQuestion.jsp";
	}
	
	@PostMapping("/questions/new")
	public String addQuestion(@RequestParam("other")String tags,@Valid @ModelAttribute("addQuestion")Question question,BindingResult result,RedirectAttributes rA) {
		List<String> tagString = Arrays.asList(tags.split(","));
		if(tagString.size() > 3) {
			System.out.println("tag error at first if");
			String error = "<div class=\"alert alert-danger\" role=\"alert\"> Questions can only have a maximum of 3 tags </div>";
			rA.addFlashAttribute("error", error );
			return "redirect:/questions/new";
		} 
		else if(tags.length() == 0){
			String error = "<div class=\"alert alert-danger\" role=\"alert\"> Your question must have at least one tag </div>";
			rA.addFlashAttribute("error", error );
			System.out.println("tag error at second if");
			return "redirect:/questions/new";
			
		}
		else if(result.hasErrors()) {
			System.out.println("tag error at third if");
			return"jsp/newQuestion.jsp";
		} 
		else {
			dOS.tagCheckAndSave(tagString, question);
			return "redirect:/";
		}
	}
	
	@GetMapping("/questions/{questionId}")
	public String questionProfile(@ModelAttribute("addTheAnswer")Answer answer,@PathVariable("questionId")Long id,Model model) {
		model.addAttribute("question",dOS.findQuestionById(id));
		return"jsp/questionProfile.jsp";
	}
	
	@PostMapping("/questions/{questionId}")
	public String addAnswerToQuestion(@Valid @ModelAttribute("addTheAnswer")Answer answer,BindingResult result,@PathVariable("questionId")Long id , Model model) {
		if(result.hasErrors()) {
			model.addAttribute("question",dOS.findQuestionById(id));
			return"jsp/questionProfile.jsp";
		}
		else {
			answer.setQuestion(dOS.findQuestionById(id));
			dOS.saveAnswer(answer);
			return"redirect:/questions/"+id;
		}
	}
	


}
