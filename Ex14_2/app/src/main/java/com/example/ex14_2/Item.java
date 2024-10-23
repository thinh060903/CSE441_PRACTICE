package com.example.ex14_2;

public class Item {
    private String maso, tieude;
    private Integer thich;

    public Item(String maso, String tieude, Integer thich) {
        this.maso = maso;
        this.tieude = tieude;
        this.thich = thich;
    }

    public String getMaso() {
        return maso;
    }

    public String getTieude() {
        return tieude;
    }

    public Integer getThich() {
        return thich;
    }
}