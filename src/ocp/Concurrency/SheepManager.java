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
import java.util.concurrent.atomic.AtomicInteger;

public class SheepManager {

    private int sheepCount = 0;
    private AtomicInteger sheepCount2 = new AtomicInteger(0);
    private void incrementAndReport() {
        synchronized (this) {
            System.out.print((++sheepCount) + " ");
            System.out.print("Atomic" + sheepCount2.incrementAndGet() + " ");
        }
    }

    private synchronized void incrementAndReport2() {
        System.out.print((++sheepCount) + " ");
    }

    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(20);
            SheepManager manager = new SheepManager();
            for (int i = 0; i < 10; i++) {
                service.submit(() -> manager.incrementAndReport());
            }
            for (int i = 0; i < 10; i++) {
                service.submit(() -> manager.incrementAndReport2());
            }           
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }
    }
}
