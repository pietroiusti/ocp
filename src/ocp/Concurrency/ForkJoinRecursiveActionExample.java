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
//Applying the fork/join framework requires us to perform three steps:
//1. Create a ForkJoinTask.
//2. Create the ForkJoinPool.
//3. Start the ForkJoinTask.
import java.util.*;
import java.util.concurrent.*;

public class ForkJoinRecursiveActionExample extends RecursiveAction {

    private int start;
    private int end;
    private Double[] weights;

    public ForkJoinRecursiveActionExample(Double[] weights, int start, int end) {
        this.start = start;
        this.end = end;
        this.weights = weights;
    }

    @Override
    protected void compute() {
        if (end - start <= 3) {
            for (int i = start; i < end; i++) {
                weights[i] = (double) new Random().nextInt(100);
                System.out.println("Animal Weighed: " + i);
            }
        } else {
            int middle = start + ((end - start) / 2);
            System.out.println("[start=" + start + ",middle=" + middle + ",end=" + end + "]");
            invokeAll(new ForkJoinRecursiveActionExample(weights, start, middle),
                    new ForkJoinRecursiveActionExample(weights, middle, end));
        }
    }

    public static void main(String[] args) {
        Double[] weights = new Double[10];
        ForkJoinTask<?> task = new ForkJoinRecursiveActionExample(weights, 0, weights.length);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(task);
// Print results
        System.out.println();
        System.out.print("Weights: ");
        Arrays.asList(weights).stream().forEach(
                d -> System.out.print(d.intValue() + " "));
    }
}
