package model.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Created by Marz on 2015-05-03.
 * Magiczna klasa operujaca na podstawowych warstwach hibernate'a
 * EntityManager jest jakby Wraperem na to co trzeba pisac przy pomocy tej klasy i
 * sesji rêcznie.
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory=null;

    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml)
            // config file.
            Configuration configuration=new Configuration();
            configuration.configure();
            ServiceRegistry sr= new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            sessionFactory = configuration.buildSessionFactory(sr);
            System.out.print("SessionFactory creating complite.\n");
        } catch (Throwable ex) {
            // Log the exception.
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
