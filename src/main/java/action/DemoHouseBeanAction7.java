package action;

import model.HouseBean;
import model.dao.HouseDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import util.HibernateUtils;

import java.util.Iterator;
import java.util.List;

public class DemoHouseBeanAction7 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            System.out.println("transaction begin");

            HouseDao houseDao = new HouseDao(session);
//            HouseBean houseBean = new HouseBean();
//            houseBean.setHouseName("dao test house");
//            houseDao.insert(houseBean);

            System.out.println("-------------------------------");
            HouseBean bean = houseDao.selectById(1);
            if (bean != null) {
                System.out.println(bean.getHouseId() + "," + bean.getHouseName());
            } else {
                System.out.println("no reslut");
            }
            System.out.println("-------------------------------");
            List<HouseBean> list = houseDao.selectAll();
            for (HouseBean houseBean:list) {
                System.out.println(houseBean.getHouseId()+","+houseBean.getHouseName());
            }
            System.out.println("-------------------------------");

            HouseBean update_house = houseDao.update(6, "update house");
            System.out.println(update_house.getHouseId()+","+update_house.getHouseName());

            System.out.println("-------------------------------");

            boolean status = houseDao.delete(7);
            if(status){
                System.out.println("data delete");
            }else {
                System.out.println("no data delete");
            }
            System.out.println("-------------------------------");
            List<HouseBean> list1 = houseDao.selectAll();
            for (HouseBean houseBean:list) {
                System.out.println(houseBean.getHouseId()+","+houseBean.getHouseName());
            }
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
