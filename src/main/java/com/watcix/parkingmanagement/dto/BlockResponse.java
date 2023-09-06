package com.watcix.parkingmanagement.dto;

public class BlockResponse {
    private String block;
    private boolean availability;

    public BlockResponse() {
    }

    public BlockResponse(String block, boolean availability) {
        this.block = block;
        this.availability = availability;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "BlockResponse{" +
                "block='" + block + '\'' +
                ", availability=" + availability +
                '}';
    }
}
