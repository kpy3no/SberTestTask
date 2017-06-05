package org.example.domain;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Evgeny Kuzmin on 16.05.2017.
 * Сущность вопрос.
 * @see FactorialMultipleQuestion
 * @see FactorialQuestion
 */
@Entity
@Inheritance
public class Question {
    private Integer id;
    @Column(unique = true)
    private String question;

    public Question() {
    }

    public Question(String question) {
        this.question = question;
    }

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    private void setId(Integer id){
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                '}';
    }
}
