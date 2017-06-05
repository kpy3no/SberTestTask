package org.example.factory;

import org.example.domain.*;
import org.example.json_objects.JsonAnswer;
import org.example.service.IService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Kuzmin Evgeny on 22.05.2017.
 * Фабрика, которая создает объект класса {@link FactorialMultipleAnswer}
 */
public class FactorialMultipleAnswerFactory extends BaseAnswerFactory {

    public FactorialMultipleAnswerFactory(IService service) {
        super(service);
    }

    @Override
    protected Answer createAnswer(JsonAnswer jsonAnswer) {
        FactorialMultipleQuestion multipleQuestion = service.find(FactorialMultipleQuestion.class,
                jsonAnswer.getQuestionId());
        Set<AnswerVariant> set = new HashSet<>();
        int[] values = ((ArrayList<String>)jsonAnswer.getValue()).stream().mapToInt(i->Integer.parseInt(i)).toArray();
        for (int id : values){
            set.add(service.find(AnswerVariant.class, id));
        }
        return new FactorialMultipleAnswer(multipleQuestion, set);
    }




}
