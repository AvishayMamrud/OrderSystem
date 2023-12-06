package main.Orders;

import main.Utilities.OrderStatus;

import java.time.LocalDate;

public class Order {
    private final int storeID;
    private OrderStatus status = OrderStatus.IN_PROGRESS;
    private LocalDate placementDate = null;

    public Order(int storeID) {
        this.storeID = storeID;
    }
}
