package com.watcix.parkingmanagement.entity;

public class SlotDetail {
    private Integer slot;

    public SlotDetail() {
    }

    public SlotDetail(Integer slot) {
        this.slot = slot;
    }

    public Integer getSlot() {
        return slot;
    }

    public void setSlot(Integer slot) {
        this.slot = slot;
    }

    @Override
    public String toString() {
        return "SlotDetails{" +
                "slot=" + slot +
                '}';
    }
}
