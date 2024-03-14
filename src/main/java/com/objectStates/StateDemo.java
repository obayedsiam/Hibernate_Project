package com.objectStates;

import com.tut.entity.Certificate;
import com.tut.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
Hibernate/Persistence Lifecycle states:

        Transient State :
        When the properties of Objects are set

        Persistent state:
        session.save()/persist()/update() is called in persistent state. Then it is moved to table in the database. And the object is associated with session.

        Detached State:
        session.close()/clear() is called then object is not associated with the session but value is present in database.

        Removed state:
        session.delete() is called then database values will be removed. But object is connected with session.
 **/


public class StateDemo {
    public static void main(String[] args) {
        SessionFactory cf =  new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = cf.openSession();
        Student student = new Student();
        student.setName("Simon");
        student.setCertificate(new Certificate("Hibernate", "2 months"));
        //Up to the above code, Student object is in Transient state

        Transaction transaction = session.beginTransaction();
        session.persist(student);
        // Student is in Persistent state

        student.setName("Jabir");
        transaction.commit();
        cf.close();
        // Student is in Detached State



    }
}
