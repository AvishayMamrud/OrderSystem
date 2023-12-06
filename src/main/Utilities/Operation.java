package main.Utilities;

public enum Operation {
    //todo - list the operations that require permission

    // able to place order for a store (admin can place orders for all stores?)
    ORDER_PLACEMENT,
    // allowing another user to order for store
    PERMISSION_DELEGATION,


    // add and remove new products and categories.
    CATALOG_MANAGEMENT,
    // grant and deny permissions for users
    PERMISSION_MANAGEMENT,
    // watch, close and delete orders
    ORDERS_MANAGEMENT,
    // add and remove stores
    STORES_MANAGEMENT,
}
