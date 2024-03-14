package com.oneToMany;

import javax.persistence.*;

import java.util.List;

@Entity
public class Question {

    @Id
    private int id;
    private String question;

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Answer> answers;

    public Question() {
        super();
    }

    public Question(int id, String question, List<Answer> answers) {
        super();
        this.id = id;
        this.question = question;
        this.answers = answers;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

//    @Override
//    public String toString() {
//
//        String ret = "Question : " + getQuestion() + "\n" +
//                "ID : " + getId() + "\n";
//
//        for (Answer answer : getAnswers()) {
//            ret = ret + answer.getAnswer() + "\n";
//        }
//
//        return ret;
//    }
}
