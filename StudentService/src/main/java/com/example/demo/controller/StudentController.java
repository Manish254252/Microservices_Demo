package com.example.demo.controller;

import com.example.demo.entity.Library;
import com.example.demo.entity.Student;
import com.example.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private RestTemplate restTemplate;



    @GetMapping("/students")
    public List<Student> getStudentById()
    {
        return studentService.getAllStudent();
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable Integer id) {
        try {
            Library library = restTemplate.getForObject("http://localhost:9093/libraries/libraries/"+id, Library.class);
            Student student = studentService.getStudentById(id);
            if (student.getId() == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Such Student Found");
            }
            student.setLibrary(library);
            return ResponseEntity.ok(student);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while retrieving the Student: " + e.getMessage());
        }
    }


    @PostMapping("/students")
    public String createStudent(@RequestBody Student student)
    {
        studentService.saveStudent(student);
        return "Created Successfully";
    }

    @PutMapping("/students/{id}")
    public Student updateStudent(@RequestBody Student student)
    {
       return studentService.updateStudent(student);
    }

    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable Integer id)
    {
        studentService.deleteStudent(id);
        return "Deleted Successfully";
    }
}
