package com.watcix.parkingmanagement.entity;

import java.time.LocalDateTime;

public class UserParkingDetail {
    private String vehicleId;
    private UserDetail userDetail;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private SlotBlockAvailabilityDetail slotBlockAvailabilityDetail;
    private Double parkingAmount;

    public UserParkingDetail() {
    }

    public UserParkingDetail(String vehicleId, UserDetail userDetail, LocalDateTime entryTime, SlotBlockAvailabilityDetail slotBlockAvailabilityDetail) {
        this.vehicleId = vehicleId;
        this.userDetail = userDetail;
        this.entryTime = entryTime;
        this.slotBlockAvailabilityDetail = slotBlockAvailabilityDetail;
    }

    public UserParkingDetail(String vehicleId, UserDetail userDetail, LocalDateTime entryTime, LocalDateTime exitTime, SlotBlockAvailabilityDetail slotBlockAvailabilityDetail, Double parkingAmount) {
        this.vehicleId = vehicleId;
        this.userDetail = userDetail;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
        this.slotBlockAvailabilityDetail = slotBlockAvailabilityDetail;
        this.parkingAmount = parkingAmount;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public UserDetail getUserDetails() {
        return userDetail;
    }

    public void setUserDetails(UserDetail userDetail) {
        this.userDetail = userDetail;
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

    public SlotBlockAvailabilityDetail getSlotBlockAvailabilityDetails() {
        return slotBlockAvailabilityDetail;
    }

    public void setSlotBlockAvailabilityDetails(SlotBlockAvailabilityDetail slotBlockAvailabilityDetail) {
        this.slotBlockAvailabilityDetail = slotBlockAvailabilityDetail;
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
                ", userDetails=" + userDetail +
                ", entryTime=" + entryTime +
                ", existTime=" + exitTime +
                ", slotBlockAvailabilityDetails=" + slotBlockAvailabilityDetail +
                ", parkingAmount=" + parkingAmount +
                '}';
    }
}
