package dao;

import model.Test;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import util.HibernateUtils;

import java.util.List;

public class TestDaoImpl implements TestDao {
    private SessionFactory sessionFactory;
//    private Session session;
//    SessionFactory sessionFactory =HibernateUtils.getSessionFactory();
    public TestDaoImpl(){
        this.sessionFactory=HibernateUtils.getSessionFactory();
//        this.session=session.getSession();
    }

    @Override
    public void save(Test test) {
        Session session = sessionFactory.getCurrentSession();
//        Session session = sessionFactory.openSession();
        System.out.println("session dao:"+session);
        session.save(test);
        session.close();
    }

    @Override
    public Test findById(Integer testId){
        Session session = sessionFactory.getCurrentSession();
        return session.get(Test.class,testId);
    }
    @Override
    public List<Test> findAll(){
        Session session = sessionFactory.getCurrentSession();
        Query<Test> query = session.createQuery("from Test", Test.class);
        return query.list();
    }
    @Override
    public void saveOrUpdate(Test test){
        Session session = sessionFactory.getCurrentSession();
        System.out.println("session dao:"+session);
        System.out.println("name dao:"+test.getTestName());
        session.saveOrUpdate(test);
        System.out.println("saveOrUpdate");

    }
    @Override
    public boolean delete(Integer testId){
        Session session = sessionFactory.getCurrentSession();
        Test test = session.get(Test.class, testId);
        if(test!=null){
            session.delete(test);
            return  true;
        }
        return  false;
    }
}

