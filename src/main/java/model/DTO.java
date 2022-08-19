package model;

public class DTO {
    private String productName;
    private  int productQuantity;
    private  String name;

    public String getProductName() {
        return productName;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public String getName() {
        return name;
    }

    public DTO(String productName, int productQuantity, String name) {
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.name = name;
    }

    @Override
    public String toString() {
        return
                "productName='" + productName + '\'' +
                ", Quantity=" + productQuantity +
                ", Customer " + name
                ;
    }
}










