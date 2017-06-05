package org.example.domain;

import javax.persistence.*;

/**
 * Абстрактная сущность - ответ. Содержит ссылку на Вопрос.
 * @see FactorialAnswer
 * @see FactorialMultipleAnswer
 * @see StringAnswer
 */
@Entity
@Inheritance
public abstract class Answer {
    private Integer id;
    private Question question;

    public Answer() {
    }

    public Answer(Question question) {
        this.question = question;
    }

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    private void setId(Integer id) {
        this.id = id;
    }

    public void setQuestion(FactorialQuestion question) {
        this.question = question;
    }

    @ManyToOne
    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
