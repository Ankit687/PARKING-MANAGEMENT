package com.watcix.parkingmanagement.entity;

public class SlotBlockAvailabilityDetails {
    private SlotDetails slot;
    private BlockDetails block;
    private Boolean availability;

    public SlotBlockAvailabilityDetails() {
    }

    public SlotBlockAvailabilityDetails(SlotDetails slot, BlockDetails block, Boolean availability) {
        this.slot = slot;
        this.block = block;
        this.availability = availability;
    }

    public SlotDetails getSlot() {
        return slot;
    }

    public void setSlot(SlotDetails slot) {
        this.slot = slot;
    }

    public BlockDetails getBlock() {
        return block;
    }

    public void setBlock(BlockDetails block) {
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
