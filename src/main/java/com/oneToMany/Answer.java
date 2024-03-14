package com.oneToMany;

import javax.persistence.*;

@Entity
public class Answer {

    @Id
    private int id;
    private String answer;

    @ManyToOne
    private Question question;

    public Answer(int id, String answer) {
        this.id = id;
        this.answer = answer;
    }

    public Answer() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setQuestion(Question question){
        this.question = question;
    }
}
