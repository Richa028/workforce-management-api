
package com.railse.workforce.dto.request;

public class ShiftRequestDTO {
    private String shiftName;
    private String startTime;
    private String endTime;

    // Getters and setters
    public String getShiftName() { return shiftName; }
    public void setShiftName(String shiftName) { this.shiftName = shiftName; }
    public String getStartTime() { return startTime; }
    public void setStartTime(String startTime) { this.startTime = startTime; }
    public String getEndTime() { return endTime; }
    public void setEndTime(String endTime) { this.endTime = endTime; }
}
