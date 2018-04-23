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

public class Review17SheepManager {

    private static AtomicInteger sheepCount1 = new AtomicInteger(0); // w1
    private static int sheepCount2 = 0;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor(); // w2
            for (int i = 0; i < 100; i++) {
                service.execute(()
                        -> {
                    sheepCount1.getAndIncrement();
                    sheepCount2++;
                }); // w3
            }
            Thread.sleep(100);
            System.out.println(sheepCount1 + " " + sheepCount2);
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }
    }
}
