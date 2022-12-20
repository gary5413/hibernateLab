package action;

import model.HouseBean;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtils;

public class DemoHouseBeanAction3 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        HouseBean houseBean = new HouseBean();
        houseBean.setHouseName("getCurrentSession house");
        session.save(houseBean);

        session.getTransaction().commit();

        HibernateUtils.closeSessionFactory();

    }
}
