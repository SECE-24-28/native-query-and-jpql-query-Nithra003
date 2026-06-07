package com.example.data.JPAdemo.Repository;

import com.example.data.JPAdemo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface Repo extends JpaRepository<Student, Integer> {

    List<Student> findByGenderAndTech(String gender, String tech);

    List<Student>findByTech(String tech);

    @Query(nativeQuery = true,
    value="SELECT * FROM student where gender=:gender AND tech=:tech")

    List<Student>findByGenAndTech(
            @Param("gender") String gender,
            @Param("tech") String tech
    );

    @Query("SELECT s FROM Student s WHERE s.name='Nithra'")
    List<Student> findByName();


}