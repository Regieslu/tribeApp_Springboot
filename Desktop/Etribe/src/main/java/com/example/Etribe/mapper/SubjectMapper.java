package com.example.Etribe.mapper;
import com.example.Etribe.dto.CreateSubjectDTO;
import com.example.Etribe.dto.SubjectDTO;
import com.example.Etribe.dto.UpdateSubjectDTO;
import com.example.Etribe.model.Subject;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface SubjectMapper {
    SubjectDTO toDTO(Subject model);
    List<SubjectDTO> toDTO(List<Subject> model);
    @Mapping(target = "id", ignore = true)
    Subject toModel(CreateSubjectDTO dto);
    @Mapping(target = "id", ignore = true)
    void update(@MappingTarget Subject subject, UpdateSubjectDTO dto);
}
