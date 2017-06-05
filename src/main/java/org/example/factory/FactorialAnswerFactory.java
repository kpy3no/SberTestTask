package org.example.factory;

import org.example.domain.*;
import org.example.json_objects.JsonAnswer;
import org.example.service.IService;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Kuzmin Evgeny on 22.05.2017.
 * Фабрика, которая создает объект класса {@link FactorialAnswer}
 */
public class FactorialAnswerFactory extends BaseAnswerFactory {
    public FactorialAnswerFactory(IService service) {
        super(service);
    }

    @Override
    protected Answer createAnswer(JsonAnswer jsonAnswer) {
        FactorialQuestion question = service.find(FactorialQuestion.class, jsonAnswer.getQuestionId());
        AnswerVariant variant = service.find(AnswerVariant.class, Integer.parseInt((String) jsonAnswer.getValue()));
        return new FactorialAnswer(question, variant);
    }

}
