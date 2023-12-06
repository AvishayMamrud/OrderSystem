package main.Orders;

import main.Catalog.IProduct;
import main.Catalog.Product;
import main.Utilities.OrderStatus;
import main.Utilities.Packaging;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Order {
  private final int storeID;
  private OrderStatus status = OrderStatus.IN_PROGRESS;
  private LocalDate placementDate = null;
  private Map<Integer, List<OrderedProduct>> products;

  public Order(int storeID) {
      this.storeID = storeID;
  }

  public Order(int storeID, OrderStatus status, LocalDate placementDate, Map<Integer, List<OrderedProduct>> products) {
    this.storeID = storeID;
    this.status = status;
    this.placementDate = placementDate;
    this.products = products;
  }

  public void addProduct(Product product, int amount, Packaging packaging){
    if(!product.hasPackaging(packaging))
      throw new IllegalArgumentException("this packaging (%S) is not an option for the '%s' product."
        .formatted(packaging, product.getName()));
    if(!products.containsKey(product.ID))
      products.put(product.ID, new ArrayList<>());
    products.get(product.ID).add(new OrderedProduct(product, amount, packaging));
  }

  public boolean removeProduct(Product product, Packaging packaging){
    if(!products.containsKey(product.ID))
      return false;
    List<OrderedProduct> opLst = products.get(product.ID);
    return opLst.removeIf(op -> op.getPackaging().equals(packaging));
  }

  public void submitOrder(){
    status = OrderStatus.COMPLETE;
    placementDate = LocalDate.now();
  }

  public void closeOrder(){
    status = OrderStatus.CLOSED;
  }
}
