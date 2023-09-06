package com.watcix.parkingmanagement.repository;

import com.watcix.parkingmanagement.entity.UserDetail;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class UserRepository {
    private final List<UserDetail> userDetailList = new ArrayList<>();

    public UserDetail getUserDetailsByVehicleId(String vehicleId) {
        return userDetailList.stream().filter(userDetail -> userDetail.getVehicleId().equalsIgnoreCase(vehicleId))
                .findFirst().orElse(null);
    }

    public UserDetail getUserDetailsByMobile(Long mobile) {
        return userDetailList.stream().filter(userDetail -> Objects.equals(userDetail.getMobile(), mobile))
                .findFirst().orElse(null);
    }

    public List<UserDetail> getUserDetailsListByVehicleCategory(String vehicleCategory) {
        return userDetailList.stream().filter(userDetail -> userDetail.getVehicleCategory().equalsIgnoreCase(vehicleCategory))
                .collect(Collectors.toList());
    }

    public void saveUserDetails(UserDetail userDetail) {
        userDetailList.add(userDetail);
    }
}
