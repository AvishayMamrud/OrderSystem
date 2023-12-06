package main;

import main.Catalog.ProductController;
import main.DependencyInverse.Factory;
import main.DependencyInverse.ILogger;
import main.DependencyInverse.INotifier;
import main.Orders.OrderController;
import main.Stores.StoreController;
import main.Users.UserController;

public class facade {
    private OrderController oc;
    private StoreController sc;
    private ProductController pc;
    private UserController uc;
    private ILogger logger;
    private INotifier notifier;
    public facade(){
        this.logger = Factory.getLogger();
        this.notifier = Factory.getNotifier();
        oc = new OrderController();
        sc = new StoreController();
        pc = new ProductController();
        uc = new UserController();
    }
}
