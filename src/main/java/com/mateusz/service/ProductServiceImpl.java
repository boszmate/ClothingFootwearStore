package com.mateusz.service;

import com.mateusz.api.ProductDao;
import com.mateusz.api.ProductService;
import com.mateusz.dao.ProductDaoImpl;
import com.mateusz.model.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private static ProductServiceImpl instance = null;
    private ProductDao productDao = new ProductDaoImpl("products.data", "PRODUCT");

    private ProductServiceImpl() {}

    public static ProductServiceImpl getInstance() {
        if (instance == null) {
            instance = new ProductServiceImpl();
        }
        return instance;
    }

    public List<Product> getAllProducts() throws IOException {
        return productDao.getAllProducts();
    }

    public Integer getCountOfProducts() throws IOException {
        return getAllProducts().size();
    }

    public Product getProductByProductName(String productName) throws IOException {
        return productDao.getProductByProductName(productName);
    }

    public boolean isProductOnWarehouse(String productName) {
        try {
            for (Product product : getAllProducts()) {
                if (isProductExist(productName) && product.getProductCount() > 0) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean isProductExist(String productName) {
        Product product = null;

        try {
            product = productDao.getProductByProductName(productName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return product != null;
    }

    public boolean isProductExist(int productId) {
        Product product = null;

        try {
            product = productDao.getProductById(productId);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return product != null;
    }
}
