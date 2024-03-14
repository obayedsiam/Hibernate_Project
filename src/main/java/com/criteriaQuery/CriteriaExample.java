package com.criteriaQuery;

import com.tut.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class CriteriaExample {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<Student> criteriaQuery = builder.createQuery(Student.class);
        Root<Student> root = criteriaQuery.from(Student.class);

        Predicate predicate = builder.equal(root.get("certificate").get("course"),"Android");

        criteriaQuery.where(predicate);

        List<Student> list = session.createQuery(criteriaQuery).getResultList();

        for(Student s: list){
            System.out.println(s);
        }

    }
}
