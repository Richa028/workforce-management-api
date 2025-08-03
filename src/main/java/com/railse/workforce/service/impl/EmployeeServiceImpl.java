
package com.railse.workforce.service.impl;

import com.railse.workforce.dto.request.EmployeeRequestDTO;
import com.railse.workforce.dto.response.EmployeeResponseDTO;
import com.railse.workforce.entity.Employee;
import com.railse.workforce.mapper.EmployeeMapper;
import com.railse.workforce.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<Long, Employee> db = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1);
    private final EmployeeMapper mapper = EmployeeMapper.INSTANCE;

    public EmployeeResponseDTO create(EmployeeRequestDTO dto) {
        Employee emp = mapper.toEntity(dto);
        emp.setId(idCounter.getAndIncrement());
        db.put(emp.getId(), emp);
        return mapper.toDto(emp);
    }

    public EmployeeResponseDTO getById(Long id) {
        return mapper.toDto(db.get(id));
    }

    public EmployeeResponseDTO update(Long id, EmployeeRequestDTO dto) {
        Employee emp = db.get(id);
        if (emp != null) {
            emp.setName(dto.getName());
            emp.setDepartment(dto.getDepartment());
            db.put(id, emp);
        }
        return mapper.toDto(emp);
    }

    public void delete(Long id) {
        db.remove(id);
    }

    public List<EmployeeResponseDTO> getAll() {
        return db.values().stream().map(mapper::toDto).collect(Collectors.toList());
    }
}
