package com.watcix.parkingmanagement.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDto {
    private String statusMessage;
    private String vehicleId;
    private Integer slot;
    private String block;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private Double parkingAmount;

    public ResponseDto() {
    }

    public ResponseDto(String statusMessage, String vehicleId) {
        this.statusMessage = statusMessage;
        this.vehicleId = vehicleId;
    }

    public ResponseDto(String statusMessage, String vehicleId, Integer slot, String block) {
        this.statusMessage = statusMessage;
        this.vehicleId = vehicleId;
        this.slot = slot;
        this.block = block;
    }

    public ResponseDto(String statusMessage, String vehicleId, Integer slot, String block, LocalDateTime entryTime, LocalDateTime exitTime, Double parkingAmount) {
        this.statusMessage = statusMessage;
        this.vehicleId = vehicleId;
        this.slot = slot;
        this.block = block;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
        this.parkingAmount = parkingAmount;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Integer getSlot() {
        return slot;
    }

    public void setSlot(Integer slot) {
        this.slot = slot;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public Double getParkingAmount() {
        return parkingAmount;
    }

    public void setParkingAmount(Double parkingAmount) {
        this.parkingAmount = parkingAmount;
    }
}
