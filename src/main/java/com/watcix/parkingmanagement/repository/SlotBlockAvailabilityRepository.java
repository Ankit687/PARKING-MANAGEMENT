package com.watcix.parkingmanagement.repository;

import com.watcix.parkingmanagement.dto.BlockResponse;
import com.watcix.parkingmanagement.dto.SlotAndBlockResponse;
import com.watcix.parkingmanagement.entity.BlockDetail;
import com.watcix.parkingmanagement.entity.SlotBlockAvailabilityDetail;
import com.watcix.parkingmanagement.entity.SlotDetail;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class SlotBlockAvailabilityRepository {
    private final List<SlotDetail> slotDetailList = new ArrayList<>();
    private final List<BlockDetail> blockDetailList = new ArrayList<>();
    private final List<SlotBlockAvailabilityDetail> slotBlockAvailabilityDetailList = new ArrayList<>();

    public void loadDefaultAvailability() {
        slotDetailList.add(new SlotDetail(1));
        slotDetailList.add(new SlotDetail(2));
        slotDetailList.add(new SlotDetail(3));

        blockDetailList.add(new BlockDetail("A"));
        blockDetailList.add(new BlockDetail("B"));
        blockDetailList.add(new BlockDetail("C"));

        for (SlotDetail slotDetail : slotDetailList) {
            for (BlockDetail blockDetail : blockDetailList) {
                slotBlockAvailabilityDetailList.add(new SlotBlockAvailabilityDetail(slotDetail, blockDetail, true));
            }
        }
    }

    public List<SlotBlockAvailabilityDetail> getSlotBlockAvailabilityDetailListBySlot(int slot) {
        return slotBlockAvailabilityDetailList.stream().filter(slotBlockAvailabilityDetail -> slotBlockAvailabilityDetail.getSlot().getSlot() == slot)
                .collect(Collectors.toList());
    }

    public List<SlotBlockAvailabilityDetail> getSlotBlockAvailabilityDetailListByBlock(String block) {
        return slotBlockAvailabilityDetailList.stream().filter(slotBlockAvailabilityDetail -> slotBlockAvailabilityDetail.getBlock().getBlock().equalsIgnoreCase(block))
                .collect(Collectors.toList());
    }

    public List<SlotBlockAvailabilityDetail> getSlotBlockAvailabilityDetailListByAvailability(boolean availability) {
        return slotBlockAvailabilityDetailList.stream().filter(slotBlockAvailabilityDetail -> slotBlockAvailabilityDetail.getAvailability() == availability)
                .collect(Collectors.toList());
    }

    public List<SlotDetail> getSlotDetailList() {
        return slotDetailList;
    }

    public List<BlockDetail> getBlockDetailList() {
        return blockDetailList;
    }

    public List<SlotBlockAvailabilityDetail> getSlotBlockAvailabilityDetailList() {
        return slotBlockAvailabilityDetailList;
    }

    public void saveSlotBlockAvailabilityDetails(SlotBlockAvailabilityDetail slotBlockAvailabilityDetail) {
        slotBlockAvailabilityDetailList.forEach(slotBlockAvailabilityDetail1 -> {if(Objects.equals(slotBlockAvailabilityDetail1.getSlot(), slotBlockAvailabilityDetail.getSlot())
                && Objects.equals(slotBlockAvailabilityDetail1.getBlock(), slotBlockAvailabilityDetail.getBlock())) {
            slotBlockAvailabilityDetail1.setAvailability(slotBlockAvailabilityDetail.getAvailability());
        }});
    }

    public List<SlotAndBlockResponse> saveSlotsAndBlocks(List<SlotAndBlockResponse> slotAndBlockResponseList) {
        for (SlotAndBlockResponse slotAndBlockResponse : slotAndBlockResponseList) {
            SlotDetail slotDetail = slotDetailList.stream().filter(slotDetail1 -> Objects.equals(slotDetail1.getSlot(), slotAndBlockResponse.getSlot())).findFirst().orElse(null);
            if (ObjectUtils.isEmpty(slotDetail)) {
                slotDetail = new SlotDetail(slotAndBlockResponse.getSlot());
                slotDetailList.add(slotDetail);
            }
            for (BlockResponse blockResponse : slotAndBlockResponse.getBlockResponseList()) {
                BlockDetail blockDetail = blockDetailList.stream().filter(blockDetail1 -> blockDetail1.getBlock().equalsIgnoreCase(blockResponse.getBlock())).findFirst().orElse(null);
                if (ObjectUtils.isEmpty(blockDetail)) {
                    blockDetail = new BlockDetail(blockResponse.getBlock());
                    blockDetailList.add(blockDetail);
                }
                else {
                    slotBlockAvailabilityDetailList.add(new SlotBlockAvailabilityDetail(slotDetail, blockDetail, ObjectUtils.isEmpty(blockResponse.getAvailability()) || blockResponse.getAvailability()));
                }
            }
        }
        return slotAndBlockResponseList;
    }

    public SlotBlockAvailabilityDetail getSlotBlockAvailabilityBySlotAndBlock(SlotDetail slot, BlockDetail block) {
        return slotBlockAvailabilityDetailList.stream().filter(slotBlockAvailabilityDetail -> Objects.equals(slotBlockAvailabilityDetail.getSlot(), slot) && Objects.equals(slotBlockAvailabilityDetail.getBlock(), block))
                .findFirst().orElse(null);
    }
}
