package com.watcix.parkingmanagement.entity;

public class SlotDetails {
    private Integer slot;

    public SlotDetails() {
    }

    public SlotDetails(Integer slot) {
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
