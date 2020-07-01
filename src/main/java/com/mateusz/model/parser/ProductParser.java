package com.mateusz.model.parser;

import com.mateusz.enums.ProductSeparators;
import com.mateusz.model.Boots;
import com.mateusz.model.Cloth;
import com.mateusz.model.Product;

public class ProductParser {
    public static Product stringToProduct(String productString) {
        final ProductSeparators productType = ProductSeparators.getIdBySign(productString.substring(0,1));

        switch (productType) {
            case PRODUCT_ID:
                return convertToProduct(productString);
            case CLOTH_ID:
                return convertToCloth(productString);
            case BOOTS_ID:
                return convertToBoots(productString);
        }
        return null;
    }

    private static Product convertToProduct(String productString) {
        String [] productInformation = productString.split(ProductSeparators.PRODUCT_SEPARATOR.toString());

        int id = Integer.parseInt(productInformation[1]);
        String productName = productInformation[2];
        float price = Float.parseFloat(productInformation[3]);
        float weight = Float.parseFloat(productInformation[4]);
        String color = productInformation[5];
        int productCount = Integer.parseInt(productInformation[6]);

        return new Product(id, productName,price, weight, color, productCount);
    }

    private static Product convertToCloth(String productString) {
        String [] productInformation = productString.split(ProductSeparators.PRODUCT_SEPARATOR.toString());

        int id = Integer.parseInt(productInformation[1]);
        String productName = productInformation[2];
        float price = Float.parseFloat(productInformation[3]);
        float weight = Float.parseFloat(productInformation[4]);
        String color = productInformation[5];
        int productCount = Integer.parseInt(productInformation[6]);
        String size = productInformation[7];
        String material = productInformation[8];

        return new Cloth(id, productName,price, weight, color, productCount, size, material);
    }

    private static Product convertToBoots(String productString) {
        String [] productInformation = productString.split(ProductSeparators.PRODUCT_SEPARATOR.toString());

        int id = Integer.parseInt(productInformation[1]);
        String productName = productInformation[2];
        float price = Float.parseFloat(productInformation[3]);
        float weight = Float.parseFloat(productInformation[4]);
        String color = productInformation[5];
        int productCount = Integer.parseInt(productInformation[6]);
        int size = Integer.parseInt(productInformation[7]);
        boolean isNaturalSkin = Boolean.parseBoolean(productInformation[8]);

        return new Boots(id, productName,price, weight, color, productCount, size, isNaturalSkin);
    }
}
