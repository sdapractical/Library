package Config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    public static SessionFactory getSessionFactory() {

        return new Configuration()
                .configure("hibernate.cfg.xml")
//                .addAnnotatedClass(Book)
//                .addAnnotatedClass(Reader)
                .buildSessionFactory();
    }

}
