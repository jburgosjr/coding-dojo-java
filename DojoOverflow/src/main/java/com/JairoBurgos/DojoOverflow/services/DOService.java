package com.JairoBurgos.DojoOverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.JairoBurgos.DojoOverflow.models.Answer;
import com.JairoBurgos.DojoOverflow.models.Question;
import com.JairoBurgos.DojoOverflow.models.Tag;
import com.JairoBurgos.DojoOverflow.models.TagQuestion;
import com.JairoBurgos.DojoOverflow.repositories.AnswerRepo;
import com.JairoBurgos.DojoOverflow.repositories.QuestionRepo;
import com.JairoBurgos.DojoOverflow.repositories.TagQuestionRepo;
import com.JairoBurgos.DojoOverflow.repositories.TagRepo;

@Service
public class DOService {
	private final QuestionRepo qR;
	private final TagRepo tR;
	private final TagQuestionRepo tQR;
	private final AnswerRepo aR;
	
	public DOService(QuestionRepo qR, TagRepo tR, TagQuestionRepo tQR, AnswerRepo aR) {
		this.qR = qR;
		this.tR = tR;
		this.tQR = tQR;
		this.aR = aR;
	}
	
	public Question saveQuestion(Question question) {
		return qR.save(question);
	}
	
	public Tag saveTag(Tag tag) {
		return tR.save(tag);
	}
	
	public Answer saveAnswer(Answer answer) {
		return aR.save(answer);
	}
	
	public TagQuestion saveTagQuestion(TagQuestion tagQuestion) {
		return tQR.save(tagQuestion);
	}
	
	public Tag findSpecificTagbyName(String name) {
		return tR.findBySubjectIgnoreCase(name);
	}
	
	public List<Question> allQuestions(){
		return qR.findAll();
	}
	
	public Question findQuestionById(Long id) {
		Optional<Question> check = qR.findById(id);
		if(check.isPresent()) {
			return check.get();
		}
		else {
			return null;
		}
	}
	
	
	public void tagCheckAndSave(List<String> tags, Question question) {
		Question saveQuestion = saveQuestion(question);
		for(String check : tags) {
			if(findSpecificTagbyName(check) != null) {
				TagQuestion combine = new TagQuestion();
				combine.setTag(findSpecificTagbyName(check));
				combine.setQuestion(saveQuestion);
				saveTagQuestion(combine);
			}
			else {
				Tag newTag = new Tag();
				newTag.setSubject(check);
				Tag cTag = saveTag(newTag);
				TagQuestion combine = new TagQuestion();
				combine.setTag(cTag);
				combine.setQuestion(saveQuestion);
				saveTagQuestion(combine);
			}
		}
	}
	
	
}
