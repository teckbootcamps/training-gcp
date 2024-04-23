
package com.google.training.appdev.setup;

import com.google.training.appdev.services.gcp.datastore.QuestionService;
import com.google.training.appdev.services.gcp.domain.Question;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;


public class QuestionBuilder {

    static List<Question> buildQuestions(){
       List<Question> questions = new ArrayList<>();

       Question question = new Question.Builder()
               .withQuiz("gcp")
               .withAuthor("Nigel")
               .withTitle("Which company runs GCP?")
               .withAnswerOne("Amazon")
               .withAnswerTwo("Google")
               .withAnswerThree("IBM")
               .withAnswerFour("Microsoft")
               .withCorrectAnswer(2)
               .build();
       questions.add(question);

       question = new Question.Builder()
                .withQuiz("gcp")
                .withAuthor("Nigel")
                .withTitle("Which GCP product is NoSQL?")
                .withAnswerOne("Compute Engine")
                .withAnswerTwo("DataStore")
                .withAnswerThree("Spanner")
                .withAnswerFour("BigQuery")
                .withCorrectAnswer(2)
                .build();
        questions.add(question);

        question = new Question.Builder()
                .withQuiz("gcp")
                .withAuthor("Nigel")
                .withTitle("Which GCP product is an Object Store?")
                .withAnswerOne("Cloud Storage")
                .withAnswerTwo("Datastore")
                .withAnswerThree("Big Table")
                .withAnswerFour("All of the above")
                .withCorrectAnswer(1)
                .build();
        questions.add(question);

        question = new Question.Builder()
                .withQuiz("places")
                .withAuthor("Nigel")
                .withTitle("What is the capital of France?")
                .withAnswerOne("Berlin")
                .withAnswerTwo("London")
                .withAnswerThree("Paris")
                .withAnswerFour("Stockholm")
                .withCorrectAnswer(3)
                .build();
        questions.add(question);
       return questions;
    }

    public static void main(String ... args){
        out.println("Entity Factory Creating Initial Questions");

        QuestionService questionService = new QuestionService();

        buildQuestions().forEach(question -> questionService.createQuestion(question));

        
    }
}
