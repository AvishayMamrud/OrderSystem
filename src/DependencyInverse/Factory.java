package DependencyInverse;

public class Factory {
    public static ILogger getLogger(){
        return System.out::println;
    }

    public static INotifier getNotifier(){
        return (msg)->true;
    }
}
