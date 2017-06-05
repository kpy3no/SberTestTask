package org.example.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by Evgeny Kuzmin on 17.05.2017.
 * Пройденный тест.
 */
@Entity
public class PassedTest {
    private Integer id;
    private User user;
    private Questionnaire questionnaire;
    private Date date;
    private Set<Answer> answerSet;

    @Transient
    public static final String tableName = "PassedTest";

    public PassedTest() {
    }

    public PassedTest(User user, Questionnaire questionnaire, Date date, Set<Answer> answersSet) {
        this.user = user;
        this.questionnaire = questionnaire;
        this.date = date;
        this.answerSet = answersSet;
    }

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    public Set<Answer> getAnswerSet() {
        return answerSet;
    }

    public void setAnswerSet(Set<Answer> answerSet) {
        this.answerSet = answerSet;
    }
}
