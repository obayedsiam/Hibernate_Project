package com.caching;

import com.tut.entity.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/***

 Here, we explicitly defined for second level caching. That is inside xml file.
 (<property name="cache.region.factory_class">org.hibernate.cache.ehcache.internal.EhcacheRegionFactory</property>)
 Here, even if the session is closed then the session will not get the object through session factory
 This is called second level caching

 ***/

public class SecondLevelCache {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        Session session = factory.openSession();

        System.out.println("\nDemonstrating Second Level Caching");

        Student student = session.get(Student.class,1);

        System.out.println("\nQuery fired due to get operation");

        System.out.println(student);
        System.out.println("\nFirst session closed\n");
        session.close();

        Session session1 = factory.openSession();
        Student student1 = session1.get(Student.class,1);
        System.out.println("\nQuery not fired even after get operation");
        System.out.println(student1);
        System.out.println("\nSecond Session\n");
        session.close();

        System.out.println("Here, you see, only a single query is fired and \n" +
                "even after closing the session, \n" +
                "the student object was found. This was done by session factory. \n" +
                "And this is second level caching");

    }
}
