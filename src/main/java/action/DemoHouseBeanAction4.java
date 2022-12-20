package action;

import model.HouseBean;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtils;

import java.io.Serializable;

public class DemoHouseBeanAction4 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try{
            session.beginTransaction();

            HouseBean houseBean = new HouseBean();
//          houseBean.setHouseId(1001);
            houseBean.setHouseName("persist house");
//          save() serializable 傳回值: 物件的 ID (OID)，也是該資料的 ID，為 Serializable 型別
//          執行Insert指令，成功則會回傳Primary Key
            Serializable result= session.save(houseBean);
            System.out.println(result);
//          不見得立刻將Primary Key值指定給Bean物件，有可能等到 Session.flush()時才執行Insert
//          session.persist(houseBean);
//          強制送出 同步目前永續物件內容與資料庫資料。
//以下狀況 Hibernate 會預先自動執行 flush() 方法

//          session.flush();

            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            HibernateUtils.closeSessionFactory();
        }
    }
}
