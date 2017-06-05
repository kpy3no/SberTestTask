package org.example.factory;

import org.example.domain.*;
import org.example.json_objects.JsonAnswer;
import org.example.service.IService;
import org.springframework.stereotype.Component;

/**
 * Created by Kuzmin Evgeny on 22.05.2017.
 * Фабрика, которая создает объект класса {@link StringAnswer}
 */
public class StringAnswerFactory extends BaseAnswerFactory {

    public StringAnswerFactory(IService service) {
        super(service);
    }

    @Override
    protected Answer createAnswer(JsonAnswer jsonAnswer) {
        Question question = service.find(Question.class, jsonAnswer.getQuestionId());
        return new StringAnswer(jsonAnswer.getValue().toString(), question);
    }
}
