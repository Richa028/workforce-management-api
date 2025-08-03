
package com.railse.workforce.controller;

import com.railse.workforce.dto.request.EmployeeRequestDTO;
import com.railse.workforce.dto.response.EmployeeResponseDTO;
import com.railse.workforce.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping
    public EmployeeResponseDTO create(@RequestBody EmployeeRequestDTO dto) {
        return service.create(dto);
    }

    @GetMapping("/{id}")
    public EmployeeResponseDTO get(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public EmployeeResponseDTO update(@PathVariable Long id, @RequestBody EmployeeRequestDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping
    public List<EmployeeResponseDTO> getAll() {
        return service.getAll();
    }
}
