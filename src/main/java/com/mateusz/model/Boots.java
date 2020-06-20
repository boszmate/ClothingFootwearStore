package com.mateusz.model;

public class Boots extends Product {
    private int size;
    private boolean isNatualSkin;

    public Boots(int id, String productName, float price, float weight, String color, int productCount, int size, boolean isNatualSkin) {
        super(id, productName, price, weight, color, productCount);
        this.size = size;
        this.isNatualSkin = isNatualSkin;
    }

    public int getSize() {
        return size;
    }

    public boolean isNatualSkin() {
        return isNatualSkin;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Boots{" +
                "size=" + size +
                ", isNaturalSkin=" + isNatualSkin +
                "}";
    }
}
