package action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtils;

public class DemoOpenSession {
    public static void main(String[] args) {
        /*
        opnesession No Thread safe

         */
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session1 = sessionFactory.openSession();
        Session session2 = sessionFactory.openSession();
        System.out.println(session1);
        System.out.println(session2);

        session1.close();
        session2.close();

        HibernateUtils.closeSessionFactory();
    }
}
