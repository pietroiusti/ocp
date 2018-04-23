/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocp.FunctionalProgramming;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 *
 * @author PietroS
 */
public class FunctionalProgramming {

    public static void main(String[] args) {

//        @FunctionalInterface
//        public class Supplier<T> {
//
//            public T get();
//        }
        Supplier<LocalDate> s1 = LocalDate::now;
        Supplier<LocalDate> s2 = () -> LocalDate.now();
        LocalDate d1 = s1.get();
        LocalDate d2 = s2.get();

        System.out.println(d1);
        System.out.println(d2);

        Supplier<StringBuilder> s3 = StringBuilder::new;
        Supplier<StringBuilder> s4 = () -> new StringBuilder();
        System.out.println(s3.get());
        System.out.println(s4.get());

//        @FunctionalInterface
//        public class Consumer<T> {
//
//            void accept(T t);
//        }
//        @FunctionalInterface
//        public class BiConsumer<T, U> {
//
//            void accept(T t, U u);
//        }
        Consumer<String> c1 = System.out::println;
        Consumer<String> c2 = x -> System.out.println(x);
        c1.accept("Annie");
        c2.accept("Annie");

        Map<String, Integer> map = new HashMap<>();
        BiConsumer<String, Integer> b1 = map::put;
        BiConsumer<String, Integer> b2 = (k, v) -> map.put(k, v);
        b1.accept("chicken", 7);
        b2.accept("chick", 1);

        System.out.println(map);

//        @FunctionalInterface
//        public class Predicate<T> {
//
//            boolean test(T t);
//        }
//        @FunctionalInterface
//        public class BiPredicate<T, U> {
//
//            boolean test(T t, U u);
//        }
        Predicate<String> p1 = String::isEmpty;
        Predicate<String> p2 = x -> x.isEmpty();
        System.out.println(p1.test(""));
        System.out.println(p2.test(""));
        BiPredicate<String, String> p3 = String::startsWith;
        BiPredicate<String, String> p4 = (string, prefix) -> string.startsWith(prefix);
        System.out.println(p3.test("chicken", "chick"));
        System.out.println(p4.test("chicken", "chick"));

        Predicate<String> egg = s -> s.contains("egg");
        Predicate<String> brown = s -> s.contains("brown");
        Predicate<String> brownEggs = egg.and(brown);
        Predicate<String> otherEggs = egg.and(brown.negate());

//        @FunctionalInterface
//        public class Function<T, R> {
//
//            R apply(T t);
//        }
//        @FunctionalInterface
//        public class BiFunction<T, U, R> {
//
//            R apply(T t, U u);
//        }
        Function<String, Integer> f1 = String::length;
        Function<String, Integer> f2 = x -> x.length();
        System.out.println(f1.apply("cluck")); // 5
        System.out.println(f2.apply("cluck")); // 5
        BiFunction<String, String, String> bf1 = String::concat;
        BiFunction<String, String, String> bf2 = (string, toAdd) -> string.concat(toAdd);
        System.out.println(bf1.apply("baby ", "chick")); // baby chick
        System.out.println(bf2.apply("baby ", "chick")); // baby chick

//        @FunctionalInterface
//        public class UnaryOperator<T>
//                extends Function<T, T> {
//        }
//        @FunctionalInterface
//        public class BinaryOperator<T>
//                extends BiFunction<T, T, T> {
//        }
        UnaryOperator<String> u1 = String::toUpperCase;
        UnaryOperator<String> u2 = x -> x.toUpperCase();
        System.out.println(u1.apply("chirp"));
        System.out.println(u2.apply("chirp"));
        BinaryOperator<String> bo1 = String::concat;
        BinaryOperator<String> bo2 = (string, toAdd) -> string.concat(toAdd);
        System.out.println(bo1.apply("baby ", "chick")); // baby chick
        System.out.println(bo2.apply("baby ", "chick")); // baby chick

//        Optional
        System.out.println(average(90, 100)); // Optional[95.0]
        System.out.println(average()); // Optional.empty
        Optional<Double> opt = average(90, 100);
        if (opt.isPresent()) {
            System.out.println(opt.get()); // 95.0       
        }
        opt.ifPresent(System.out::println);
//        Optional o = Optional.ofNullable(5);
        Optional<Double> opt2 = average();
        System.out.println(opt2.orElse(Double.NaN));
        System.out.println(opt2.orElseGet(() -> Math.random()));
//        System.out.println(opt2.orElseThrow(() -> new IllegalStateException()));
//        System.out.println(opt2.orElseGet(() -> new IllegalStateException())); // DOES NOT COMPILE

        Optional<Double> opt3 = average(90, 100);
        System.out.println(opt3.orElse(Double.NaN));
        System.out.println(opt3.orElseGet(() -> Math.random()));
        System.out.println(opt3.orElseThrow(() -> new IllegalStateException()));
//It prints out 95 three times. Since the value does exist, there is no need to use the “or
//else” logic.
    }

    public static Optional<Double> average(int... scores) {
        if (scores.length == 0) {
            return Optional.empty();
        }
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return Optional.of((double) sum / scores.length);
    }
}
