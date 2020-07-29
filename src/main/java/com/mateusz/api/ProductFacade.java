package com.mateusz.api;

import com.mateusz.model.Product;

import java.util.List;

public interface ProductFacade {
    String createProduct(Product product);
    String removeProduct(String productName);

    List<Product> getAllProducts();
}
