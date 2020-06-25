package com.mateusz.validator;

import com.mateusz.exception.ProductCountNegativeException;
import com.mateusz.exception.ProductNameEmptyException;
import com.mateusz.exception.ProductPriceNoPositiveException;
import com.mateusz.exception.ProductWeightNoPositiveException;
import com.mateusz.model.Product;

public class ProductValidator {
    private static ProductValidator instance = null;

    private ProductValidator() {}

    public static ProductValidator getInstance() {
        if (instance == null) {
            instance = new ProductValidator();
        }

        return instance;
    }

    public boolean isValidate(Product product) throws ProductPriceNoPositiveException, ProductCountNegativeException, ProductWeightNoPositiveException, ProductNameEmptyException{
        if (isPriceNoPositive(product.getPrice())) {
            throw new ProductPriceNoPositiveException("Product price is not positive!");
        }

        if (isProductCountNegative(product.getProductCount())) {
            throw new ProductCountNegativeException("Product count is less than 0!");
        }

        if (isWeightNoPositive(product.getWeight())) {
            throw new ProductWeightNoPositiveException("Product weight is less or equals 0!");
        }

        if (isEmptyProductName(product.getProductName())) {
            throw new ProductNameEmptyException("Product name cannot be empty!");
        }

        return true;
    }

    private boolean isPriceNoPositive(float price) {
        return price <= 0.0f;
    }

    private boolean isProductCountNegative(int productCount) {
        return productCount < 0;
    }

    private boolean isWeightNoPositive(float weight) {
        return weight <= 0.0f;
    }

    private boolean isEmptyProductName(String productName) {
        return productName.length() == 0;
    }
}
