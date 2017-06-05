package org.example.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.Set;

/**
 * Created by Kuzmin Evgeny on 20.05.2017.
 * Факторный многозначный вопрос (возможность двух и более ответов из предложеннных вариантов {@link AnswerVariant}
 */
@Entity
public class FactorialMultipleQuestion extends Question {
    private Set<AnswerVariant> answerVariants;


    public FactorialMultipleQuestion() {
    }

    public FactorialMultipleQuestion(String question, Set<AnswerVariant> answerVariants) {
        super(question);
        this.answerVariants = answerVariants;
    }

    public FactorialMultipleQuestion(String question) {
        super(question);
    }

    @ManyToMany(fetch = FetchType.EAGER)
    public Set<AnswerVariant> getAnswerVariants() {
        return answerVariants;
    }

    public void setAnswerVariants(Set<AnswerVariant> answerVariants) {
        this.answerVariants = answerVariants;
    }
}
