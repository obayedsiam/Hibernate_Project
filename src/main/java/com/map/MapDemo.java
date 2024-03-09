package com.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class MapDemo {

    public static void main(String[] args) {
        System.out.println("Project started");

        //Hibernate Configuration File Connection
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        //Session Factory Object
        SessionFactory factory = cfg.buildSessionFactory();

        Question question = new Question();
        question.setId(1212);
        question.setQuestion("What is Java");

        Answer answer = new Answer();
        answer.setId(343);
        answer.setAnswer("Java is a programming language");
        answer.setQuestion(question);

        Answer answer1 = new Answer();
        answer1.setId(344);
        answer1.setAnswer("Can develop software with Java");
        answer1.setQuestion(question);

        Answer answer2 = new Answer();
        answer2.setId(345);
        answer2.setAnswer("Can develop android apps with Java");
        answer2.setQuestion(question);

        List<Answer> answerList = new ArrayList<>();
        answerList.add(answer);
        answerList.add(answer1);
        answerList.add(answer2);

        question.setAnswers(answerList);



        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(question);
        session.persist(answer);
        session.persist(answer1);
        session.persist(answer2);
        transaction.commit();

        Question fetch = session.get(Question.class, 1212);
        System.out.println("Printing question");
        System.out.println(fetch);

        session.close();
        factory.close();




    }
}
