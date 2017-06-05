package org.example.domain;

import javax.persistence.*;

/**
 * Created by Evgeny Kuzmin on 17.05.2017.
 * Факторный ответ. Содержит ссылку на вариант ответа сущности {@link AnswerVariant}
 */
@Entity
public class FactorialAnswer extends Answer {
    private AnswerVariant answer;

    @Transient
    public static final String tableName = "FactorialAnswer";

    public FactorialAnswer() {
    }

    public FactorialAnswer(FactorialQuestion question, AnswerVariant answer) {
        super(question);
        this.answer = answer;
    }

    @ManyToOne
    public AnswerVariant getAnswer() {
        return answer;
    }

    public void setAnswer(AnswerVariant answer) {
        this.answer = answer;
    }

}
