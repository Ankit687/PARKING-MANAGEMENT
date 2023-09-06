package com.watcix.parkingmanagement.entity;

public class UserDetails {
    private String name;
    private Long mobile;
    private String vehicleId;
    private String vehicleCategory;

    public UserDetails() {
    }

    public UserDetails(String name, Long mobile, String vehicleId, String vehicleCategory) {
        this.name = name;
        this.mobile = mobile;
        this.vehicleId = vehicleId;
        this.vehicleCategory = vehicleCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getMobile() {
        return mobile;
    }

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleCategory() {
        return vehicleCategory;
    }

    public void setVehicleCategory(String vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "name='" + name + '\'' +
                ", mobile=" + mobile +
                ", vehicleId='" + vehicleId + '\'' +
                ", vehicleCategory='" + vehicleCategory + '\'' +
                '}';
    }
}
