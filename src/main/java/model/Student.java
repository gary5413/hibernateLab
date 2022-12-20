package model;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "studentName")
    private String studnetName;

    @Column(name = "fk_teacher_id")
    @Transient
    private int teacherId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_teacher_id")
    private Teacher teacher;

    public Student() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudnetName() {
        return studnetName;
    }

    public void setStudnetName(String studnetName) {
        this.studnetName = studnetName;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
