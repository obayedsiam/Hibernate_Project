package com.tut;

import com.tut.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
    public static void main(String[] args) {
        System.out.println("Project started");

        //Hibernate Configuration File Connection
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        //Session Factory Object
        SessionFactory factory = cfg.buildSessionFactory();

        // Session Object
        Session session = factory.openSession();

        // Getting student from Database through session
        Student student = session.get(Student.class, 1);
        System.out.println(student);

        // Closing session and factory
        session.close();
        factory.close();

    }
}
