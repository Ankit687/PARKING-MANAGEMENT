package com.watcix.parkingmanagement.dto;

import java.util.List;

public class SlotAndBlockResponse {
    private Integer slot;
    List<BlockResponse> blockResponseList;

    public SlotAndBlockResponse() {
    }

    public SlotAndBlockResponse(Integer slot, List<BlockResponse> blockResponseList) {
        this.slot = slot;
        this.blockResponseList = blockResponseList;
    }

    public Integer getSlot() {
        return slot;
    }

    public void setSlot(Integer slot) {
        this.slot = slot;
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
                ", blockResponseList=" + blockResponseList +
                '}';
    }
}
