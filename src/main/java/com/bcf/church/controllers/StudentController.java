package com.bcf.church.controllers;

import com.bcf.church.beans.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("v1")
public class StudentController {

    @GetMapping("/student")
    public Student getStudent() {
        Student s1 = new Student(1, "first", "last");

        return s1;
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> sList = new ArrayList<>();
        sList.add(new Student(1, "first", "last"));
        sList.add(new Student(2, "first2", "last2"));
        sList.add(new Student(3, "first3", "last3"));

        return sList;
    }

    @GetMapping("/students/{id}")
    public Student studentPathVariable(@PathVariable("id") int studentId) {
        Student s1 = new Student(studentId, "first", "last");

        return s1;
    }

    //api_path?id=2,firstName=stud
    @GetMapping("students/query")
    public Student StudentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName) {
        return new Student(id, firstName, "last");
    }

    @PostMapping("students/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PutMapping("students/{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student,
                                                 @PathVariable("id") int studentId){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
}
