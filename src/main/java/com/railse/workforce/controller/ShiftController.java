
package com.railse.workforce.controller;

import com.railse.workforce.dto.request.ShiftRequestDTO;
import com.railse.workforce.dto.response.ShiftResponseDTO;
import com.railse.workforce.service.ShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/shift")
public class ShiftController {

    @Autowired
    private ShiftService service;

    @PostMapping
    public ShiftResponseDTO create(@RequestBody ShiftRequestDTO dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<ShiftResponseDTO> getAll() {
        return service.getAll();
    }
}
