package com.watcix.parkingmanagement.entity;

import java.time.LocalDateTime;

public class UserParkingDetails {
    private String vehicleId;
    private UserDetails userDetails;
    private LocalDateTime entryTime;
    private LocalDateTime existTime;
    private SlotBlockAvailabilityDetails slotBlockAvailabilityDetails;
    private Double parkingAmount;

    public UserParkingDetails() {
    }

    public UserParkingDetails(String vehicleId, UserDetails userDetails, LocalDateTime entryTime, LocalDateTime existTime, SlotBlockAvailabilityDetails slotBlockAvailabilityDetails, Double parkingAmount) {
        this.vehicleId = vehicleId;
        this.userDetails = userDetails;
        this.entryTime = entryTime;
        this.existTime = existTime;
        this.slotBlockAvailabilityDetails = slotBlockAvailabilityDetails;
        this.parkingAmount = parkingAmount;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public LocalDateTime getExistTime() {
        return existTime;
    }

    public void setExistTime(LocalDateTime existTime) {
        this.existTime = existTime;
    }

    public SlotBlockAvailabilityDetails getSlotBlockAvailabilityDetails() {
        return slotBlockAvailabilityDetails;
    }

    public void setSlotBlockAvailabilityDetails(SlotBlockAvailabilityDetails slotBlockAvailabilityDetails) {
        this.slotBlockAvailabilityDetails = slotBlockAvailabilityDetails;
    }

    public Double getParkingAmount() {
        return parkingAmount;
    }

    public void setParkingAmount(Double parkingAmount) {
        this.parkingAmount = parkingAmount;
    }

    @Override
    public String toString() {
        return "UserParkingDetails{" +
                "vehicleId='" + vehicleId + '\'' +
                ", userDetails=" + userDetails +
                ", entryTime=" + entryTime +
                ", existTime=" + existTime +
                ", slotBlockAvailabilityDetails=" + slotBlockAvailabilityDetails +
                ", parkingAmount=" + parkingAmount +
                '}';
    }
}
