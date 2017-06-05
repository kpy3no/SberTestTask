package org.example.factory;

import org.example.domain.Answer;

/**
 * Created by Kuzmin Evgeny on 22.05.2017.
 */
public interface IFactory {
    Answer getAnswer(Object object);
}
