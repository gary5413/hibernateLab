package model.dao;

import model.Test;

import java.util.List;

public interface TestDao {

    void save(Test test);

    Test findById(Integer testId);

    List<Test> findAll();

    void saveOrUpdate(Test test);

    boolean delete(Integer testId);
}
