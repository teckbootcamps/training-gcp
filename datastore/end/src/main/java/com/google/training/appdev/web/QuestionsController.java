
package com.google.training.appdev.web;

import com.google.training.appdev.services.gcp.domain.Question;
import com.google.training.appdev.services.gcp.datastore.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
public class QuestionsController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/questions/add")
    public String getForm(Model model) {
        model.addAttribute("quizquestion", new Question());
        return "new_question";
    }

    @PostMapping("/questions/add")
    public String submitQuestion(Question question) throws IOException {
        questionService.createQuestion(question);
        return "redirect:/";
    }
}