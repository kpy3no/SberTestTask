package org.example.domain;

import javax.persistence.Entity;
import javax.persistence.Transient;

/**
 * Created by palevo on 17.05.2017.
 * Обычный строковый ответ.
 */
@Entity
public class StringAnswer extends Answer {

    private String answer;

    @Transient
    public static final String tableName = "StringAnswer";

    public StringAnswer(String answer, Question question) {
        super(question);
        this.answer = answer;
    }

    public StringAnswer() {
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
