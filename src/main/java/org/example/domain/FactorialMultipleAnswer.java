package org.example.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Kuzmin Evgeny on 20.05.2017.
 * Факторный многозначный ответ. Содержит множество вариантов ответа сущности {@link AnswerVariant}
 * Соответственно поставляется в паре с факторным многозначным вопросом  {@link FactorialMultipleQuestion}
 */
@Entity
public class FactorialMultipleAnswer extends Answer {
    private Set<AnswerVariant> answers;

    @Transient
    public static final String tableName = "FactorialMultipleAnswer";

    public FactorialMultipleAnswer() {
    }

    public FactorialMultipleAnswer(FactorialMultipleQuestion question, Set<AnswerVariant> answers) {
        super(question);
        this.answers = answers;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    public Set<AnswerVariant> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<AnswerVariant> answers) {
        this.answers = answers;
    }
}
