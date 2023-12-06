package Utilities;

public class Packaging {
    public final PackageName name;
    public final int quantity;
    public final PackageUnit units;

    public Packaging(PackageName name, int quantity, PackageUnit units) {
        this.name = name;
        this.quantity = quantity;
        this.units = units;
    }
}
