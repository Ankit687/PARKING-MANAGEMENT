package com.watcix.parkingmanagement.repository;

import com.watcix.parkingmanagement.entity.UserParkingDetail;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserParkingRepository {
    private final List<UserParkingDetail> userParkingDetailList = new ArrayList<>();

    public UserParkingDetail getUserParkingDetailByVehicleId(String vehicleId) {
        return userParkingDetailList.stream().filter(userParkingDetail -> userParkingDetail.getUserDetails().getVehicleId().equalsIgnoreCase(vehicleId)
                && userParkingDetail.getParkingAmount() == null).findFirst().orElse(null);
    }

    public List<UserParkingDetail> getUserParkingDetailListByVehicleId(String vehicleId) {
        return userParkingDetailList.stream().filter(userParkingDetail -> userParkingDetail.getUserDetails().getVehicleId().equalsIgnoreCase(vehicleId))
                .collect(Collectors.toList());
    }

    public List<UserParkingDetail> getUserParkingDetailList() {
        return userParkingDetailList.stream().filter(userParkingDetail -> userParkingDetail.getParkingAmount() == null)
                .collect(Collectors.toList());
    }

    public List<UserParkingDetail> getUserParkingDetailListBetweenEntryTimeAndExistTime(LocalDateTime entryTime, LocalDateTime existTime) {
        return userParkingDetailList.stream().filter(userParkingDetail -> !userParkingDetail.getEntryTime().isBefore(entryTime)
                        && !userParkingDetail.getExitTime().isAfter(existTime))
                .collect(Collectors.toList());
//        userParkingDetailList.stream().filter(userParkingDetail -> userParkingDetail.getEntryTime().compareTo(entryTime) >= 0
//                        && userParkingDetail.getExistTime().compareTo(existTime) <= 0)
//                .collect(Collectors.toList());
    }

    public void saveUserParkingDetail(UserParkingDetail userParkingDetail) {
        userParkingDetailList.add(userParkingDetail);
    }

    public List<UserParkingDetail> getUserParkingDetailListByVehicleCategory(String vehicleCategory) {
        return userParkingDetailList.stream().filter(userParkingDetail -> userParkingDetail.getUserDetails().getVehicleCategory().equalsIgnoreCase(vehicleCategory))
                .collect(Collectors.toList());
    }
}
