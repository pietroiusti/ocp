/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocp.Concurrency;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author PietroS
 */
public class ParallelStreamsExamples {

    public static void main(String[] args) {

//Requirements for reduce() Arguments
//■ The identity must be defined such that for all elements in the stream u ,
//combiner.apply(identity, u) is equal to u .
//■ The accumulator operator op must be associative and stateless such that (a op b) op c
//is equal to a op (b op c) .
//■ The combiner operator must also be associative and stateless and compatible with the
//identity, such that for all u and t combiner.apply(u,accumulator.apply(identity,t))
//is equal to accumulator.apply(u,t) .        
        System.out.print(Arrays.asList(1, 2, 3, 4, 5, 6).stream().findAny().get());
        System.out.print(Arrays.asList(1, 2, 3, 4, 5, 6).parallelStream().findAny().get());

        System.out.println(Arrays.asList(1, 2, 3, 4, 5, 6)
                .parallelStream()
                .reduce(0, (a, b) -> (a - b))); // NOT AN ASSOCIATIVE ACCUMULATOR

        System.out.println(Arrays.asList("w", "o", "l", "f")
                .parallelStream()
                .reduce("X", String::concat));

//Requirements for Parallel Reduction with collect()
//■■ The stream is parallel.
//■■ The parameter of the collect operation has the Collector.Characteristics.CONCURRENT
//characteristic.
//■■ Either the stream is unordered, or the collector has the characteristic
//Collector.Characteristics.UNORDERED.
        Stream<String> ohMy = Stream.of("lions", "tigers", "bears").parallel();
        ConcurrentMap<Integer, String> map = ohMy
                .collect(Collectors.toConcurrentMap(String::length, k -> k,
                        (s1, s2) -> s1 + "," + s2));
        System.out.println(map); // {5=lions,bears, 6=tigers}
        System.out.println(map.getClass()); // java.util.concurrent.ConcurrentHashMap        

        Stream<String> ohMy2 = Stream.of("lions", "tigers", "bears").parallel();
        ConcurrentMap<Integer, List<String>> map2 = ohMy2.collect(
                Collectors.groupingByConcurrent(String::length));
        System.out.println(map2); // {5=[lions, bears], 6=[tigers]}

    }
}
