package com.mateusz;

import com.mateusz.api.ProductService;
import com.mateusz.api.UserRegisterLoginFacade;
import com.mateusz.facade.UserRegisterLoginFacadeImpl;
import com.mateusz.model.Boots;
import com.mateusz.model.Cloth;
import com.mateusz.model.Product;
import com.mateusz.model.User;
import com.mateusz.service.ProductServiceImpl;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void startMenu() {
        System.out.println("App Menu");
        System.out.println("1. Log in");
        System.out.println("2. Register");
        System.out.println("3. Exit");
    }

    public static void loggedMenu() {
        System.out.println("App Menu");
        System.out.println("1. Add new product");
        System.out.println("0. Log out");
    }

    public static void productTypeMenu() {
        System.out.println("1. Add boots");
        System.out.println("2. Add cloths");
        System.out.println("3. Other");
    }

    public static Product createOtherProduct() {
        String productName, color;
        float price, weight;
        int count;

        System.out.println("ProductName: ");
        productName = scanner.next();

        System.out.println("Price: ");
        price = scanner.nextFloat();

        System.out.println("Weight: ");
        weight = scanner.nextFloat();

        System.out.println("Color: ");
        color = scanner.next();

        System.out.println("Count: ");
        count = scanner.nextInt();

        return new Product(1, productName, price, weight, color, count);
    }

    public static Product createBootsProduct() {
        String productName, color;
        float price, weight;
        int count, size;
        Boolean isNaturalSkin;

        System.out.println("ProductName: ");
        productName = scanner.next();

        System.out.println("Price: ");
        price = scanner.nextFloat();

        System.out.println("Weight: ");
        weight = scanner.nextFloat();

        System.out.println("Color: ");
        color = scanner.next();

        System.out.println("Count: ");
        count = scanner.nextInt();

        System.out.println("Size: ");
        size = scanner.nextInt();

        System.out.println("Is natural skin: ");
        isNaturalSkin = scanner.nextBoolean();


        return new Boots(1, productName, price, weight, color, count, size, isNaturalSkin);
    }

    public static Product createClothProduct() {
        String productName, color, size, material;
        float price, weight;
        int count;

        System.out.println("ProductName: ");
        productName = scanner.next();

        System.out.println("Price: ");
        price = scanner.nextFloat();

        System.out.println("Weight: ");
        weight = scanner.nextFloat();

        System.out.println("Color: ");
        color = scanner.next();

        System.out.println("Count: ");
        count = scanner.nextInt();

        System.out.println("Size: ");
        size = scanner.next();

        System.out.println("Material: ");
        material = scanner.next();


        return new Cloth(1, productName, price, weight, color, count, size, material);
    }

    public static void main(String[] args) {
        UserRegisterLoginFacade userFacade = UserRegisterLoginFacadeImpl.getInstance();
        ProductService productService = ProductServiceImpl.getInstance();
        boolean appOn = true;
        boolean loggedOn = false;
        int optionRead;

        while (appOn) {
            startMenu();
            optionRead = scanner.nextInt();

            switch (optionRead) {
                case 1:
                    System.out.print("Type login: ");
                    String loginLog = scanner.next();
                    System.out.print("Type password: ");
                    String passwordLog = scanner.next();
                    if (userFacade.loginUser(loginLog, passwordLog)) {
                        loggedOn = true;
                        System.out.println("Success! You login!");
                    } else {
                        System.out.println("Invalid login!");
                    }
                    break;
                case 2:
                    System.out.print("Type login: ");
                    String loginReg = scanner.next();
                    System.out.print("Type password: ");
                    String passwordReg = scanner.next();
                    User user = new User(1, loginReg, passwordReg);
                    if (userFacade.registerUser(user)) {
                        loggedOn = true;
                        System.out.println("Success! You registered!");
                    } else {
                        System.out.println("Something wrong with registration!");
                    }
                    break;
                case 3:
                    appOn = false;
                    break;
            }

            while (loggedOn) {
                loggedMenu();
                optionRead = scanner.nextInt();

                switch (optionRead) {
                    case 1:
                        productTypeMenu();
                        optionRead = scanner.nextInt();
                        Product product = null;
                        switch (optionRead) {
                            case 1:
                                product = createBootsProduct();
                                break;
                            case 2:
                                product = createClothProduct();
                                break;
                            case 3:
                                product = createOtherProduct();
                                break;
                        }
                        if (productService.saveProduct(product)) {
                            System.out.println("Product was created!");
                        } else {
                            System.out.println("Product wasn't created!");
                        }
                    case 0:
                        loggedOn = false;
                        break;
                }
            }
        }
    }
}
