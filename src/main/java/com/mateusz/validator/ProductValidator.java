package com.mateusz.validator;

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

    public boolean isValidate(Product product) {
        return true;
    }
}
