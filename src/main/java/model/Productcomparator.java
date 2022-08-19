package model;

import java.util.Comparator;

public class Productcomparator  implements Comparator<DTO> {

    @Override
    public int compare(DTO product1, DTO product2) {
        return product1.getProductQuantity() < product2.getProductQuantity() ? 1 : -1;
    }
}
