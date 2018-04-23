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

public class Review21CountZooAnimals {

    public static Integer performCount(int exhibitNumber) {
// IMPLEMENTATION OMITTED
        return null;
    }

    public static void printResults(Future<?> f) {
        try {
            System.out.println(f.get()); // o1
        } catch (Exception e) {
            System.out.println("Exception!");
        }
    }

    public static void main(String[] args) throws InterruptedException,
            ExecutionException {
        ExecutorService service = Executors.newSingleThreadExecutor();
        final List<Future<?>> results = new ArrayList<>();
        IntStream.range(0, 10)
                .forEach(i -> results.add(
                service.submit(() -> performCount(i)))); // o2
        results.stream().forEach(f -> printResults(f));
        service.shutdown();
    }
}
