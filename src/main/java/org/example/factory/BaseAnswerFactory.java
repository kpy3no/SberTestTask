package org.example.factory;

import org.example.domain.Answer;
import org.example.json_objects.JsonAnswer;
import org.example.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Kuzmin Evgeny on 22.05.2017.
 * Базовая абстрактная фабрика, для избежания повторения кода
 */
public abstract class BaseAnswerFactory implements IFactory{

    protected IService service;

    public BaseAnswerFactory(IService service) {
        this.service = service;
    }

    protected abstract Answer createAnswer(JsonAnswer jsonAnswer);

    @Override
    public Answer getAnswer(Object object) {
        if (object instanceof JsonAnswer == false)
            return null;
        return createAnswer((JsonAnswer) object);
    }
}
