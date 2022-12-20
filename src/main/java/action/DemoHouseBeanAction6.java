package action;

import model.HouseBean;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import util.HibernateUtils;

import java.util.Iterator;
import java.util.List;

public class DemoHouseBeanAction6 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try{
            session.beginTransaction();
            System.out.println("transaction begin");

            Query<HouseBean> query = session.createQuery("from HouseBean", HouseBean.class);
            List<HouseBean> list = query.list();

            Iterator<HouseBean> iterator = list.iterator();
            while (iterator.hasNext()){
                HouseBean bean = iterator.next();
                System.out.println(bean.getHouseId()+","+bean.getHouseName());
            }

            session.getTransaction().commit();
            System.out.println("transaction commit");
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            HibernateUtils.closeSessionFactory();
        }
    }
}
