package ru.stqa.pft.srt.mantis.appmanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.stqa.pft.srt.mantis.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class DbHelper {
  private final SessionFactory sessionFactory;

  public DbHelper() {
    // A SessionFactory is set up once for an application!
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure() // configures settings from hibernate.cfg.xml
            .build();
    sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

  }

  public List<ContactData> contacts() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<ContactData> result = session.createQuery("from ContactData").list();
    for (ContactData contacts : result) {
      System.out.println(contacts);
    }
    session.getTransaction().commit();
    session.close();
    return new ArrayList<>(result);
  }

}
