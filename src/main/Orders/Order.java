package main.Orders;

import main.Catalog.Product;
import main.Utilities.OrderStatus;
import main.Utilities.Packaging;

import java.nio.file.AccessDeniedException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {
  public final int ID;
//  private final int storeID;
  private OrderStatus status = OrderStatus.IN_PROGRESS;
  private LocalDate placementDate = null;
  private final Map<Integer, List<OrderedProduct>> products;
  public Order(int ID, int storeID) {
    this(ID, storeID, OrderStatus.IN_PROGRESS, null, new HashMap<>());
  }
  public Order(int ID, int storeID, OrderStatus status, LocalDate placementDate, Map<Integer, List<OrderedProduct>> products) {
    this.ID = ID;
//    this.storeID = storeID;
    this.status = status;
    this.placementDate = placementDate;
    this.products = products;
  }
  public void addProduct(Product product, int amount, Packaging packaging) {
    if(status != OrderStatus.IN_PROGRESS)
      throw new IllegalArgumentException("this order has been %s.".formatted(status));
    if(!product.hasPackaging(packaging))
      throw new IllegalArgumentException("this packaging (%S) is not an option for the '%s' product."
        .formatted(packaging, product.getName()));
    if(!products.containsKey(product.ID))
      products.put(product.ID, new ArrayList<>());
    products.get(product.ID).add(new OrderedProduct(product, amount, packaging));
  }
  public boolean removeProduct(Product product, Packaging packaging){
    if(status != OrderStatus.IN_PROGRESS)
      throw new IllegalArgumentException("this order has been %s.".formatted(status));
    if(!products.containsKey(product.ID))
      return false;
    List<OrderedProduct> opLst = products.get(product.ID);
    return opLst.removeIf(op -> op.getPackaging().equals(packaging));
  }
  public void submitOrder(){
    if(status == OrderStatus.CLOSED)
      throw new IllegalArgumentException("this order has been %s.".formatted(status));
    status = OrderStatus.COMPLETE;
    placementDate = LocalDate.now();
  }
  public void closeOrder(){
    status = OrderStatus.CLOSED;
  }
}
