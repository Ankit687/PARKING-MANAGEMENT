package com.watcix.parkingmanagement.entity;

public class SlotDetail {
    private Integer slot;
    private String slotCategory;

    public SlotDetail() {
    }

    public SlotDetail(Integer slot, String slotCategory) {
        this.slot = slot;
        this.slotCategory = slotCategory;
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

    @Override
    public String toString() {
        return "SlotDetails{" +
                "slot=" + slot +
                "slotCategory=" + slotCategory +
                '}';
    }
}
