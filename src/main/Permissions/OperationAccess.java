package main.Permissions;

import main.Utilities.Operation;

import java.util.*;

public class OperationAccess {
  private final Map<Integer, List<Operation>> ops;
  public OperationAccess(){
      this.ops = new HashMap<>();
  }
  public OperationAccess(Map<Integer, List<Operation>> ops){
      this.ops = ops;
  }
  public void grantPermission(Integer storeID, Operation op){
    if(op == null ||
        op.equals(Operation.ORDERS_MANAGEMENT) ||
        op.equals(Operation.CATALOG_MANAGEMENT) ||
        op.equals(Operation.STORES_MANAGEMENT) ||
        op.equals(Operation.PERMISSION_MANAGEMENT)){
      throw new IllegalArgumentException("the '%s' operation is an admin level permission and should not depend on a specific store. try the overloading method.".formatted(op));
    }
    if(!ops.containsKey(storeID)){
      ops.put(storeID, new ArrayList<>());
    }
    ops.get(storeID).add(op);
  }
  public boolean denyPermission(Integer storeID, Operation op){
    if(storeID != null && ops.containsKey(storeID)){
      List<Operation> lst = ops.get(storeID);
      boolean res = lst.remove(op);
      if(lst.isEmpty()){
        ops.remove(storeID);
      }
      return res;
    }
    return false;
  }
  public void grantPermission(Operation op){
    if(op != null &&
        (op.equals(Operation.ORDERS_MANAGEMENT) ||
        op.equals(Operation.CATALOG_MANAGEMENT) ||
        op.equals(Operation.STORES_MANAGEMENT) ||
        op.equals(Operation.PERMISSION_MANAGEMENT))){
      if(!ops.containsKey(-1)){
        ops.put(-1, new ArrayList<>());
      }
      ops.get(-1).add(op);
    }
    else throw new IllegalArgumentException("this method is for granting admin permission that do not depend on a specific store. try the overloading method.");
  }
  public boolean denyPermission(Operation op){
    if(ops.containsKey(-1)){
      List<Operation> lst = ops.get(-1);
      boolean res = lst.remove(op);
      if(lst.isEmpty()){
        ops.remove(-1);
      }
      return res;
    }
    return false;
  }
  public boolean checkAccess(Integer storeID, Operation op){
    if(storeID != null && ops.containsKey(storeID)){
      return ops.get(storeID).contains(op);
    }
    return false;
  }
  public boolean checkAccess(Operation op){
    if(ops.containsKey(-1)){
      return ops.get(-1).contains(op);
    }
    return false;
  }
}
