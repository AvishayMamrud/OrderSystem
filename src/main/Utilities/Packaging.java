package main.Utilities;

public class Packaging {
  public final PackageName name;
  public final int quantity;
  public final PackageUnit units;

  public Packaging(PackageName name, int quantity, PackageUnit units) {
    this.name = name;
    this.quantity = quantity;
    this.units = units;
  }

  @Override
  public boolean equals(Object o1){
    if(o1 instanceof Packaging other) {
      return other.name.equals(name) &&
        other.quantity == quantity &&
        other.units.equals(units);
    }
    return false;
  }

  @Override
  public String toString(){
    return "%s - %d %s".formatted(name.toString().toLowerCase(), quantity, units.toString().toLowerCase());
  }
}
