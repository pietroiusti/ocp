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
import java.util.stream.*;

public class Review16PrintConstants {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService service = Executors.newScheduledThreadPool(10);
        DoubleStream.of(3.14159, 2.71828) // b1
                .forEach(c -> service.submit( // b2
                () -> System.out.println(10 * c))); // b3
        service.submit(() -> System.out.println("Printed")); // b4
        Future<?> fut = service.submit(() -> System.out.println("Printed")); // b4
        System.out.println(fut.get());
//        service.awaitTermination(1, TimeUnit.HOURS);
    }
}
