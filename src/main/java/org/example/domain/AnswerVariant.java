package org.example.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Evgeny Kuzmin on 17.05.2017.
 * Сущность - варианты ответов для факторного вопроса
 * К примеру: Как вы себя чувствуете?
 *            1- Прекрасно,   2- Нормально, 3- Плохо
 */
@Entity
public class AnswerVariant {
    private Integer id;

    @Column(unique = true)
    private String answer;

    public AnswerVariant(String answer) {
        this.answer = answer;
    }

    public AnswerVariant() {
    }

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    public Integer getId() {
        return id;
    }

    private void setId(Integer id){
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

}
