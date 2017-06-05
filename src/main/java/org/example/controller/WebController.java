package org.example.controller;

import org.example.domain.*;
import org.example.factory.AnswerFactory;
import org.example.factory.IFactory;
import org.example.json_objects.*;
import org.example.service.IService;
import org.example.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.*;

import javax.validation.Valid;

/**
 * Created by Kuzmin Evgeny on 18.05.2017.
 */
@Controller
@Scope("singleton")
public class WebController {

    @Autowired
    private IService service;

    @Autowired
    private AnswerFactory answerFactory;


    @RequestMapping(value = "/", method= RequestMethod.GET)
    public String showMain(@Valid JsonUserWithoutPassword jsonUser, BindingResult bindingResult, Model model){
        /*не залогинился*/
        if (bindingResult.hasErrors()){
            return "form_login";
        }
        model.addAttribute("questionnaires", service.findAll(Questionnaire.tableName));
        return "form_main";
    }

    @RequestMapping(value = "test_result", method= RequestMethod.POST)
    public String showTestResults(Model model){
        model.addAttribute("passedTests", service.findAll(PassedTest.tableName));
        return "form_results";
    }

    @RequestMapping(value = "edit_questionnaire", method= RequestMethod.POST)
    public String showEditQuestionnaire(Model model){

        return "form_results";
    }

    @RequestMapping(value = "answer_result", method= RequestMethod.GET)
    public String showAnswerResults(JsonId passedTestId, Model model){
        PassedTest passedTest = service.find(PassedTest.class, passedTestId.getId());
        model.addAttribute("passedTest", passedTest);
        return "form_answer_result";
    }

    @RequestMapping(value = "questionnaire", method= RequestMethod.POST)
    public String showQuestionnaire(Questionnaire questionnaire, Model model){
        model.addAttribute("questionnaire", questionnaire);
        model.addAttribute("questions", service.find(Questionnaire.class, questionnaire.getId()).getQuestions());
        return "form_questionnaire";
    }

    @RequestMapping(value = "test_completed", method = RequestMethod.POST)
    public @ResponseBody boolean testCompleted(@RequestBody JsonPassedTest jsonPassedTest) {
        Set<Answer> answerSet = new HashSet<>();
        /*конвертируем ответы*/
        for (JsonAnswer jsonAnswer : jsonPassedTest.getAnswers()){
            IFactory factory = answerFactory.getFactoryFromId(jsonAnswer.getClassName());
            if (factory != null){
                Answer answer = factory.getAnswer(jsonAnswer);
                if (answer != null){
                    service.persist(answer);
                    answerSet.add(answer);
                }
            }
        }
        PassedTest passedTest = new PassedTest(service.find(User.class, jsonPassedTest.getUserId()),
                service.find(Questionnaire.class, jsonPassedTest.getQuestionnaireId()),
            jsonPassedTest.getDate(), answerSet);
        service.persist(passedTest);
        return true;
    }

    @RequestMapping(value = "action_login", method = RequestMethod.POST)
    public String login(@Valid JsonUser jsonUser, BindingResult bindingResult, Model model) {
        /*данные не прошли валидацию*/
        if (bindingResult.hasErrors()) {
            model.addAttribute("error_message", Utils.getInstance().getErrorInputData());
            return "form_login";
        }

        User user = service.isExist(jsonUser.getName(), jsonUser.getPassword());
        /*пользователя с таким логином и паролем не существует*/
        if (user == null) {
            model.addAttribute("error_message", Utils.getInstance().getErrorInputLogin());
            return "form_login";
        }
        model.addAttribute("user", user);
        model.addAttribute("questionnaires", service.findAll(Questionnaire.tableName));
        return "form_main";
    }

    @RequestMapping(value = "action_register", method = RequestMethod.POST)
    public String registration(@Valid JsonUser jsonUser, BindingResult bindingResult, Model model) {
        Utils utils = Utils.getInstance();
        /*данные не прошли валидацию*/
        if (bindingResult.hasErrors()){
            model.addAttribute("error_message", utils.getErrorInputData());
            return "form_login";
        }
        User user = service.isExist(jsonUser.getName());
        /*Такой пользователь уже существует*/
        if (user != null) {
            model.addAttribute("error_message", utils.getErrorNameExist());
            return "form_login";
        }
        User newUser = new User(jsonUser.getName(), jsonUser.getPassword());
        service.persist(newUser);
        model.addAttribute("user", newUser);
        model.addAttribute("questionnaires", service.findAll(Questionnaire.tableName));
        return "form_main";
    }


}
