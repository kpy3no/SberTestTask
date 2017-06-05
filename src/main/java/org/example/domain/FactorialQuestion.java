package org.example.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.Set;

/**
 * Created by Evgeny Kuzmin on 16.05.2017.
 * Факторный вопрос.
 */
@Entity
public class FactorialQuestion extends Question {

    private Set<AnswerVariant> answerVariants;


    public FactorialQuestion() {
    }

    public FactorialQuestion(String question, Set<AnswerVariant> answerVariants) {
        super(question);
        this.answerVariants = answerVariants;
    }

    public FactorialQuestion(String question) {
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
