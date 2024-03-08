package com.tut.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {
    public static void main(String[] args) {
        System.out.println("Project started");

        //Hibernate Configuration File Connection
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        //Session Factory Object
        SessionFactory factory = cfg.buildSessionFactory();

        // Session Object
        Session session = factory.openSession();

        Student student1 = new Student();
        student1.setName("Rahim");
        student1.setCity("Dhaka");

        Certificate certificate1 = new Certificate();
        certificate1.setCourse("Android");
        certificate1.setDuration("3 months");

        student1.setCertificate(certificate1);


        Student student2 = new Student();
        student2.setName("Jamal");
        student2.setCity("Khulna");

        Certificate certificate2 = new Certificate();
        certificate2.setCourse("Robotics");
        certificate2.setDuration("2 months");
        student2.setCertificate(certificate2);


        Transaction transaction = session.beginTransaction();

        session.persist(student1);
        session.persist(student2);

        transaction.commit();
        session.close();
        factory.close();
    }
}
