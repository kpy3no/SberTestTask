package org.example.factory;

import org.example.domain.*;
import org.example.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Kuzmin Evgeny on 22.05.2017.
 * Фабрика объектов, наследуемых от {@link IFactory}
 */
@Component
public class AnswerFactory {
    @Autowired
    private IService service;

    public IFactory getFactoryFromId(String id){
        switch (id){
            case FactorialAnswer.tableName:
                return new FactorialAnswerFactory(service);
            case FactorialMultipleAnswer.tableName:
                return new FactorialMultipleAnswerFactory(service);
            case StringAnswer.tableName:
                return new StringAnswerFactory(service);
        }
        return null;
    }
}
