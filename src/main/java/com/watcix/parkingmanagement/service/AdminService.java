package com.watcix.parkingmanagement.service;

import com.watcix.parkingmanagement.dto.BlockResponse;
import com.watcix.parkingmanagement.dto.SlotAndBlockResponse;
import com.watcix.parkingmanagement.entity.SlotBlockAvailabilityDetail;
import com.watcix.parkingmanagement.entity.UserParkingDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {

    @Autowired
    private SlotBlockAvailabilityService slotBlockAvailabilityService;

    @Autowired
    private UserParkingService userParkingService;

    public ResponseEntity<List<SlotAndBlockResponse>> getAllSlotAndBlock() {
        List<SlotAndBlockResponse> slotAndBlockResponseList = new ArrayList<>();
        List<BlockResponse> blockResponseList = new ArrayList<>();
        List<SlotBlockAvailabilityDetail> availabilityDetailList = slotBlockAvailabilityService.getSlotBlockAvailabilityListBySlot(1);
        for (SlotBlockAvailabilityDetail slotBlockAvailabilityDetail : availabilityDetailList) {
            blockResponseList.add(new BlockResponse(slotBlockAvailabilityDetail.getBlock().getBlock(), slotBlockAvailabilityDetail.getAvailability()));
        }
        slotAndBlockResponseList.add(new SlotAndBlockResponse(1, blockResponseList));
        blockResponseList = new ArrayList<>();

        availabilityDetailList = slotBlockAvailabilityService.getSlotBlockAvailabilityListBySlot(2);
        for (SlotBlockAvailabilityDetail slotBlockAvailabilityDetail : availabilityDetailList) {
            blockResponseList.add(new BlockResponse(slotBlockAvailabilityDetail.getBlock().getBlock(), slotBlockAvailabilityDetail.getAvailability()));
        }
        slotAndBlockResponseList.add(new SlotAndBlockResponse(2, blockResponseList));
        blockResponseList = new ArrayList<>();

        availabilityDetailList = slotBlockAvailabilityService.getSlotBlockAvailabilityListBySlot(3);
        for (SlotBlockAvailabilityDetail slotBlockAvailabilityDetail : availabilityDetailList) {
            blockResponseList.add(new BlockResponse(slotBlockAvailabilityDetail.getBlock().getBlock(), slotBlockAvailabilityDetail.getAvailability()));
        }
        slotAndBlockResponseList.add(new SlotAndBlockResponse(3, blockResponseList));

        return new ResponseEntity<>(slotAndBlockResponseList, HttpStatus.OK);
    }

    public ResponseEntity<List<UserParkingDetail>> getUserParkingDetails() {
        return new ResponseEntity<>(userParkingService.getUserParkingDetailList(), HttpStatus.OK);
    }
}
