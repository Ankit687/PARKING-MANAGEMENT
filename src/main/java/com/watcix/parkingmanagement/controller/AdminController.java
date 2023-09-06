package com.watcix.parkingmanagement.controller;

import com.watcix.parkingmanagement.dto.ResponseDto;
import com.watcix.parkingmanagement.dto.SlotAndBlockResponse;
import com.watcix.parkingmanagement.entity.UserParkingDetail;
import com.watcix.parkingmanagement.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("getAllSlotAndBlock")
    public ResponseEntity<List<SlotAndBlockResponse>> getAllSlotAndBlock() {
        return adminService.getAllSlotAndBlock();
    }

    @GetMapping("/getUserParkingDetails")
    public ResponseEntity<List<UserParkingDetail>> getUserParkingDetails() {
        return adminService.getUserParkingDetails();
    }
}
