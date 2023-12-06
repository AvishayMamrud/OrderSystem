package Orders;

import Utilities.OrderStatus;

import java.time.LocalDate;
import java.util.Date;

public class Order {
    private final int storeID;
    private OrderStatus status = OrderStatus.IN_PROGRESS;
    private LocalDate placementDate = null;

    public Order(int storeID) {
        this.storeID = storeID;
    }
}
