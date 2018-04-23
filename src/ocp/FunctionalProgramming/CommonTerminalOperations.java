/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocp.FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author PietroS
 */
public class CommonTerminalOperations {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c");
        Stream<String> fromList = list.stream();
        Stream<String> fromListParallel = list.parallelStream();

        Stream<Double> randoms = Stream.generate(Math::random);
        Stream<Integer> oddNumbers = Stream.iterate(1, n -> n + 2);

        System.out.println(fromList.count());

        Stream<String> s = Stream.of("monkey", "ape", "bonobo");
        Optional<String> min = s.min((s1, s2) -> s1.length() - s2.length());
        min.ifPresent(System.out::println); // ape   
        Optional<?> minEmpty = Stream.empty().min((s1, s2) -> 0);
        System.out.println(minEmpty.isPresent()); //Since the stream is empty, the comparator is never called and no value is present in the Optional.

        s = Stream.of("monkey", "ape", "bonobo");
        Stream<String> infinite = Stream.generate(() -> "chimp");
        s.findAny().ifPresent(System.out::println); // monkey
        infinite.findAny().ifPresent(System.out::println); // chimp

        List<String> list2 = Arrays.asList("monkey", "2", "chimp");
        infinite = Stream.generate(() -> "chimp");
        Predicate<String> pred = x -> Character.isLetter(x.charAt(0));
        System.out.println(list2.stream().anyMatch(pred)); // true
        System.out.println(list2.stream().allMatch(pred)); // false
        System.out.println(list2.stream().noneMatch(pred)); // false
        System.out.println(infinite.anyMatch(pred)); // true        

//        s.forEach(System.out::print);
//reduce()
//T reduce(T identity, BinaryOperator<T> accumulator)
//Optional<T> reduce(BinaryOperator<T> accumulator)
//<U> U reduce(U identity, BiFunction<U,? super T,U> accumulator,
//BinaryOperator<U> combiner)
        String[] array = new String[]{"w", "o", "l", "f"};
        String result = "";
        for (String str : array) {
            result = result + str;
        }
        System.out.println(result);

        Stream<String> stream2 = Stream.of("w", "o", "l", "f");
        String word = stream2.reduce("", (s1, c) -> s1 + c);
        System.out.println(word); // wolf

        Stream<Integer> stream3 = Stream.of(3, 5, 6);
        System.out.println(stream3.reduce(1, (a, b) -> a * b)); //90

//collect()    
//<R> R collect(Supplier<R> supplier, BiConsumer<R, ? super T> accumulator,
//BiConsumer<R, R> combiner)
//<R,A> R collect(Collector<? super T, A,R> collector)
        Stream<String> stream = Stream.of("w", "o", "l", "f");
//StringBuilder word = stream.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);

        stream = Stream.of("w", "o", "l", "f");
        TreeSet<String> set = stream.collect(TreeSet::new, TreeSet::add,
                TreeSet::addAll);
        System.out.println(set); // [f, l, o, w]

        stream = Stream.of("w", "o", "l", "f");
        TreeSet<String> set2 = stream.collect(Collectors.toCollection(TreeSet::new));
        System.out.println(set2); // [f, l, o, w]

//If we didn’t need the set to be sorted, we could make the code even shorter:
        stream = Stream.of("w", "o", "l", "f");
        Set<String> set3 = stream.collect(Collectors.toSet());
        System.out.println(set3); // [f, w, l, o]
//You might get different output for this last one since toSet() makes no guarantees as
//to which implementation of Set you’ll get. It is likely to be a HashSet , but you shouldn’t
//expect or rely on that.

    }
}
