package com.caching;

import com.tut.entity.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SecondLevelCache {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        Session session = factory.openSession();

        Student student = session.get(Student.class,1);
        System.out.println(student);
        System.out.println("First session closed");
        session.close();

        Session session1 = factory.openSession();
        Student student1 = session1.get(Student.class,1);
        System.out.println(student1);
        System.out.println("Second Session");
        session.close();

    }
}
