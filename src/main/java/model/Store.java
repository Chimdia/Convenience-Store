package model;

import interfaces.SearchForProduct;

import java.util.ArrayList;
import java.util.List;

public class Store  implements SearchForProduct {

    String name;
    private Manager manager;
    private Cashier cashier;
    private  Customer customer;

    private List <Product> SupplyList = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getSupplyList() {
        return SupplyList;
    }

    public void setSupplyList(List<Product> supplyList) {
        this.SupplyList = supplyList;
    }




    @Override
    public int searchForProduct(String productName) {
        for (Product productInProductList : SupplyList) {
            if(productInProductList.getProductName().equalsIgnoreCase(productName)){
                return this.SupplyList.indexOf(productInProductList);
            }
        }
        return -1;
    }
    public Product addProduct(Product product){
        this.getSupplyList().add(product);
        return product;
    }


}
