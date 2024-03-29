package com.watcix.parkingmanagement.service;

import com.watcix.parkingmanagement.dto.ResponseDto;
import com.watcix.parkingmanagement.entity.SlotBlockAvailabilityDetail;
import com.watcix.parkingmanagement.entity.UserDetail;
import com.watcix.parkingmanagement.entity.UserParkingDetail;
import com.watcix.parkingmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserParkingService userParkingService;

    @Autowired
    private SlotBlockAvailabilityService slotBlockAvailabilityService;

    public ResponseEntity<ResponseDto> saveUserEntryDetail(UserDetail userDetail) {
        userRepository.saveUserDetails(userDetail);
        SlotBlockAvailabilityDetail availabilityDetail = slotBlockAvailabilityService.getSlotBlockAvailabilityDetailListBySlotCategory("GENERAL");
        if (ObjectUtils.isEmpty(availabilityDetail) || !availabilityDetail.getAvailability()) {
            availabilityDetail = slotBlockAvailabilityService.getSlotBlockAvailabilityDetailListBySlotCategory(userDetail.getVehicleCategory());
            if (ObjectUtils.isEmpty(availabilityDetail) || !availabilityDetail.getAvailability()) {
                ResponseDto responseDto = new ResponseDto("No Slots are available", userDetail.getVehicleId());
                return new ResponseEntity<>(responseDto, HttpStatus.OK);
            }
        }
        availabilityDetail.setAvailability(false);
        slotBlockAvailabilityService.saveSlotBlockAvailability(availabilityDetail);
        userParkingService.saveUserParkingDetail(new UserParkingDetail(userDetail.getVehicleId(), userDetail, LocalDateTime.now(), availabilityDetail));
        ResponseDto responseDto = new ResponseDto("Your slot are confirmed", userDetail.getVehicleId(), availabilityDetail.getSlot().getSlot(), availabilityDetail.getBlock().getBlock());
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    public ResponseEntity<ResponseDto> saveUserExitDetail(String vehicleId) {
        UserParkingDetail userParkingDetail = userParkingService.getUserParkingDetailByVehicleId(vehicleId);
        userParkingDetail.setExitTime(LocalDateTime.now());
        double rateAmount;
        if (userParkingDetail.getUserDetails().getVehicleCategory().equalsIgnoreCase("SUPERBIKE"))
            rateAmount = 60.0;
        else if (userParkingDetail.getUserDetails().getVehicleCategory().equalsIgnoreCase("SCOOTER"))
            rateAmount = 50.0;
        else
            rateAmount = 40.0;
        Double parkingAmount = userParkingService.calculateParkingAmount(userParkingDetail.getEntryTime(), userParkingDetail.getExitTime(), rateAmount);
        userParkingDetail.setParkingAmount(parkingAmount);
        userParkingService.saveUserParkingDetail(userParkingDetail);
        SlotBlockAvailabilityDetail availabilityDetail = slotBlockAvailabilityService.getSlotBlockAvailabilityBySlotAndBlock(userParkingDetail.getSlotBlockAvailabilityDetails().getSlot(), userParkingDetail.getSlotBlockAvailabilityDetails().getBlock());
        availabilityDetail.setAvailability(true);
        slotBlockAvailabilityService.saveSlotBlockAvailability(availabilityDetail);
        ResponseDto responseDto = new ResponseDto("Your Parking Details", userParkingDetail.getVehicleId(), userParkingDetail.getSlotBlockAvailabilityDetails().getSlot().getSlot(), userParkingDetail.getSlotBlockAvailabilityDetails().getBlock().getBlock(), userParkingDetail.getEntryTime(), userParkingDetail.getExitTime(), userParkingDetail.getParkingAmount());
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}
