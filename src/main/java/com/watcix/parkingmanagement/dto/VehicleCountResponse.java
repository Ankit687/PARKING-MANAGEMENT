package com.watcix.parkingmanagement.dto;

import com.watcix.parkingmanagement.entity.UserParkingDetail;

import java.util.List;

public class VehicleCountResponse {
    private Integer count;
    private List<UserParkingDetail> userParkingDetailList;

    public VehicleCountResponse() {
    }

    public VehicleCountResponse(Integer count, List<UserParkingDetail> userParkingDetailList) {
        this.count = count;
        this.userParkingDetailList = userParkingDetailList;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<UserParkingDetail> getUserParkingDetailList() {
        return userParkingDetailList;
    }

    public void setUserParkingDetailList(List<UserParkingDetail> userParkingDetailList) {
        this.userParkingDetailList = userParkingDetailList;
    }

    @Override
    public String toString() {
        return "VehicleCountResponse{" +
                "count=" + count +
                ", userParkingDetailList=" + userParkingDetailList +
                '}';
    }
}
