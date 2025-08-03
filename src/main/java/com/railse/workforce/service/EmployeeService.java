
package com.railse.workforce.service;

import com.railse.workforce.dto.request.EmployeeRequestDTO;
import com.railse.workforce.dto.response.EmployeeResponseDTO;

import java.util.List;

public interface EmployeeService {
    EmployeeResponseDTO create(EmployeeRequestDTO dto);
    EmployeeResponseDTO getById(Long id);
    EmployeeResponseDTO update(Long id, EmployeeRequestDTO dto);
    void delete(Long id);
    List<EmployeeResponseDTO> getAll();
}
