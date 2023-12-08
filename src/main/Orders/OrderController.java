package main.Orders;

import main.Catalog.Product;
import main.Utilities.Packaging;

import java.util.*;

public class OrderController {
  //todo
  private Integer nexOrderID;
  private Map<Integer, Order> activeOrders; // maps storeID to its in-progress order
  private Map<Integer, List<Order>> completedOrders; // maps storeID to its list of completed orders
  public OrderController(){
    this(new HashMap<>(), new HashMap<>(), 0);
  }
  public OrderController(Map<Integer, Order> activeOrders, Map<Integer, List<Order>> completedOrders, Integer nextOrderID){
    this.activeOrders = activeOrders;
    this.completedOrders = completedOrders;
    this.nexOrderID = nextOrderID;
  }
  public void addProductToOrder(Integer storeID, Product product, int amount, Packaging packaging){
    isValidStoreID(storeID);
    Order order = activeOrders.get(storeID);
    if(order == null){
      activeOrders.put(storeID, new Order(nexOrderID++, storeID));
      order = activeOrders.get(storeID);
    }
    order.addProduct(product, amount, packaging);
  }
  public boolean removeProductFromOrder(Integer storeID, Product product, Packaging packaging){
    isValidStoreID(storeID);
    Order order = activeOrders.get(storeID);
    if(order != null){
      return order.removeProduct(product, packaging);
    }
    return false;
  }
  public void submitOrder(Integer storeID){
    isValidStoreID(storeID);
    Order order = activeOrders.get(storeID);
    if(order != null){
      order.submitOrder();
      activeOrders.remove(storeID);
      addCompletedOrder(storeID, order);
    }
  }
  private void addCompletedOrder(Integer storeID, Order order) {
    isValidStoreID(storeID);
    List<Order> orders = completedOrders.get(storeID);
    if(orders == null){
      completedOrders.put(storeID, new ArrayList<>());
      orders = completedOrders.get(storeID);
    }
    orders.add(order);
  }
  public void closeOrder(Integer storeID, Order order){
    isValidStoreID(storeID);
    List<Order> orders = completedOrders.get(storeID);
    if(orders != null){
      Order order1 = orders.stream().filter(x->x.ID==order.ID).findFirst().orElse(null);
      if(order1 != null) {
        orders.remove(order1);
        order1.closeOrder();
      }
    }
  }
  private void isValidStoreID(Integer storeId) {
    if(storeId == null || storeId < 0)
      throw new IllegalArgumentException("storeID expected to be greater than 0. actual - %s.".formatted(storeId));
  }
}
