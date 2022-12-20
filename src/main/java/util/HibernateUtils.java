package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtils {
    /*
    static 初始化一次
    final 不能改變值
     */
    private static final SessionFactory sessionFactory=createSessionFactory();

    private static SessionFactory createSessionFactory(){
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        return sessionFactory;
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
    public static void closeSessionFactory(){
        if(sessionFactory!=null){
            sessionFactory.close();
        }
    }
}
