package main.Catalog;

import main.Utilities.ItemType;
import main.Utilities.Packaging;

import java.util.HashSet;
import java.util.Set;

public class Product extends IProduct{
    private Set<Packaging> packagings;

    public Product(Integer id, String name, String desc) {
        super(id, name, desc, ItemType.PRODUCT);
        packagings = new HashSet<>();
    }

    public Set<Integer> getItemIDs(){
        Set<Integer> setOfOne = new HashSet<>(1);
        setOfOne.add(this.ID);
        return setOfOne;
    }
}
