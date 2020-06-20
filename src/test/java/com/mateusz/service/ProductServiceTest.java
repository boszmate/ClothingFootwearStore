package com.mateusz.service;

import com.mateusz.api.ProductService;
import com.mateusz.model.Boots;
import com.mateusz.model.Cloth;
import com.mateusz.model.Product;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceTest {
    @Test
    public void testGetAllProductsPositive(){
        List<Product> products = new ArrayList<Product>();
        products.add(new Cloth(1, "T-Shirt", 20.00f, 0.3f, "Black", 20, "XL", "COTTON"));
        products.add(new Cloth(2, "T-Shirt", 25.00f, 0.2f, "White", 30, "XL", "COTTON"));
        products.add(new Boots(3, "Sneakers", 60.00f, 0.8f, "Black", 10, 46, true));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        List<Product> productsForTests = productService.getAllProducts();

        Assert.assertEquals(products, productsForTests);
    }

    @Test
    public void testGetAllProductsNegative(){
        List<Product> products = new ArrayList<Product>();
        products.add(new Cloth(1, "T-Shirt", 20.00f, 0.3f, "Black", 20, "XL", "COTTON"));
        products.add(new Cloth(2, "T-Shirt", 25.00f, 0.2f, "White", 30, "XL", "COTTON"));
        products.add(new Boots(3, "Sneakers", 60.00f, 0.8f, "Black", 10, 46, true));

        ProductServiceImpl productService = new ProductServiceImpl(new ArrayList<Product>(products));
        List<Product> productsForTests = productService.getAllProducts();

        products.add(new Boots(4, "Trainers", 45.00f, 0.75f, "Black", 15, 46, false));

        Assert.assertNotEquals(products, productsForTests);
    }

    @Test
    public void testGetCountOfProducts(){
        List<Product> products = new ArrayList<Product>();
        products.add(new Cloth(1, "T-Shirt", 20.00f, 0.3f, "Black", 20, "XL", "COTTON"));
        products.add(new Cloth(2, "T-Shirt", 25.00f, 0.2f, "White", 30, "XL", "COTTON"));
        products.add(new Boots(3, "Sneakers", 60.00f, 0.8f, "Black", 10, 46, true));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final int countForTest = productService.getCountOfProducts();

        Assert.assertEquals(products.size(), countForTest);
    }

    @Test
    public void testGetCountOfProductsWithoutProducts(){
        ProductServiceImpl productService = new ProductServiceImpl();
        final int countForTest = productService.getCountOfProducts();

        Assert.assertEquals(0, countForTest);
    }

    @Test
    public void testGetProductByProductNameWhenExist(){
        List<Product> products = new ArrayList<Product>();
        Product cloth = new Cloth(1, "T-Shirt", 20.00f, 0.3f, "Black", 20, "XL", "COTTON");
        Product boot = new Boots(2, "Sneakers", 60.00f, 0.8f, "Black", 10, 46, true);
        products.add(cloth);
        products.add(boot);

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final Product productFotTest = productService.getProductByProductName("T-Shirt");

        Assert.assertEquals(cloth, productFotTest);
    }

    @Test
    public void testGetProductByProductNameWhenNoExist(){
        List<Product> products = new ArrayList<Product>();
        Product cloth = new Cloth(1, "T-Shirt", 20.00f, 0.3f, "Black", 20, "XL", "COTTON");
        Product boot = new Boots(2, "Sneakers", 60.00f, 0.8f, "Black", 10, 46, true);
        products.add(cloth);
        products.add(boot);

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final Product productFotTest = productService.getProductByProductName("Trainers");

        Assert.assertNull(productFotTest);
    }

    @Test
    public void testIsProductOnWarehouseWhenIs(){
        List<Product> products = new ArrayList<Product>();
        Product cloth = new Cloth(1, "T-Shirt", 20.00f, 0.3f, "Black", 20, "XL", "COTTON");
        Product boot = new Boots(2, "Sneakers", 60.00f, 0.8f, "Black", 10, 46, true);
        products.add(cloth);
        products.add(boot);

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean isProductOnWarehouse = productService.isProductOnWarehouse("T-Shirt");

        Assert.assertTrue(isProductOnWarehouse);
    }

    @Test
    public void testIsProductOnWarehouseWhenIsNot(){
        List<Product> products = new ArrayList<Product>();
        Product cloth = new Cloth(1, "T-Shirt", 20.00f, 0.3f, "Black", 20, "XL", "COTTON");
        Product boot = new Boots(2, "Sneakers", 60.00f, 0.8f, "Black", 10, 46, true);
        products.add(cloth);
        products.add(boot);

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean isProductOnWarehouse = productService.isProductOnWarehouse("Trainers");

        Assert.assertFalse(isProductOnWarehouse);
    }

    @Test
    public void testIsProductExistByName(){
        List<Product> products = new ArrayList<Product>();
        Product cloth = new Cloth(1, "T-Shirt", 20.00f, 0.3f, "Black", 20, "XL", "COTTON");
        Product boot = new Boots(2, "Sneakers", 60.00f, 0.8f, "Black", 10, 46, true);
        products.add(cloth);
        products.add(boot);

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean isProductExist = productService.isProductExist("T-Shirt");

        Assert.assertTrue(isProductExist);
    }

    @Test
    public void testIsProductNotExistByName(){
        List<Product> products = new ArrayList<Product>();
        Product cloth = new Cloth(1, "T-Shirt", 20.00f, 0.3f, "Black", 20, "XL", "COTTON");
        Product boot = new Boots(2, "Sneakers", 60.00f, 0.8f, "Black", 10, 46, true);
        products.add(cloth);
        products.add(boot);

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean isProductExist = productService.isProductExist("Trainers");

        Assert.assertFalse(isProductExist);
    }

    @Test
    public void testIsProductExistBtId(){
        List<Product> products = new ArrayList<Product>();
        Product cloth = new Cloth(1, "T-Shirt", 20.00f, 0.3f, "Black", 20, "XL", "COTTON");
        Product boot = new Boots(2, "Sneakers", 60.00f, 0.8f, "Black", 10, 46, true);
        products.add(cloth);
        products.add(boot);

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean isProductExist = productService.isProductExist(1);

        Assert.assertTrue(isProductExist);
    }

    @Test
    public void testIsProductNotExistById(){
        List<Product> products = new ArrayList<Product>();
        Product cloth = new Cloth(1, "T-Shirt", 20.00f, 0.3f, "Black", 20, "XL", "COTTON");
        Product boot = new Boots(2, "Sneakers", 60.00f, 0.8f, "Black", 10, 46, true);
        products.add(cloth);
        products.add(boot);

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean isProductExist = productService.isProductExist(3);

        Assert.assertFalse(isProductExist);
    }
}
