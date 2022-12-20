package action;

import model.Book;
import model.BookDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtils;

public class DemoOneToOneAction {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            System.out.println("begin tx");

            Book book = new Book("book1", "gary", 456);
            BookDetail bookDetail = new BookDetail("ispan", "中壢");
//            互相加入
            book.setBookDetail(bookDetail);
            bookDetail.setBook(book);

            session.saveOrUpdate(book);

            session.getTransaction().commit();
            System.out.println("tx commit");
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            HibernateUtils.closeSessionFactory();
        }
    }
}
