package org.example.json_objects;

/**
 * Created by Kuzmin Evgeny on 20.05.2017.
 * Json сущность.
 */
public class JsonAnswer {
    private String className;
    private Integer questionId;
    private Object value;

    public JsonAnswer(String className, Integer questionId, Object value) {
        this.className = className;
        this.questionId = questionId;
        this.value = value;
    }

    public JsonAnswer() {
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
