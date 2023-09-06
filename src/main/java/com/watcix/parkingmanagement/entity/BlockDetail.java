package com.watcix.parkingmanagement.entity;

public class BlockDetail {
    private String block;

    public BlockDetail() {
    }

    public BlockDetail(String block) {
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
