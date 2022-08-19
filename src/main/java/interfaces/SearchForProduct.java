package interfaces;

import model.Product;

public interface SearchForProduct {

     default int searchForProduct(String productName){

        return 0;
    }
}
