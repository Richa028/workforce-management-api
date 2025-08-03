
package com.railse.workforce.mapper;

import com.railse.workforce.dto.request.EmployeeRequestDTO;
import com.railse.workforce.dto.response.EmployeeResponseDTO;
import com.railse.workforce.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    Employee toEntity(EmployeeRequestDTO dto);
    EmployeeResponseDTO toDto(Employee entity);
}
