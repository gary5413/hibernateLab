package action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtils;

public class DemoGetCurrentSession {
    public static void main(String[] args) {
        /*
        沒有在hibernate.cfg.xml 設定 <property name="current_session_context_class">thread</property>
        就會報錯：No CurrentSessionContext configured!
         */
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session1 = sessionFactory.getCurrentSession();
        Session session2 = sessionFactory.getCurrentSession();
        System.out.println(session1);
        System.out.println(session2);

        HibernateUtils.closeSessionFactory();
    }
}
