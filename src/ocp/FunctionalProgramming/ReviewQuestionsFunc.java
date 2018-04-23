/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocp.FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author PietroS
 */
public class ReviewQuestionsFunc {

    public static void main(String[] args) {

//    1. What is the output of the following?
        Stream<String> stream = Stream.iterate("", (s) -> s + "1");
        System.out.println(stream.limit(2).map(x -> x + "2"));

//2. What is the output of the following?
        Predicate<? super String> predicate = s -> s.startsWith("g");
        Stream<String> stream1 = Stream.generate(() -> "growl! ");
        Stream<String> stream2 = Stream.generate(() -> "growl! ");
        boolean b1 = stream1.anyMatch(predicate);
        boolean b2 = stream2.limit(2).allMatch(predicate);
        System.out.println(b1 + " " + b2);
//11. What changes need to be made for this code to print the string 12345? (Choose all that
//apply.) Stream.iterate(1, x -> x++).limit(5).map(x -> x).collect(Collectors.joining());
        System.out.println(Stream.iterate(1, x -> ++x).limit(5).map(x -> "" + x).collect(Collectors.joining()));
//A. Change Collectors.joining() to Collectors.joining("").
//B. Change map(x -> x) to map(x -> "" + x) .
//C. Change x -> x++ to x -> ++x.
//D. Add forEach(System.out::print) after the call to collect().
//E. Wrap the entire line in a System.out.print statement.
//F. None of the above. The code already prints 12345.

//13. Which of the following is true?
        List<Integer> l1 = Arrays.asList(1, 2, 3);
        List<Integer> l2 = Arrays.asList(4, 5, 6);
        List<Integer> l3 = Arrays.asList();
//Stream.of(l1, l2, l3).map(x -> x + 1).flatMap(x -> x.stream()).forEach(System.out::print);        
//        Stream.of(l1, l2, l3).flatMap(x -> ++x).flatmap(x -> x.stream()).forEach(System.out::print);

//14
//Stream<Integer> s = Stream.of(1);
//IntStream is = s.mapToInt(x -> x);
//DoubleStream ds = s.mapToDouble(x -> x);
//Stream<Integer> s1 = ds.mapToObj(x -> (int)x);
//IntStream s2 = ds.mapToInt(x -> (int)x);
//s2.forEach(System.out::print);

//16. What is the output of the following?
        Stream<String> s = Stream.empty();
        Stream<String> s2 = Stream.empty();
        Map<Boolean, List<String>> p = s.collect(
                Collectors.partitioningBy(b -> b.startsWith("c")));
        Map<Boolean, List<String>> g = s2.collect(
                Collectors.groupingBy(b -> b.startsWith("c")));
        System.out.println(p + " " + g);

//20. What is the simplest way of rewriting this code?
        List<Integer> l = IntStream.range(1, 6).mapToObj(i -> i).collect(Collectors.toList());
        l.forEach(System.out::println);
        IntStream.rangeClosed(1, 6).forEach(System.out::println);
    }
}
