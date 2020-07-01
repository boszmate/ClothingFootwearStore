package com.mateusz.service;

import com.mateusz.api.ProductDao;
import com.mateusz.api.ProductService;
import com.mateusz.dao.ProductDaoImpl;
import com.mateusz.model.Product;
import com.mateusz.validator.ProductValidator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private static ProductServiceImpl instance = null;
    private ProductValidator productValidator = ProductValidator.getInstance();
    private ProductDao productDao = ProductDaoImpl.getInstance();

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

    public int getCountOfProducts() throws IOException {
        return getAllProducts().size();
    }

    public Product getProductByProductName(String productName) throws IOException {
        List<Product> products = getAllProducts();

        for (Product product : products) {
            if (product.getProductName().equals(productName)) {
                return product;
            }
        }

        return null;
    }

    public Product getProductByProductId(int productId) throws IOException {
        List<Product> products = getAllProducts();

        for (Product product : products) {
            if (product.getId() == productId) {
                return product;
            }
        }

        return null;
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
            product = getProductByProductName(productName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return product != null;
    }

    public boolean isProductExist(int productId) {
        Product product = null;

        try {
            product = getProductByProductId(productId);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return product != null;
    }

    public boolean saveProduct(Product product) {
        try {
            if (productValidator.isValidate(product)) {
                productDao.saveProduct(product);
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
