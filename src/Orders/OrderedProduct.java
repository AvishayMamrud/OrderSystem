package Orders;

import Utilities.Packaging;

public class OrderedProduct {
    private final int productID;
    private int amount;
    private Packaging packaging;

    public OrderedProduct(int productID, int amount, Packaging packaging) {
        this.productID = productID;
        this.amount = amount;
        this.packaging = packaging;
    }
}
