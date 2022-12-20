package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "Filter",urlPatterns = "/*")
public class OpenSessioninVeiwFilter implements Filter {
    private Session session;
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        try{
            SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
//            this.session=sessionFactory.getCurrentSession();
            this.session=sessionFactory.openSession();
            System.out.println("session filter:"+session);
            session.beginTransaction();
            System.out.println("Begin Transaction");
/*
讓 Session 保持開啟直到 View 執行結束
新建一個Filter,在它的doFilter()方法內呼叫 SessionFactory 的 getCurrentSession()取出 Session 物件、
接著啟動交易(beginTransaction()),然後呼叫chain.doFilter(req, resp)由被監控
的資源開始執行其應有的工作(例如多個表格資料的新增、删除、修改、查詢等)，
等到該資源 執行完所有的資料庫存取後再度回到Filter，如果一切正常，執行交易的Commit()，
若執行被 監控的資源時拋出任何例外，執行交易的rollback()。
 */
            chain.doFilter(request, response);
            session.getTransaction().commit();
            System.out.println("Commit!!");
            session.close();
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            System.out.println("Transaction ROLLBACK!!!");
        }finally {
            System.out.println("Session back to Connetion Pool!");
        }

    }
}
