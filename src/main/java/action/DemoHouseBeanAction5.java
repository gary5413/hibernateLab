package action;

import model.HouseBean;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtils;

import java.io.Serializable;

public class DemoHouseBeanAction5 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try{
            session.beginTransaction();
            /*
             load() 方法用在讀取的永續物件是真實存在的，此方法會回傳一個代理(proxy)物件，其內只 有 id 屬性(欄位)有值，而沒有真正去讀取資料庫內的資料。如果後來發現永續物件不存在，程 式會丟出 ObjectNotFoundException。
- load() 方法會延遲讀取(lazy-loading, 該機制後面詳細說明) 永續物件，直到程式需要使用永 續物件的屬性時(ex: 執行永續物件的 getXXX() or toString())才真正對資料庫下達 SQL 敘述進 行讀取資料，此中機制稱為 Lazy-Loading，該機制後面詳細說明
             ObjectNotFoundException  No row with the given identifier exists
             */
//            HouseBean bean = session.load(HouseBean.class, 9);
            /*
            get()
            NullPointerException
             */
            HouseBean bean = session.get(HouseBean.class, 9);
            if(bean!=null){
                System.out.println(bean.getHouseId()+","+bean.getHouseName());
            }else {
                System.out.println("no result");
            }
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            HibernateUtils.closeSessionFactory();
        }
    }
}
