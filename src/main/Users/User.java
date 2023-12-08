package main.Users;

import main.Permissions.OperationAccess;
import main.Utilities.Operation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
  private String name;
  public final int ID;
  private final OperationAccess accessControl;
  public User(Integer ID, String name){
    this(ID, name, new OperationAccess());
  }
  public User(Integer ID, String name, OperationAccess accessControl){
    this.ID = ID;
    this.name = name;
    this.accessControl = accessControl;
  }
  public String getName(){
    return name;
  }
  public void grantPermission(Integer storeID, Operation op){
    accessControl.grantPermission(storeID, op);
  }
  public boolean denyPermission(Integer storeID, Operation op){
    return accessControl.denyPermission(storeID, op);
  }
  public void grantPermission(Operation op){
    accessControl.grantPermission(op);
  }
  public boolean denyPermission(Operation op){
    return accessControl.denyPermission(op);
  }
  public boolean checkAccess(Integer storeID, Operation op){
    return accessControl.checkAccess(storeID, op);
  }
  public boolean checkAccess(Operation op){
    return accessControl.checkAccess(op);
  }
}
