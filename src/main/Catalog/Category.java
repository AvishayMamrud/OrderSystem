package main.Catalog;

import main.Utilities.ItemType;

import java.util.*;

public class Category extends IProduct implements Iterable<Integer>{
    private Set<Integer> itemIDs;

    public Category(int id, String name, String desc, Set<Integer> itemIDs){
        super(id, name, desc, ItemType.CATEGORY);
        this.itemIDs = itemIDs;
    }

    public Category(int id, String name, String desc){
        this(id, name, desc, new HashSet<>());
    }

    public void addItem(Integer id){
        itemIDs.add(id);
    }

    public boolean removeItem(Integer id){
        return itemIDs.remove(id);
    }

    public Set<Integer> getItemIDs(){
        return new HashSet<>(itemIDs);
    }

    @Override
    public Iterator<Integer> iterator() {
        return itemIDs.iterator();
    }
}
