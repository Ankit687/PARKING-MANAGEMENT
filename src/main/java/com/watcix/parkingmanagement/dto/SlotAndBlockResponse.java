package com.watcix.parkingmanagement.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SlotAndBlockResponse {
    private Integer slot;
    private String slotCategory;
    List<BlockResponse> blockResponseList;

    public SlotAndBlockResponse() {
    }

    public SlotAndBlockResponse(Integer slot, String slotCategory, List<BlockResponse> blockResponseList) {
        this.slot = slot;
        this.slotCategory = slotCategory;
        this.blockResponseList = blockResponseList;
    }

    public Integer getSlot() {
        return slot;
    }

    public void setSlot(Integer slot) {
        this.slot = slot;
    }

    public String getSlotCategory() {
        return slotCategory;
    }

    public void setSlotCategory(String slotCategory) {
        this.slotCategory = slotCategory;
    }

    public List<BlockResponse> getBlockResponseList() {
        return blockResponseList;
    }

    public void setBlockResponseList(List<BlockResponse> blockResponseList) {
        this.blockResponseList = blockResponseList;
    }

    @Override
    public String toString() {
        return "SlotAndBlockResponse{" +
                "slot=" + slot +
                "slotCategory=" + slotCategory +
                ", blockResponseList=" + blockResponseList +
                '}';
    }
}
