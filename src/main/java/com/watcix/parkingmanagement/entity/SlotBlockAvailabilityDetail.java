package com.watcix.parkingmanagement.entity;

public class SlotBlockAvailabilityDetail {
    private SlotDetail slot;
    private BlockDetail block;
    private Boolean availability;

    public SlotBlockAvailabilityDetail() {
    }

    public SlotBlockAvailabilityDetail(SlotDetail slot, BlockDetail block, Boolean availability) {
        this.slot = slot;
        this.block = block;
        this.availability = availability;
    }

    public SlotDetail getSlot() {
        return slot;
    }

    public void setSlot(SlotDetail slot) {
        this.slot = slot;
    }

    public BlockDetail getBlock() {
        return block;
    }

    public void setBlock(BlockDetail block) {
        this.block = block;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "SlotBlockAvailabilityDetails{" +
                "slot=" + slot +
                ", block=" + block +
                ", availability=" + availability +
                '}';
    }
}
