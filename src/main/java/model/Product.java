package model;

import java.util.List;

public class Product {
    private String productName;
    private String category;
    private int quantity;
    private double price;

   private int qtyBuying;

    public Product(String productName, String category, int quantity, double price ) {
        this.productName = productName;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
//      this.qtyBuying = qtyBuying;
    }

    private List<Product> productList;

    public List<Product> getProductList() {

        return productList;
    }

    public String getProductName() {

        return productName;
    }

    public void setProductName(String productName)
    {
        this.productName = productName;
    }

    public int getQuantity() {

        return quantity;
    }

    public int getQtyBuying() {
        return qtyBuying;
    }

    public void setQtyBuying(int qtyBuying) {
        this.qtyBuying = qtyBuying;
    }

    public String getCategory() {
        return category;
    }

    public void setQuantity(int quantity) {

        this.quantity = quantity;
    }

    public double getPrice() {

        return price;
    }

    public void setPrice(double price) {

        this.price = price;
    }

//    public int getQtyInDemand() {
//
//        return qtyInDemand;
//    }

//    public void setQtyInDemand(int qtyInDemand)
//    {
//        this.qtyInDemand = qtyInDemand;
//    }



    @Override
    public String toString() {
        return  "Product{" +
                "productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                //", qtyBuying=" + qtyBuying +
               // ", productList=" + productList +
                  '}' + "\n";
    }


}
