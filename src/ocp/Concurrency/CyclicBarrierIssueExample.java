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

public class CyclicBarrierIssueExample {

    private void removeAnimals() {
        System.out.println("Removing animals");
    }

    private void cleanPen() {
        System.out.println("Cleaning the pen");
    }

    private void addAnimals() {
        System.out.println("Adding animals");
    }

    public void performTask() {
        removeAnimals();
        cleanPen();
        addAnimals();
    }

    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(4);
            CyclicBarrierIssueExample manager = new CyclicBarrierIssueExample();
            for (int i = 0; i < 4; i++) {
                service.submit(() -> manager.performTask());
            }
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }
    }
}
