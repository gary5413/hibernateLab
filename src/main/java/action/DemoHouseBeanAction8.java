package action;

import model.HouseBean;
import service.HouseService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtils;

public class DemoHouseBeanAction8 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            System.out.println("transaction begin");

            HouseService houseService = new HouseService(session);
            HouseBean houseBean = houseService.selectById(2);
            System.out.println(houseBean.getHouseId()+","+houseBean.getHouseName());


            session.getTransaction().commit();
            System.out.println("transaction commit");
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            HibernateUtils.closeSessionFactory();
        }
    }
}
