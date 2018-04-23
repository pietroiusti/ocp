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

public class Review12CountNumbers extends RecursiveAction {

    private int start;
    private int end;

    public Review12CountNumbers(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        if (start < 0) {
//        if (start < 2) {
            return;
        } else {
            int middle = start + ((end - start) / 2);
            invokeAll(new Review12CountNumbers(start, middle), new Review12CountNumbers(middle, end)); // m1
        }
    }

    public static void main(String[] args) {
        ForkJoinTask<?> task = new Review12CountNumbers(0, 4); // m2
        ForkJoinPool pool = new ForkJoinPool();
        Object result = pool.invoke(task); // m3
    }
}
