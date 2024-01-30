package com.example.Etribe.mapper;

import com.example.Etribe.model.SubjectMembership;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ClassMapper {
    @Mapping(source = "studentId", target = "id.studentId")
    @Mapping(source = "studentId", target = "student.id")
    @Mapping(source = "subjectId", target = "id.subjectId")
    @Mapping(source = "subjectId", target = "subject.id")
    SubjectMembership toModel(Long studentId, Long subjectId);
}
