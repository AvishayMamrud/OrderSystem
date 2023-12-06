package main.Orders;

import main.Catalog.Product;
import main.Utilities.Packaging;

public class OrderedProduct {
  private final Product product;
  private int amount;
  private Packaging packaging;

  public OrderedProduct(Product product, int amount, Packaging packaging) {
    this.product = product;
    this.amount = amount;
    this.packaging = packaging;
  }

  public Packaging getPackaging(){
    return packaging;
  }
}
