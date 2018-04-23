/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocp.Concurrency;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

/**
 *
 * @author PietroS
 */
public class ReviewQuestionsConcur {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
//Which lines need to be changed to make the code compile? (Choose all that apply.)
//ExecutorService service = Executors.newSingleThreadScheduledExecutor();
//service.scheduleWithFixedDelay(() -> { // w1
//System.out.println("Open Zoo");
//return null; // w2
//}, 0, 1, TimeUnit.MINUTES);
//Future<?> result = service.submit(() -> System.out.println("Wake Staff")); // w3
//System.out.println(result.get()); // w4   

//4. What statement about the following code is true?
        System.out.println("--------------4----------------");
        AtomicLong value1 = new AtomicLong(0);
        final long[] value2 = {0};
        IntStream.iterate(1, i -> 1).limit(100).parallel()
                .forEach(i -> value1.incrementAndGet());
        IntStream.iterate(1, i -> 1).limit(100).parallel()
                .forEach(i -> ++value2[0]);
        System.out.println(value1 + " " + value2[0]);
//7. What is the result of executing the following code snippet?
        System.out.println("--------------7----------------");
        List<Integer> l1 = Arrays.asList(1, 2, 3);
        List<Integer> l2 = new CopyOnWriteArrayList<>(l1);
        Set<Integer> s3 = new ConcurrentSkipListSet<>();
        s3.addAll(l1);
        for (Integer item : l2) {
            l2.add(4); // x1
        }
        for (Integer item : s3) {
            s3.add(5); // x2
        }
        System.out.println(l1.size() + " " + l2.size() + " " + s3.size());
//8. What statements about the following code are true? (Choose all that apply.)
        System.out.println("--------------8----------------");
        Integer i1 = Arrays.asList(1, 2, 3, 4, 5).stream().findAny().get();
        synchronized (i1) { // y1
            Integer i2 = Arrays.asList(6, 7, 8, 9, 10)
                    .parallelStream()
                    .sorted() // y2
                    .findFirst().get(); // y3
            System.out.println(i1 + " " + i2);
        }
        
        System.out.println("--------------9----------------");
        Integer[] elements = new Integer[]{8, -3, 2, -54};
        RecursiveTask task = new FindMin(elements, 0, elements.length - 1);
        ForkJoinPool pool = new ForkJoinPool(1);
        Integer sum = (Integer) pool.invoke(task);
        System.out.println("Min: " + sum);
        
        System.out.println("--------------10----------------");
//10. What statements about the following code are true? (Choose all that apply.)  
        System.out.println(Arrays.asList("duck", "chicken", "flamingo", "pelican")
                .parallelStream().parallel() // q1
                .reduce(0,
//                        (c1, c2) -> c1.length() + c2.length(), // q2
                        (c1, c2) -> c1 + c2.length(), // q2
                        (s1, s2) -> s1 + s2)); // q3    
         System.out.println("--------------11----------------");       
        Object o1 = new Object();
        Object o2 = new Object();
        ExecutorService service = Executors.newFixedThreadPool(2);
     ExecutorService service2= Executors.newSingleThreadScheduledExecutor();    

        Future<?> f1 = service.submit(() -> {
            synchronized (o1) {
                synchronized (o2) {
                    System.out.println("Tortoise");
                } // t1
            }
        });
        Future<?> f2 = service.submit(() -> {
            synchronized (o2) {
                synchronized (o1) {
                    System.out.println("Hare");
                } // t2
            }
        });
        f1.get();
        f2.get();

        
    }

}

class FindMin extends RecursiveTask<Integer> {

    private Integer[] elements;
    private int a;
    private int b;

    public FindMin(Integer[] elements, int a, int b) {
        this.elements = elements;
        this.a = a;
        this.b = b;
    }

    @Override
    public Integer compute() {
        if ((b - a) < 2) {
            return Math.min(elements[a], elements[b]);
        } else {
            int m = a + ((b - a) / 2);
            System.out.println(a + "," + m + "," + b);
            RecursiveTask t1 = new FindMin(elements, a, m);
            Integer result = (Integer) t1.fork().join();
            return Math.min(new FindMin(elements, m, b).compute(), result);
        }
    }

}
