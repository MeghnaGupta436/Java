package Feb19;

class Singleton {
    // Private static instance variable of the same class
    static Singleton obj = new Singleton();

    // Private constructor to prevent direct instantiation
    private Singleton() {}

    // Public static method to provide a global point of access to the instance
    public static Singleton getInstance() {

        return obj;
    }
}

public class MainSingleton {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        // Print a message to verify that the instance is created
        System.out.println("Singleton instance created: " + (singleton1 == singleton2));

        // Make multiple calls to the static method and verify that the same instance is returned each time
        Singleton singleton3 = Singleton.getInstance();
        Singleton singleton4 = Singleton.getInstance();

        // Verify that the same instance is returned each time
        System.out.println("Multiple calls to getInstance() return the same instance: " + (singleton3 == singleton4));
    }
}