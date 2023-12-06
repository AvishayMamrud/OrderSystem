package main.Catalog;

import main.Utilities.ItemType;

import java.util.HashSet;
import java.util.Set;

public abstract class IProduct {
    public final int ID;
    private String name;
    private String desc;
    private ItemType type;

    protected IProduct(int id, String name, String desc, ItemType type) {
        ID = id;
        this.name = name;
        this.desc = desc;
        this.type = type;
    }

    public abstract Set<Integer> getItemIDs();
}
