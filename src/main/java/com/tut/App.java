package com.tut;

import com.tut.entity.Address;
import com.tut.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

public class App {
    public static void main(String[] args) throws IOException {
        System.out.println("Project started");

        //Hibernate Configuration File Connection
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        //Session Factory Object
        SessionFactory factory = cfg.buildSessionFactory();

        // Student Object
        Student st = new Student();
        st.setName("Jamal");
        st.setCity("Sylhet");

        // Address Object
        Address address = new Address();
        address.setStreet("Airport Road");
        address.setCity("Lauwachara");
        address.setOpen(false);
        address.setAddedDate(new Date());

        // Image File reading
        try {
            FileInputStream fis = new FileInputStream(new File("src/main/java/Profile.png"));
            byte[] image = new byte[fis.available()];
            fis.read(image);
            address.setImage(image);
        } catch (IOException exception) {
            System.out.println("Exception : " + exception.getMessage());
        }

        // Session Object from Session Factory
        Session session = factory.openSession();

        // Transaction Object from session
        Transaction transaction = session.beginTransaction();

        //Inserting Student and Address Object into database through session
        session.persist(st);
        session.persist(address);

        // Committing (Final pushing into Database) Transaction
        transaction.commit();

        //Closing Session and Factory Objects
        session.close();
        factory.close();

    }
}
