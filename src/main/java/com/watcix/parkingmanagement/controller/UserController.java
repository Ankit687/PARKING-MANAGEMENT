package com.watcix.parkingmanagement.controller;

import com.watcix.parkingmanagement.dto.ResponseDto;
import com.watcix.parkingmanagement.entity.UserDetail;
import com.watcix.parkingmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("saveUserEntry")
    public ResponseEntity<ResponseDto> saveUserEntryDetail (@RequestBody UserDetail userDetail) {
        return userService.saveUserEntryDetail(userDetail);
    }

    @GetMapping("saveUserExit/{vehicleId}")
    public ResponseEntity<ResponseDto> saveUserExitDetail (@PathVariable String vehicleId) {
        return userService.saveUserExitDetail(vehicleId);
    }
}
