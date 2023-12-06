import Catalog.ProductController;
import DependencyInverse.Factory;
import DependencyInverse.ILogger;
import DependencyInverse.INotifier;
import Orders.OrderController;
import Stores.StoreController;
import Users.UserController;

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
    }
}
