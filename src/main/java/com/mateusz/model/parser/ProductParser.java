package com.mateusz.model.parser;

import com.mateusz.model.Boots;
import com.mateusz.model.Cloth;
import com.mateusz.model.Product;

public class ProductParser {
    public static Product stringToProduct(String productString, String productType) {
        if (productType.equals("PRODUCT")) {
            return convertToProduct(productString);
        }
        else if (productType.equals("CLOTH")) {
            return convertToCloth(productString);
        }
        else if (productType.equals("BOOTS")) {
            return convertToBoots(productString);
        }
        return null;
    }

    private static Product convertToProduct(String productString) {
        String [] productInformation = productString.split(Product.PRODUCT_SEPARATOR);

        int id = Integer.parseInt(productInformation[0]);
        String productName = productInformation[1];
        float price = Float.parseFloat(productInformation[2]);
        float weight = Float.parseFloat(productInformation[3]);
        String color = productInformation[4];
        int productCount = Integer.parseInt(productInformation[5]);

        return new Product(id, productName,price, weight, color, productCount);
    }

    private static Product convertToCloth(String productString) {
        String [] productInformation = productString.split(Product.PRODUCT_SEPARATOR);

        int id = Integer.parseInt(productInformation[0]);
        String productName = productInformation[1];
        float price = Float.parseFloat(productInformation[2]);
        float weight = Float.parseFloat(productInformation[3]);
        String color = productInformation[4];
        int productCount = Integer.parseInt(productInformation[5]);
        String size = productInformation[6];
        String material = productInformation[7];

        return new Cloth(id, productName,price, weight, color, productCount, size, material);
    }

    private static Product convertToBoots(String productString) {
        String [] productInformation = productString.split(Product.PRODUCT_SEPARATOR);

        int id = Integer.parseInt(productInformation[0]);
        String productName = productInformation[1];
        float price = Float.parseFloat(productInformation[2]);
        float weight = Float.parseFloat(productInformation[3]);
        String color = productInformation[4];
        int productCount = Integer.parseInt(productInformation[5]);
        int size = Integer.parseInt(productInformation[6]);
        boolean isNaturalSkin = Boolean.parseBoolean(productInformation[7]);

        return new Boots(id, productName,price, weight, color, productCount, size, isNaturalSkin);
    }
}
