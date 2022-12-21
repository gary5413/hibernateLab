package controller;

import model.Test;
import dao.TestDaoImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "test",urlPatterns = "/testServlet")
public class TestController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("123");
        req.setCharacterEncoding("UTF-8");
        Test test1 = new Test();
        TestDaoImpl testDao = new TestDaoImpl();
//        test.setTestName(req.getParameter("testname"));
        test1.setTestName("Gary1");
        System.out.println("name:"+test1.getTestName());
//        testDao.saveOrUpdate(test);
//        testDao.saveOrUpdate(test1);
        testDao.save(test1);
        RequestDispatcher rd = req.getRequestDispatcher("/success.jsp");
        rd.forward(req,resp);

    }
}
