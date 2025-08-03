
package com.railse.workforce.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/assign-shift")
public class AssignShiftController {

    private final Map<Long, Long> assignments = new HashMap<>();

    @PostMapping
    public String assign(@RequestParam Long employeeId, @RequestParam Long shiftId) {
        assignments.put(employeeId, shiftId);
        return "Assigned shift " + shiftId + " to employee " + employeeId;
    }

    @GetMapping("/{employeeId}")
    public Long getAssignedShift(@PathVariable Long employeeId) {
        return assignments.get(employeeId);
    }
}
