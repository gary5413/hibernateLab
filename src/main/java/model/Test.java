package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "testTable")
public class Test implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_Id")
    private Integer testId;
    @Column(name = "test_Name")
    private String testName;

    public Integer getTestId() {
        return testId;
    }

    public Test() {
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }
}
