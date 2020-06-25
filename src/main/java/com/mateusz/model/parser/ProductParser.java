package com.mateusz.model.parser;

import com.mateusz.model.Boots;
import com.mateusz.model.Cloth;
import com.mateusz.model.Product;

public class ProductParser {
    public static Product stringToProduct(String productString) {
        final char productType = productString.charAt(0);

        switch (productType) {
            case Product.PRODUCT_TYPE:
                return convertToProduct(productString);
            case Cloth.PRODUCT_TYPE:
                return convertToCloth(productString);
            case Boots.PRODUCT_TYPE:
                return convertToBoots(productString);
        }
        return null;
    }

    private static Product convertToProduct(String productString) {
        String [] productInformation = productString.split(Product.PRODUCT_SEPARATOR);

        int id = Integer.parseInt(productInformation[1]);
        String productName = productInformation[2];
        float price = Float.parseFloat(productInformation[3]);
        float weight = Float.parseFloat(productInformation[4]);
        String color = productInformation[5];
        int productCount = Integer.parseInt(productInformation[6]);

        return new Product(id, productName,price, weight, color, productCount);
    }

    private static Product convertToCloth(String productString) {
        String [] productInformation = productString.split(Product.PRODUCT_SEPARATOR);

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
        String [] productInformation = productString.split(Product.PRODUCT_SEPARATOR);

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
