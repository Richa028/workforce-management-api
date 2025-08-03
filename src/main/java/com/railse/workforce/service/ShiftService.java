
package com.railse.workforce.service;

import com.railse.workforce.dto.request.ShiftRequestDTO;
import com.railse.workforce.dto.response.ShiftResponseDTO;

import java.util.List;

public interface ShiftService {
    ShiftResponseDTO create(ShiftRequestDTO dto);
    List<ShiftResponseDTO> getAll();
}
