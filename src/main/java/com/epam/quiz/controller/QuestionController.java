package com.epam.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.epam.quiz.service.QuestionLibrary;

@Controller
public class QuestionController {
	
	@Autowired
	QuestionLibrary questionLibrary;
	
	@RequestMapping("questionOperations")
	public String questionOperations() {
		return "questionOperations";
	}
	
	@RequestMapping("showQuestions")
	public ModelAndView getQuestions() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("allQuestions", questionLibrary.getAllQuestions());
		mv.setViewName("showQuestions");
		return mv;
	}
	
	@RequestMapping("createQuestion")
	public String createQuestion() {
		return "createQuestion";
	}
	
	@RequestMapping("insertQuestion")
	public ModelAndView insertQuestion(String question,String[] options, char rightAnswer) {
		ModelAndView modelAndView = new ModelAndView();
		questionLibrary.createQuestion(question,options,rightAnswer);
		modelAndView.addObject("message","Question addded...!!!");
		modelAndView.setViewName("createQuestion");
		return modelAndView;
	}
	
	@RequestMapping("delete_and_edit_Questions")
	public ModelAndView deleteQuestion() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("allQuestions",questionLibrary.getAllQuestions());
		modelAndView.setViewName("delete_and_edit_Questions");
		return modelAndView;
	}
	
	
	
	@RequestMapping(value ="delete/{id}",method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id) {
		ModelAndView modelAndView = new ModelAndView();
		questionLibrary.remove(id);
		modelAndView.addObject("message","Question deleted...!!!");
		return "redirect:/delete_and_edit_Questions";
		
	}

	
    @RequestMapping("editQuestion/{id}")
    public ModelAndView updateQuestion(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("question",questionLibrary.getQuestionById(id));
        modelAndView.setViewName("/editQuestion");
        return modelAndView;
    }
    @PostMapping("/editQuestion")
    public RedirectView update(int id,String question,String[] option,char rightAnswer) {   
       questionLibrary.updateQuestion(id, question,option,rightAnswer);
       RedirectView redirectView = new RedirectView("/showQuestions");
        return redirectView;
        
    }
}

	

