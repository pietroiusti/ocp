/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocp.DesignPatterns;

/**
 *
 * @author PietroS
 */
public class SingletonExample {

    private int quantity = 0;

    private SingletonExample() {
    }
//    private static final SingletonExample instance = new SingletonExample();
    private static final SingletonExample instance;

    static {
        instance = new SingletonExample();
// Perform additional steps
    }

    public static SingletonExample getInstance() {

        if (instance == null) {
//            instance = new SingletonExample(); // LAZY INST - NOT THREAD-SAFE!
        }

        return instance;
    }

    public synchronized void addHay(int amount) {
        quantity += amount;
    }

    public synchronized boolean removeHay(int amount) {
        if (quantity < amount) {
            return false;
        }
        quantity -= amount;
        return true;
    }

    public synchronized int getHayQuantity() {
        return quantity;
    }
}
