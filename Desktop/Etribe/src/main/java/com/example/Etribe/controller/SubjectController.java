package com.example.Etribe.controller;
import com.example.Etribe.Service.SubjectService;
import com.example.Etribe.dto.CreateSubjectDTO;
import com.example.Etribe.dto.SubjectDTO;
import com.example.Etribe.dto.UpdateSubjectDTO;
import com.example.Etribe.exception.SubjectNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    private SubjectService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<SubjectDTO> findAll(){
        return service.findAll();
    }
    @GetMapping({"{subjectId}"})
    @ResponseStatus(HttpStatus.OK)
    public SubjectDTO getSubjectById(@PathVariable long subjectId) {
        return service.getSubjectById(subjectId);
    }
    @GetMapping({"/deactivated"})
    @ResponseStatus(HttpStatus.OK)
    public List<SubjectDTO> findAllDeactivatedSubjects() { return service.findAllDeactivatedSubjects(); }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public  SubjectDTO save(@Valid @RequestBody CreateSubjectDTO data){
        return service.save(data);
    }

    @PutMapping("{subjectId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateSubject(@PathVariable long subjectId, @Valid @RequestBody UpdateSubjectDTO data) throws SubjectNotFoundException{
        service.update(subjectId, data);
    }
    @PutMapping("{subjectId}/deactivate")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deactivateSubject(@PathVariable long subjectId, @Valid @RequestBody UpdateSubjectDTO data){
        service.deactivate(subjectId, data);
    }

    @PutMapping("{subjectId}/activate")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void activateSubject(@PathVariable long subjectId, @Valid @RequestBody UpdateSubjectDTO data){
        service.activate(subjectId, data);
    }

}
