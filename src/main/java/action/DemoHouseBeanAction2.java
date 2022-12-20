package action;

import model.HouseBean;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtils;

public class DemoHouseBeanAction2 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        HouseBean houseBean = new HouseBean();
        houseBean.setHouseName("test house");
        session.save(houseBean);

        session.getTransaction().commit();
        session.close();

        HibernateUtils.closeSessionFactory();

    }
}
