package com.mateusz.api;

import com.mateusz.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Integer getCountOfProducts();
    Product getProductByProductName(String productName);
    boolean isProductOnWarehouse(String productName);
    boolean isProductExist(String productName);
    boolean isProductExist(int productId);
}
