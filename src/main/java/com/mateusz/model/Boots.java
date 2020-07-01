package com.mateusz.model;

import com.mateusz.enums.Color;
import com.mateusz.enums.ProductSeparators;
import com.mateusz.enums.SkinType;

public class Boots extends Product {
    private int size;
    private SkinType skinType;

    public Boots(int id, String productName, float price, float weight, Color color, int productCount, int size, SkinType skinType) {
        super(id, productName, price, weight, color, productCount);
        this.size = size;
        this.skinType = skinType;
    }

    public int getSize() {
        return size;
    }

    public SkinType skinType() {
        return skinType;
    }

    @Override
    public String toString() {
        return ProductSeparators.BOOTS_ID + ProductSeparators.PRODUCT_SEPARATOR.toString() +
                getBasicProductString() + ProductSeparators.PRODUCT_SEPARATOR.toString() +
                size + ProductSeparators.PRODUCT_SEPARATOR.toString() +
                skinType;
    }
}
