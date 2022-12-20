package model;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "Teacher")
public class Teacher {
    @Id @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "teacherName")
    private String teacherName;
//  mappedBy 對映的 是對方的屬性 而不是類別 注意
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "teacher",cascade = CascadeType.ALL)
    private Set<Student> students=new LinkedHashSet<Student>();

    public Teacher(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
