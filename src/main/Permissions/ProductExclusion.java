package main.Permissions;

import java.util.Set;

public class ProductExclusion {
  private Set<Integer> excludedProducts;
  public boolean checkAccess(Integer productID){
    return !excludedProducts.contains(productID);
  }
  public void addExcludedProduct(Integer productID) {
    excludedProducts.add(productID);
  }
}
