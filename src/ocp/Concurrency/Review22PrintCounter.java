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
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

public class Review22PrintCounter {

    static int counter = 0;

    public static void main(String[] args) throws InterruptedException,
            ExecutionException {
        ExecutorService service = Executors.newSingleThreadExecutor();
        List<Future<?>> results = new ArrayList<>();
        IntStream.iterate(0, i -> i + 1).limit(5).forEach(
                i -> results.add(service.submit(() -> counter++)) // n1
        //i -> results.add(service.execute(() -> counter++)) // n1
        );
        for (Future<?> result : results) {
            System.out.print(result.get() + " "); // n2
        }
        service.shutdown();
    }
}
