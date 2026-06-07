package com.example.data.JPAdemo.Controller;

import com.example.data.JPAdemo.Dto.StudentDto;
import com.example.data.JPAdemo.Service.StudentService;
import com.example.data.JPAdemo.model.Student;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
public class StudentController {
    @Autowired
    StudentService sr;

    //getMapping
    @GetMapping("/get")
    public List<Student> getAllStudents(){
        return sr.getAllStudents();
    }

//    @GetMapping("/get/{rno}")
//    public Student getStudentByRollNo(@PathVariable("rno") int rno){
//        return sr.getStudentByRollNo(rno);
//    }

    //postMapping
//    @PostMapping("/add")
//    public String addStudent(@Validated @RequestBody Student student1){
//
//         sr.addStudent(student1);
//        return "added";
//
//    }

    //putMapping
    @PutMapping("/update")
    public String updateStudent(@RequestBody Student student1){

        return sr.updateStudent(student1);
    }

    //deleteMapping
    @DeleteMapping("/delete")
    public String deleteAllStudents(){

        return sr.deleteAllStudents();
    }

    @DeleteMapping("/delete/{rno}")
    public String deleteStudent(@PathVariable("rno") int rno){
        return sr.deleteStudent(rno);

    }

    @GetMapping("/student/custom")
    public List<Student> getStudentByGenderAndTech(
            @RequestParam String gender,
            @RequestParam String tech) {

        return sr.getAllStudentByGenderAndTech(gender, tech);
    }
    @GetMapping("/student/{tech}")
    public List<Student> getStudentByTech(@PathVariable("tech") String tech){

        return sr.getStudentByTech(tech);
    }


    //native query
    @PostMapping("student/filter")
    public List<Student> getStudentByGenAndTech(
            @Param("gender") String gender,
            @Param ("tech") String tech
    )
    {
        return sr.getStudentByGenAndTech(gender ,tech);
    }

    //Jpql Query
    @GetMapping("/student/name")
    public List<Student> getStudentByName(){

        return sr.getStudentByname();
    }
    @GetMapping("students/{rno}")
    public StudentDto getStudentBRollno(@PathVariable("rno") int rno){
        return sr.getAllStudentByRollno(rno);
    }

    @PostMapping("students")
    public StudentDto addStudents(@Validated @RequestBody StudentDto std){

        return sr.addStudents(std);
    }

    @GetMapping("students")
    public Page<Student> getStudent(@RequestParam("page") int page, @RequestParam("size") int size){
        return sr.getAllStudent(page,size);


    }


}