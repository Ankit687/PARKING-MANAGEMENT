package com.watcix.parkingmanagement.entity;

public class BlockDetails {
    private String block;

    public BlockDetails() {
    }

    public BlockDetails(String block) {
        this.block = block;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    @Override
    public String toString() {
        return "Block{" +
                "block='" + block + '\'' +
                '}';
    }
}
