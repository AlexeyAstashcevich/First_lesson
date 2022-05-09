package ru.stqa.pft.addressbook.appmanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.stqa.pft.addressbook.model.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DbHelper {
    private final SessionFactory sessionFactory;

    public DbHelper() {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

    }
        public Groups groups(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<GroupData> result = session.createQuery("from GroupData").list();
        for (GroupData groups : result) {
            System.out.println(groups);
        }
        session.getTransaction().commit();
        session.close();
        return new Groups(result);
    }

    public Contacts contacts(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<ContactData> result = session.createQuery("from ContactData").list();
        for (ContactData contacts : result) {
            System.out.println(contacts);
        }
        session.getTransaction().commit();
        session.close();
        return new Contacts(result);
    }

    public Set<ContactInGroup> contactsInGroups(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<ContactInGroup> result = session.createQuery("from ContactInGroup").list();
        for (ContactInGroup contacts : result) {
            System.out.println(contacts);
        }
        session.getTransaction().commit();
        session.close();
        return new HashSet<>(result);
    }

}
