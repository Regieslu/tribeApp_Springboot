package com.example.Etribe.Service;

import com.example.Etribe.Repository.StudentRepository;
import com.example.Etribe.dto.CreateStudentDTO;
import com.example.Etribe.dto.StudentDTO;
import com.example.Etribe.dto.UpdateStudentDTO;
import com.example.Etribe.exception.StudentNotFoundException;
import com.example.Etribe.mapper.StudentMapper;
import com.example.Etribe.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    public List<StudentDTO> findAll(){
        return studentMapper.toDTO(repository.listActiveStudents());
    }

    public List<StudentDTO> findAllDeactivatedStudent(){
        return studentMapper.toDTO(repository.listDeactivatedStudents());
    }

    public StudentDTO save(CreateStudentDTO data){
        Student entity = repository.save(studentMapper.toModel(data));
        return studentMapper.toDTO(entity);
    }

    public void update(long studentId, UpdateStudentDTO data){
        Optional<Student> result= repository.findById(studentId);
        if (result.isEmpty()){
            throw new StudentNotFoundException();
        }

        Student student = result.get();
        studentMapper.update(student, data);
        repository.save(student);
    }
    public void deactivate(long studentId, UpdateStudentDTO data){
        Optional<Student> result= repository.findById(studentId);
        if (result.isEmpty()){
            throw new StudentNotFoundException();
        }
        Student student = result.get();
        student.setActive(data.getActive());
        repository.save(student);
    }

    public void activate(long studentId, UpdateStudentDTO data){
        Optional<Student> result= repository.findById(studentId);
        if (result.isEmpty()){
            throw new StudentNotFoundException();
        }
        Student student = result.get();
        student.setActive(data.getActive());
        repository.save(student);
    }

    public StudentDTO getStudentById(long studentId) {
        Optional<Student> result= repository.findById(studentId);
        if (result.isEmpty()){
            throw new StudentNotFoundException();
        }
        Student student = result.get();
        return studentMapper.toDTO(student);
    }
}
