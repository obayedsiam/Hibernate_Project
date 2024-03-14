package com.caching;

import com.tut.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FirstLevelCachingDemo {

    /***
     Here after creating the session object if the Student object is called then at th first place a query is fired
     But in second time when the object is called the query is not fired, because it is in the session.
     If the session is closed then the session will not get the object.

     This is called first level caching
     ***/

    public static void main(String[] args) {
        SessionFactory cf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = cf.openSession();

        //Student object is called and query is fired (See the log)
        Student student = session.get(Student.class, 1);
        // Student value printed
        System.out.println(student);

        System.out.println("Working");

        // Again student is searched. But this time the query is not fired to database rather taken from session.
        Student student1 = session.get(Student.class, 1);

        System.out.println(student1);

        //Session is closed.
        session.close();

        session = cf.openSession();


        //Student object is called and query is fired (See the log)
        Student student3 = session.get(Student.class, 1);
        // Student value printed
        System.out.println(student3);

        session.close();
    }
}
