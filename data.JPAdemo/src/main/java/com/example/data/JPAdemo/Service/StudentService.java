package com.example.data.JPAdemo.Service;

import com.example.data.JPAdemo.Dto.StudentDto;
import com.example.data.JPAdemo.Repository.Repo;
import com.example.data.JPAdemo.model.Student;
import jakarta.validation.Valid;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class StudentService {
 @Autowired
    Repo r;
    public List<Student> getAllStudents() {
        return r.findAll();
    }

    public String addStudent(Student student1) {
        r.save(student1);
        return "Added Successfully";
    }

//    public Student getStudentByRollNo(int rno) {
//        return r.findById(rno).orElse(new Student());
//    }

    public String updateStudent(Student student1) {
        r.save(student1);
        return "Updated Successfully";
    }

    public String deleteStudent(int rno) {
       r.deleteById(rno);
        return "Deleted Successfully";
    }

    public String deleteAllStudents() {
       r.deleteAll();
        return "Deleted All Students Successfully";
    }

    public List<Student> getAllStudentByGenderAndTech(String gender, String tech) {
        return r.findByGenderAndTech(gender, tech);
    }

    public List<Student> getStudentByTech(String tech) {

        return r.findByTech(tech);
    }

    public List<Student> getStudentByGenAndTech(String gender, String tech) {
        return r.findByGenAndTech(gender,tech);
    }

    public List<Student> getStudentByname() {

        return r.findByName();
    }

    public StudentDto getAllStudentByRollno(int rno) {
       Student s=r.findById(rno).orElseThrow();
       return converStudentToDto(s);
    }

    public StudentDto converStudentToDto(Student s) {
        StudentDto std=new StudentDto();
        std.setRno(s.getRollNo());
        std.setName(s.getName());
        std.setGender(s.getGender());
        std.setTech(s.getTech());
        std.setEmail(s.getEmail());

        return std;

    }

    public StudentDto addStudents( StudentDto std) {
       Student student= r.save(convertDtoStudent(std));
       return converStudentToDto(student);


    }
    public Student convertDtoStudent(StudentDto std1) {
        Student s1 = new Student();
        s1.setRollNo(std1.getRno());
        s1.setName(std1.getName());
        s1.setGender(std1.getGender());
        s1.setTech(std1.getTech());
        s1.setEmail(std1.getEmail());
        s1.setPassword(s1.getPassword());

        return s1;
    }

    public Page<Student> getAllStudent(int page, int size) {

        return r.findAll(
                PageRequest.of(page,size)
        );
    }
}
