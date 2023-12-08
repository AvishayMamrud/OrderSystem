package main.Permissions;

import java.util.HashSet;
import java.util.Set;

public class ProductExclusion {
  private final Set<Integer> excludedProducts;
  public ProductExclusion(){
    this(new HashSet<>());
  }
  public ProductExclusion(Set<Integer> excludedProducts){
    this.excludedProducts = excludedProducts;
  }
  public boolean checkAccess(Integer productID){
    return !excludedProducts.contains(productID);
  }
  public void addExcludedProduct(Integer productID) {
    excludedProducts.add(productID);
  }
  public boolean removeExcludedProduct(Integer productID) {
    return excludedProducts.remove(productID);
  }
}
