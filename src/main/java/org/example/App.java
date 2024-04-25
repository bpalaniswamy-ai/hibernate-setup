package org.example;

import org.example.vo.Alien;
import org.example.vo.Laptop;
import org.example.vo.Store;
import org.example.vo.Student;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {


        Configuration configuration = new Configuration().configure()
                .addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class).addAnnotatedClass(Store.class).addAnnotatedClass(Alien.class);
        ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        SessionFactory sessionFactory = configuration.buildSessionFactory(registry);

        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Alien where id = 1");
        query.setCacheable(true);
        List<Alien> list = query.list();
        for (Alien a:
             list) {
            System.out.println(a.toString());
        }
        session.close();

//        Session session2 = sessionFactory.openSession();
//        Query query2 = session2.createQuery("from Alien where id = 1");
//        query2.setCacheable(true);
//        Alien alien2 = (Alien) query2.uniqueResult();
//        System.out.println(alien2.toString());
//        session2.close();

    }

    public void saveOneTOOne() {

    }
}
