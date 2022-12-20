package action;

//import model.Friend;
//import model.Groups;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtils;

public class DemoManyToMany1 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try{
            session.beginTransaction();
            System.out.println("tx begin");

//            Friend friend = new Friend();
//            friend.setFriendName("Mary");
//            Friend friend1 = new Friend();
//            friend1.setFriendName("Gary");
//
//            session.save(friend);
//            session.save(friend1);
//
//            Groups groups = new Groups();
//            groups.setGroupName("Work");
//            Groups groups1 = new Groups();
//            groups1.setGroupName("Game");
//
//            session.save(groups);
//            session.save(groups1);
            /*
            flush()
            commit以前
            查詢雨以前
             */


            session.getTransaction().commit();
            System.out.println("tx commit");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("rollback");
            session.getTransaction().rollback();
        }finally {
            HibernateUtils.closeSessionFactory();
            System.out.println("sessionfactory close");
        }

    }
}
