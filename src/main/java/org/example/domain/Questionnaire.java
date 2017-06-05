package org.example.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Kuzmin Evgeny on 17.05.2017.
 * Опросник. Содержит коллекцию вопросов, принадлежащих данному опроснирку {@link Question}
 */
@Entity
public class Questionnaire {

    @Transient
    public static final String tableName = "Questionnaire";

    private Integer id;

    /**
     * Название опросника
     */
    private String label;

    /**
     * все вопросы опросника
     */
    private Set<Question> questions;

    public Questionnaire(String label) {
        this.label = label;
    }

    public Questionnaire(String label, Set<Question> questions) {
        this.label = label;
        this.questions = questions;
    }

    public Questionnaire() {
    }

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }
}
