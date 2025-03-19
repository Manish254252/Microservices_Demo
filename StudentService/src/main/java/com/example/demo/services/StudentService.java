package com.example.demo.services;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudent()
    {
       return studentRepository.findAll();
    }
    public Student getStudentById(Integer id)
    {
      return studentRepository.findById(id).orElseGet(Student::new);
    }

    public void saveStudent(Student Student)
    {
       studentRepository.save(Student);
    }

    public Student updateStudent(Student Student) {
        Optional<Student> existingStudent = studentRepository.findById(Student.getId());

        if (existingStudent.isPresent()) {
            Student StudentToUpdate = existingStudent.get();
            StudentToUpdate.setName(Student.getName());
            StudentToUpdate.setAddress(Student.getAddress());
            StudentToUpdate.setAge(Student.getAge());
            return studentRepository.save(StudentToUpdate);
        } else {
            return null; // Or throw an exception
        }
    }

    public void deleteStudent(Integer id)
    {
        studentRepository.deleteById(id);

    }
}
