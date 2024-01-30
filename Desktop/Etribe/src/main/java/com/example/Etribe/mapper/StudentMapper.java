package com.example.Etribe.mapper;
import com.example.Etribe.dto.CreateStudentDTO;
import com.example.Etribe.dto.StudentDTO;
import com.example.Etribe.dto.UpdateStudentDTO;
import com.example.Etribe.model.Student;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface StudentMapper {
    StudentDTO toDTO(Student model);
    List<StudentDTO> toDTO(List<Student> model);
    @Mapping(target = "id", ignore = true)
    Student toModel(CreateStudentDTO dto);
    @Mapping(target = "id", ignore = true)
    void update(@MappingTarget Student student, UpdateStudentDTO dto);
}