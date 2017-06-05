package org.example.json_objects;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;
import java.util.List;

/**
 * Created by Kuzmin Evgeny on 22.05.2017.
 */
public class JsonPassedTest {
    private List<JsonAnswer> answers;
    private Integer userId;
    private Integer questionnaireId;
    private Date date;

    public JsonPassedTest(List<JsonAnswer> answers, Integer userId, Integer questionnaireId, Date date) {
        this.answers = answers;
        this.userId = userId;
        this.questionnaireId = questionnaireId;
        this.date = date;
    }

    public JsonPassedTest() {
    }

    public List<JsonAnswer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<JsonAnswer> answers) {
        this.answers = answers;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(Integer questionnaireId) {
        this.questionnaireId = questionnaireId;
    }
}
