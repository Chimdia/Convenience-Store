package SupplyPackage;

import model.Product;
import model.Store;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SupplyList {
    private BufferedReader bufferedReader;
    private String line;
    Store store = new Store();
    Product product = null;

    public SupplyList(String path) {
        try {
            this.bufferedReader = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        this.line = "";

    }


    public String readProductFile(Product product, Store store) {
        String result = "";
        try {

            while ((line = bufferedReader.readLine()) != null) {
                String[] values = line.split(",");

//                int newQty = 0;
                int productIndex = store.searchForProduct(values[1]);
                if (store.searchForProduct(values[1]) >= 0) {
                    Product productInStore = store.getSupplyList().get(productIndex);
                    productInStore.setQuantity(productInStore.getQuantity() + Integer.parseInt(values[2]));
                } else {
                    String productName = values[1];
                    String category = values[0];
                    int quantity = Integer.parseInt(values[2]);
                    double price = Double.parseDouble(values[3]);

                    product =new Product(productName,category,quantity,price);
                    store.getSupplyList().add(product);
                    result = "added";
                }

            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return result;
    }
}

