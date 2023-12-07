package main.Stores;

import main.Orders.Order;
import main.Permissions.ProductExclusion;

import java.util.List;

public class Store {
  private int ID;
  private String name;
  private ProductExclusion productAccess;
  public Store(Integer ID, String name){
    this(ID, name, new ProductExclusion());
  }
  public Store(Integer ID, String name, ProductExclusion productAccess){
    this.ID = ID;
    this.name = name;
    this.productAccess = productAccess;
  }
  public void addExcludedProduct(Integer productID){
    productAccess.addExcludedProduct(productID);
  }
  public boolean checkAccess(Integer productID){
    return productAccess.checkAccess(productID);
  }
}
