/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocp.Concurrency;

/**
 *
 * @author PietroS
 */
import java.util.concurrent.*;

public class DeadlockExample {

    public static void main(String[] args) {
// Create participants and resources
        Fox foxy = new Fox();
        Fox tails = new Fox();
        Food food = new Food();
        Water water = new Water();
// Process data
        ExecutorService service = null;
        try {
            service = Executors.newScheduledThreadPool(10);
            service.submit(() -> foxy.eatAndDrink(food, water, "foxy"));
            service.submit(() -> tails.drinkAndEat(food, water, "tails"));
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }
    }
}

class Food {
}

class Water {
}

class Fox {

    public void eatAndDrink(Food food, Water water, String source) {
        synchronized (food) {
            System.out.println(source + " " + "Got Food!");
            move();
            synchronized (water) {
                System.out.println(source + " " + "Got Water!");
            }
        }
    }

    public void drinkAndEat(Food food, Water water, String source) {
        synchronized (water) {
            System.out.println(source + " " + "Got Water!");
            move();
            synchronized (food) {

                System.out.println(source + " " + "Got Food!");
            }
        }
    }

    public void move() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
// Handle exception
        }
    }

}
