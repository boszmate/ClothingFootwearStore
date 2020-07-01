package com.mateusz.enums;

public enum ProductSeparators {
    PRODUCT_SEPARATOR("#"),
    PRODUCT_ID("P"),
    CLOTH_ID("C"),
    BOOTS_ID("B");

    private String sign;

    ProductSeparators(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }

    @Override
    public String toString() {
        return sign;
    }

    public static ProductSeparators getIdBySign(String sign) {
        for (ProductSeparators separator : ProductSeparators.values()) {
            if (separator.getSign().equals(sign)) {
                return separator;
            }
        }
        return null;
    }
}
