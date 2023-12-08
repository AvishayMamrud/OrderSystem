package main.Users;

import main.Utilities.Operation;

import java.util.Map;

public class UserController {
  private Map<Integer, User> LoggedInUsers;
  private Map<Integer, User> users;
  public UserController(){}
  private User getUser(Integer userID){
    //todo
    return null;
  }
  public boolean register(Integer userID, String name){
    //todo
    return false;
  }
  public boolean login(Integer userID){
    //todo
    return false;
  }
  public boolean logout(Integer userID){
    //todo
    return false;
  }


  public void grantPermission(Integer userID, Integer storeID, Operation op){
    //todo
  }
  public boolean denyPermission(Integer userID, Integer storeID, Operation op){
    //todo
    return false;
  }
  public void grantPermission(Integer userID, Operation op){
    //todo
  }
  public boolean denyPermission(Integer userID, Operation op){
    //todo
    return false;
  }
  public boolean checkAccess(Integer userID, Integer storeID, Operation op) {
    //todo
    return false;
  }
  public boolean checkAccess(Integer userID, Operation op){
    //todo
    return false;
  }
}
