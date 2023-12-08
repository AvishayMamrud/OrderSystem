package main;

import main.Utilities.Operation;

public class Main {
  public static void main(String[] args){
    Operation op = null;
    System.out.printf("op = %s.\n", op);
    op = Operation.STORES_MANAGEMENT;
    System.out.println(op);
//    facade f = new facade();
  }
}
