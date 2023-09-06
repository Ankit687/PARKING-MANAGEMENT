package com.watcix.parkingmanagement.service;

import com.watcix.parkingmanagement.dto.SlotAndBlockResponse;
import com.watcix.parkingmanagement.entity.BlockDetail;
import com.watcix.parkingmanagement.entity.SlotBlockAvailabilityDetail;
import com.watcix.parkingmanagement.entity.SlotDetail;
import com.watcix.parkingmanagement.repository.SlotBlockAvailabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SlotBlockAvailabilityService {
    @Autowired
    private SlotBlockAvailabilityRepository slotBlockAvailabilityRepository;

    public void loadDefaultSlotsAndBlocks() {
        slotBlockAvailabilityRepository.loadDefaultAvailability();
    }

    public SlotBlockAvailabilityDetail getSlotBlockAvailabilityBySlot(int slot) {
        return slotBlockAvailabilityRepository.getSlotBlockAvailabilityDetailListBySlot(slot).stream().filter(SlotBlockAvailabilityDetail::getAvailability)
                .findFirst().orElse(null);
    }

    public SlotBlockAvailabilityDetail getSlotBlockAvailabilityDetailListBySlotCategory(String slotCategory) {
        return slotBlockAvailabilityRepository.getSlotBlockAvailabilityDetailListBySlotCategory(slotCategory).stream().filter(SlotBlockAvailabilityDetail::getAvailability)
                .findFirst().orElse(null);
    }

    public SlotBlockAvailabilityDetail getSlotBlockAvailabilityByBlock(String block) {
        return slotBlockAvailabilityRepository.getSlotBlockAvailabilityDetailListByBlock(block).stream().filter(SlotBlockAvailabilityDetail::getAvailability)
                .findFirst().orElse(null);
    }

    public SlotBlockAvailabilityDetail getSlotBlockAvailabilityByAvailable() {
        return slotBlockAvailabilityRepository.getSlotBlockAvailabilityDetailListByAvailability(true).stream().filter(SlotBlockAvailabilityDetail::getAvailability)
                .findFirst().orElse(null);
    }

    public List<SlotBlockAvailabilityDetail> getSlotBlockAvailabilityListBySlot(int slot) {
        return slotBlockAvailabilityRepository.getSlotBlockAvailabilityDetailListBySlot(slot);
    }

    public List<SlotBlockAvailabilityDetail> getSlotBlockAvailabilityDetailListBySlotWithSlotCategory(int slot, String slotCategory) {
        return slotBlockAvailabilityRepository.getSlotBlockAvailabilityDetailListBySlotWithSlotCategory(slot, slotCategory);
    }

    public List<SlotBlockAvailabilityDetail> getSlotBlockAvailabilityListByBlock(String block) {
        return slotBlockAvailabilityRepository.getSlotBlockAvailabilityDetailListByBlock(block);
    }

    public List<SlotBlockAvailabilityDetail> getSlotBlockAvailabilityListByAvailability(boolean availability) {
        return slotBlockAvailabilityRepository.getSlotBlockAvailabilityDetailListByAvailability(availability);
    }

    public List<SlotBlockAvailabilityDetail> getSlotBlockAvailabilityList() {
        return slotBlockAvailabilityRepository.getSlotBlockAvailabilityDetailList();
    }

    public List<SlotDetail> getSlotList() {
        return slotBlockAvailabilityRepository.getSlotDetailList();
    }

    public List<BlockDetail> getBlockList() {
        return slotBlockAvailabilityRepository.getBlockDetailList();
    }

    public void saveSlotBlockAvailability(SlotBlockAvailabilityDetail slotBlockAvailabilityDetail) {
        slotBlockAvailabilityRepository.saveSlotBlockAvailabilityDetails(slotBlockAvailabilityDetail);
    }

    public List<SlotAndBlockResponse> saveSlotsAndBlocks(List<SlotAndBlockResponse> slotAndBlockResponseList) {
        return slotBlockAvailabilityRepository.saveSlotsAndBlocks(slotAndBlockResponseList);
    }

    public SlotBlockAvailabilityDetail getSlotBlockAvailabilityBySlotAndBlock(SlotDetail slot, BlockDetail block) {
        return slotBlockAvailabilityRepository.getSlotBlockAvailabilityBySlotAndBlock(slot, block);
    }
}
