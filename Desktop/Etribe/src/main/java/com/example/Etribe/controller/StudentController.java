package com.example.Etribe.controller;
import com.example.Etribe.Service.StudentService;
import com.example.Etribe.Service.ClassService;
import com.example.Etribe.dto.*;
import com.example.Etribe.exception.StudentNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
   private StudentService service;

    @Autowired
    private ClassService classService;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<StudentDTO> findAll(){
        return service.findAll();
    }

    @GetMapping({"/deactivated"})
    @ResponseStatus(HttpStatus.OK)
    public List<StudentDTO> findAllDeactivatedStudent(){
        return service.findAllDeactivatedStudent();
    }

    @GetMapping({"{studentId}"})
    @ResponseStatus(HttpStatus.OK)
    public StudentDTO getStudentById(@PathVariable long studentId) {
     return service.getStudentById(studentId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentDTO save(@Valid @RequestBody CreateStudentDTO data){
        return service.save(data);

    }

    @PostMapping("{studentId}/subjects")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addSubject(@PathVariable long studentId, @RequestBody AddSubjectDTO data){
    classService.addSubject(studentId, data.getSubjectId());
    }

    @GetMapping("{studentId}/subjects")
    @ResponseStatus(HttpStatus.OK)
    public List<SubjectDTO> findSubjectsByStudent(@PathVariable long studentId) {
        return classService.findSubjectByStudent(studentId);
    }

    @PutMapping("{studentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateStudent(@PathVariable long studentId, @Valid @RequestBody UpdateStudentDTO data) throws StudentNotFoundException {
        service.update(studentId, data);
    }
    @PutMapping("{studentId}/deactivate")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deactivateStudent(@PathVariable long studentId, @Valid @RequestBody UpdateStudentDTO data){
        service.deactivate(studentId, data);
    }

    @PutMapping("{studentId}/activate")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void activateStudent(@PathVariable long studentId, @Valid @RequestBody UpdateStudentDTO data){
        service.activate(studentId, data);
    }

}
