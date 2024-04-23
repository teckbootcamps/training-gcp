package com.google.training.appdev.api;

import com.google.training.appdev.services.gcp.datastore.QuestionService;
import com.google.training.appdev.services.gcp.domain.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/questions")
public class QuestionManagementEndpoint {
    @Autowired
    private QuestionService questionService;

    @GetMapping
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions("gcp");
    }

    @PostMapping
    public ResponseEntity persistQuestion(@RequestBody Question question) {
        questionService.createQuestion(question);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
