package main.Catalog;

import main.Utilities.Packaging;

import java.util.*;

public class ProductController {
  private Map<Integer, IProduct> items;
  public ProductController(){
      this.items = new HashMap<>();
  }

  public void addNewProduct(Category categoryId, Integer id, String name, String description, Set<Packaging> packagings){

  }

  public void deleteProduct(Integer id){

  }

  public void removeFromCategory(Integer id, Integer oldCategoryId){

  }

  public void addToCategory(Integer id, Integer newCategoryId){

  }

  public Set<IProduct> getProducts(Integer itemId){
    Set<IProduct> ret_val = new HashSet<>();
    for (Integer id : items.get(itemId).getItemIDs()) {
      ret_val.add(items.get(id));
    }
    return ret_val;
  }






}
