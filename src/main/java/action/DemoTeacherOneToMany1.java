package action;

import model.Student;
import model.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtils;

import java.util.LinkedHashSet;

public class DemoTeacherOneToMany1 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();

            Teacher teacher = new Teacher();
            teacher.setTeacherName("Gary");
            Student student = new Student();
            student.setStudnetName("s1");
            Student student1 = new Student();
            student1.setStudnetName("s2");

//
            LinkedHashSet<Student> studentSet = new LinkedHashSet<>();
            studentSet.add(student);
            studentSet.add(student1);
            teacher.setStudents(studentSet);
//
            student.setTeacher(teacher);
            student1.setTeacher(teacher);

            session.saveOrUpdate(teacher);

            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            HibernateUtils.closeSessionFactory();
        }
    }
}
