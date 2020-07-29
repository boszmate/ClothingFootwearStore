package com.mateusz.api;

import com.mateusz.exception.ProductCountNegativeException;
import com.mateusz.exception.ProductNameEmptyException;
import com.mateusz.exception.ProductPriceNoPositiveException;
import com.mateusz.exception.ProductWeightNoPositiveException;
import com.mateusz.model.Product;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    List<Product> getAllProducts() throws IOException;
    int getCountOfProducts() throws IOException;
    Product getProductByProductName(String productName) throws IOException;
    Product getProductByProductId(int productId) throws IOException;

    boolean isProductOnWarehouse(String productName) throws IOException;
    boolean isProductExist(String productName) throws IOException;
    boolean isProductExist(int productId) throws IOException;

    boolean saveProduct(Product product) throws IOException, ProductWeightNoPositiveException, ProductNameEmptyException, ProductCountNegativeException, ProductPriceNoPositiveException;
    void removeProduct(String productName) throws Exception;
}
