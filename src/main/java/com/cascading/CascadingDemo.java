package com.cascading;

import com.oneToMany.Answer;
import com.oneToMany.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
If we use cascading then the lists variables inside an Object don't need to be explicitly inserted into database.
 The list will automatically get inserted into the database
 **/


public class CascadingDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();

        Question question = new Question();

        question.setId(1213);
        question.setQuestion("What is Java");

        Answer answer = new Answer(343,"Java is a programming language");
        Answer answer1 = new Answer(344,"Can develop software with Java");
        Answer answer2 = new Answer(345,"Can develop android apps with Java");

        List<Answer> answerList = new ArrayList<>();

        answerList.add(answer);
        answerList.add(answer1);
        answerList.add(answer2);

        question.setAnswers(answerList);

        Transaction transaction = session.beginTransaction();
        session.persist(question);
        transaction.commit();



    }
}
