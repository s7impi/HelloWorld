package model.dao;




import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;




/**
 * Created by Marz on 2015-05-03.
 */
public class main {
    public static void main(String[] args) {
        Session session = null;

        try{
            // W tym kroku odczytamy plik hibernate.cfg.xml i przygotujemy Hibernate do u¿ycia      SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            //Stworzenie nowego obiektu Contact i ustawienie jego atrybutów
            System.out.println("Inserting Record");
            UserDB contact = new UserDB();
            contact.setId(3);
            contact.setName("Jan");
            contact.setPassword("Kowalski");
            //zapisanie zmian dokonanych od ostatniego zapisu
            session.save(contact);
            System.out.println("Done");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            // wymuszenie wys³ania "oczekuj¹cych" operacji do bazy danych
            session.flush();
            // zamkniêcie sesji
            session.close();
        }
    }
}
