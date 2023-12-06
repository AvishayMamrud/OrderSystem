package main.Catalog;

import main.Utilities.ItemType;
import main.Utilities.PackageName;
import main.Utilities.PackageUnit;
import main.Utilities.Packaging;

import java.util.HashSet;
import java.util.Set;

public class Product extends IProduct{
    private final Set<Packaging> packagings;

    public Product(Integer id, String name, String desc) {
        super(id, name, desc, ItemType.PRODUCT);
        packagings = new HashSet<>();
    }

    public Set<Integer> getItemIDs(){
        Set<Integer> setOfOne = new HashSet<>(1);
        setOfOne.add(this.ID);
        return setOfOne;
    }

    public void addPackaging(PackageName pn, int quantity, PackageUnit units){
        packagings.add(new Packaging(pn, quantity, units));
    }

    public void removePackaging(PackageName pn, int quantity, PackageUnit units){
        packagings.remove(new Packaging(pn, quantity, units));
    }

    public boolean hasPackaging(Packaging packaging) {
        return packagings.contains(packaging);
    }
}
