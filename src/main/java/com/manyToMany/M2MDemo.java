package com.manyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M2MDemo {
    public static void main(String[] args) {
        System.out.println("Project started");

        //Hibernate Configuration File Connection
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        //Session Factory Object
        SessionFactory factory = cfg.buildSessionFactory();

        Employee e1 = new Employee();
        Employee e2 = new Employee();

        e1.setEid(12);
        e1.setName("Kausar");

        e2.setEid(13);
        e2.setName("Tonmoy");

        Project p1 = new Project();
        Project p2 = new Project();

        p1.setPid(32);
        p1.setName("Banbeis");

        p2.setPid(33);
        p2.setName("HIS");

        List<Project> projectList = new ArrayList<>();
        List<Employee> employeeList = new ArrayList<>();

        projectList.add(p1);
        projectList.add(p2);

        employeeList.add(e1);
        employeeList.add(e2);

        e1.setProjectList(projectList);
        e2.setProjectList(Arrays.asList(p1));

        p1.setEmployeeList(employeeList);
        p2.setEmployeeList(Arrays.asList(e1));



        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(e1);
        session.persist(e2);
        session.persist(p1);
        session.persist(p2);

        transaction.commit();
        session.close();
        factory.close();

    }
}
