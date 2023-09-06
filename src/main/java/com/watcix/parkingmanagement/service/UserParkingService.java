package com.watcix.parkingmanagement.service;

import com.watcix.parkingmanagement.entity.UserParkingDetail;
import com.watcix.parkingmanagement.repository.UserParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserParkingService {
    @Autowired
    private UserParkingRepository userParkingRepository;

    public UserParkingDetail getUserParkingDetailByVehicleId(String vehicleId) {
        return userParkingRepository.getUserParkingDetailByVehicleId(vehicleId);
    }

    public List<UserParkingDetail> getUserParkingDetailListByVehicleId(String vehicleId) {
        return userParkingRepository.getUserParkingDetailListByVehicleId(vehicleId);
    }

    public List<UserParkingDetail> getUserParkingDetailListByEntryAndExistTime(LocalDateTime entryTime, LocalDateTime existTime) {
        return userParkingRepository.getUserParkingDetailListBetweenEntryTimeAndExistTime(entryTime, existTime);
    }

    public void saveUserParkingDetail(UserParkingDetail userParkingDetail) {
        userParkingRepository.saveUserParkingDetail(userParkingDetail);
    }
}
