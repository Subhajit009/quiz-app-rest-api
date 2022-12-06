package com.epam.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.epam.quiz.service.QuestionLibrary;
import com.epam.quiz.service.QuizLibrary;

@Controller
public class QuizController {
	@Autowired
	QuizLibrary quizLibrary;
	@Autowired
	QuestionLibrary questionLibrary;
	
	@RequestMapping("quizOperations")
	public String quiz() {
		return "quizOperations";
	}
	
	@RequestMapping("showQuiz")
	public ModelAndView getQuiz() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("quizes", quizLibrary.getAllQuizes());
		modelAndView.setViewName("showQuiz");
		return modelAndView;
	}
	
	@RequestMapping("selectQuiz")
    public ModelAndView selectQuiz() {
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.addObject("questions", questionLibrary.getAllQuestions());
    	modelAndView.setViewName("selectQuiz");
    	return modelAndView;
    }
	
	@PostMapping("addMarks")
    public ModelAndView addQuestionToQuiz(int id,int marks) {
        ModelAndView modelAndView = new ModelAndView();
        quizLibrary.addQuestion(id, marks);
        modelAndView.addObject("message","Question addded to quiz...!!!");
        modelAndView.setViewName("addMarks");
        return modelAndView;
    }
	
	@RequestMapping("deleteQuiz")
	public ModelAndView deleteQuiz() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("quizes", quizLibrary.getAllQuizes());
		modelAndView.setViewName("deleteQuiz");
		return modelAndView;
	}
	
	@RequestMapping(value ="removeQuiz/{id}")
	public RedirectView delete(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
		quizLibrary.remove(id);
		redirectAttributes.addFlashAttribute("message","Quiz deleted...!!!");
		RedirectView redirectView = new RedirectView("/removeQuiz");
    	return redirectView;
		
	}
	
	@RequestMapping("removeQuiz")
	public String removeQuiz() {
		return "removeQuiz";
	}    
    
    @RequestMapping("/updateQuiz")
    public ModelAndView updateQuiz() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("quizes",quizLibrary.getAllQuizes());
        modelAndView.addObject("questions",questionLibrary.getAllQuestions());
        modelAndView.setViewName("/updateQuiz");
        return modelAndView;
    }
    
    @RequestMapping("/updateQuizAction")
    public ModelAndView updateQuizAction(int quizId,int questId,int marks) {
        ModelAndView modelAndView = new ModelAndView();
        quizLibrary.updateQuiz(quizId, questId, marks);
        modelAndView.addObject("message","Quiz Updated...!!!");
        modelAndView.setViewName("/updateQuizAction");
        return modelAndView;
    }
    
}



