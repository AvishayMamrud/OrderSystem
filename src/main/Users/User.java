package main.Users;

import main.Permissions.OperationAccess;

import java.util.Map;

public class User {
  private String name;
  private int ID;
  private Map<Integer, OperationAccess> accessControl;
}
