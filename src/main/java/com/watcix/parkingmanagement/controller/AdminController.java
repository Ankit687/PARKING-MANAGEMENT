package com.watcix.parkingmanagement.controller;

import com.watcix.parkingmanagement.dto.ResponseDto;
import com.watcix.parkingmanagement.dto.SlotAndBlockResponse;
import com.watcix.parkingmanagement.dto.VehicleCountResponse;
import com.watcix.parkingmanagement.entity.BlockDetail;
import com.watcix.parkingmanagement.entity.SlotDetail;
import com.watcix.parkingmanagement.entity.UserParkingDetail;
import com.watcix.parkingmanagement.service.AdminService;
import com.watcix.parkingmanagement.service.SlotBlockAvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private SlotBlockAvailabilityService slotBlockAvailabilityService;

    @GetMapping("getAllSlotAndBlock")
    public ResponseEntity<List<SlotAndBlockResponse>> getAllSlotAndBlock() {
        return adminService.getAllSlotAndBlock();
    }

    @GetMapping("/getUserParkingDetails")
    public ResponseEntity<List<UserParkingDetail>> getUserParkingDetails() {
        return adminService.getUserParkingDetails();
    }

    @GetMapping("/getSlots")
    public ResponseEntity<List<SlotDetail>> getSlots() {
        return new ResponseEntity<>(slotBlockAvailabilityService.getSlotList(), HttpStatus.OK);
    }

    @GetMapping("/getBlocks")
    public ResponseEntity<List<BlockDetail>> getBlocks() {
        return new ResponseEntity<>(slotBlockAvailabilityService.getBlockList(), HttpStatus.OK);
    }

    @PostMapping("/saveSlotsAndBlocks")
    public ResponseEntity<List<SlotAndBlockResponse>> saveSlotsAndBlocks(@RequestBody List<SlotAndBlockResponse> slotAndBlockResponseList) {
        return new ResponseEntity<>(slotBlockAvailabilityService.saveSlotsAndBlocks(slotAndBlockResponseList), HttpStatus.OK);
    }

    @GetMapping("getVehiclesCount/{vehicleCategory}")
    public ResponseEntity<VehicleCountResponse> getVehiclesCount (@PathVariable String vehicleCategory) {
        return adminService.getVehiclesCount(vehicleCategory);
    }
}
