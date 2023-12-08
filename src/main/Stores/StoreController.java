package main.Stores;

import java.util.HashMap;
import java.util.Map;

public class StoreController {
  private Integer nextStoreID;
  private final Map<Integer, Store> stores;
  public StoreController(){
    this(new HashMap<>());
  }
  public StoreController(Map<Integer, Store> stores){
    this.stores = stores;
  }
  private Store getStore(Integer storeID){
    isValidStoreID(storeID);
    Store store = stores.get(storeID);
    if(store != null){
      return store;
    }
    throw new IllegalArgumentException("the store with ID - %d does not exists".formatted(storeID));
  }
  public void addNewStore(String storeName){
    isValidStoreID(nextStoreID);
    stores.put(nextStoreID, new Store(nextStoreID, storeName));
    nextStoreID++;
  }
  public boolean removeStore(Integer storeId){
    isValidStoreID(storeId);
    return stores.remove(storeId) != null;
  }
  private void isValidStoreID(Integer storeId) {
    if(storeId == null || storeId < 0)
      throw new IllegalArgumentException("storeID expected to be greater than 0. actual - %s.".formatted(storeId));
  }
  //------------------------------Store--------------------------------
  public void addExcludedProduct(Integer storeID, Integer productID){
    getStore(storeID).addExcludedProduct(productID);
  }
  public boolean removeExcludedProduct(Integer storeID, Integer productID){
    return getStore(storeID).removeExcludedProduct(productID);
  }
  public boolean checkAccess(Integer storeID, Integer productID){
    return getStore(storeID).checkAccess(productID);
  }
}