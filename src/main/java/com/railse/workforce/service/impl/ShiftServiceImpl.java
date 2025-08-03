
package com.railse.workforce.service.impl;

import com.railse.workforce.dto.request.ShiftRequestDTO;
import com.railse.workforce.dto.response.ShiftResponseDTO;
import com.railse.workforce.entity.Shift;
import com.railse.workforce.service.ShiftService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class ShiftServiceImpl implements ShiftService {
    private final Map<Long, Shift> db = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public ShiftResponseDTO create(ShiftRequestDTO dto) {
        Shift shift = new Shift();
        shift.setId(idCounter.getAndIncrement());
        shift.setShiftName(dto.getShiftName());
        shift.setStartTime(dto.getStartTime());
        shift.setEndTime(dto.getEndTime());
        db.put(shift.getId(), shift);

        ShiftResponseDTO response = new ShiftResponseDTO();
        response.setId(shift.getId());
        response.setShiftName(shift.getShiftName());
        response.setStartTime(shift.getStartTime());
        response.setEndTime(shift.getEndTime());
        return response;
    }

    public List<ShiftResponseDTO> getAll() {
        return db.values().stream().map(shift -> {
            ShiftResponseDTO dto = new ShiftResponseDTO();
            dto.setId(shift.getId());
            dto.setShiftName(shift.getShiftName());
            dto.setStartTime(shift.getStartTime());
            dto.setEndTime(shift.getEndTime());
            return dto;
        }).collect(Collectors.toList());
    }
}
