package com.example.exercise2;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

    //Exercise 4
    List<Student> findByAgeGreaterThan(int x);

    int countByieltsScore(double x);

    List<Student> findByNameContaining(String x);

    //Exercise 5
    @Query("SELECT s FROM Student s WHERE s.age >= :x")
    List<Student> findStudentByAge(@Param("x") int x);

    @Query("SELECT COUNT(ieltsScore) AS x FROM Student Where ieltsScore = 9.0")
    int countStudent9IelesScore(@Param("x") double x);

    @Query("SELECT s FROM Student s WHERE lower(s.name) LIKE %:name%")
    List<Student> nameStudentContaining(@Param("name") String x);

}
