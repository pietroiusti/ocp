/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocp.GenericsCollections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 *
 * @author PietroS
 */
public class NewJava8ApiExamples {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Magician");
        list.add("Assistant");
        System.out.println(list); // [Magician, Assistant]
        list.removeIf(s -> s.startsWith("A"));
        System.out.println(list); // [Magician]        

        List<Integer> list2 = Arrays.asList(1, 2, 3);
        list2.replaceAll(x -> x * 2);
        System.out.println(list2); // [2, 4, 6]     

        list.forEach(System.out::println);

//Merge
        System.out.println("----------------MERGE---------------------");
        BiFunction<String, String, String> mapper = (v1, v2)
                -> v1.length() > v2.length() ? v1 : v2;
//BiFunction<String, String, String> mapper = (v1, v2) -> null;

        Map<String, String> favorites = new HashMap<>();
        favorites.put("Jenny", "Bus Tour");
        favorites.put("Tom", "Tram");
        favorites.put("Sam", null);

        String jenny = favorites.merge("Jenny", "Skyride", mapper);
        String tom = favorites.merge("Tom", "Skyride", mapper);
        favorites.merge("Sam", "Skyride", mapper);

        System.out.println(favorites); // {Tom=Skyride, Jenny=Bus Tour}
        System.out.println(jenny); // Bus Tour
        System.out.println(tom); // Skyride

        System.out.println("----------------computeIfPresent---------------------");
        Map<String, Integer> counts = new HashMap<>();
        counts.put("Jenny", 1);
        BiFunction<String, Integer, Integer> mapperC = (k, v) -> v + 1;
        Integer jennyC = counts.computeIfPresent("Jenny", mapperC);
        Integer samC = counts.computeIfPresent("Sam", mapperC);
        System.out.println(counts); // {Jenny=2}
        System.out.println(jennyC); // 2
        System.out.println(samC); // null

        System.out.println("----------------computeIfAbsent---------------------");
        Map<String, Integer> countsA = new HashMap<>();
        countsA.put("Jenny", 15);
        countsA.put("Tom", null);
        Function<String, Integer> mapperA = (k) -> 1;
        Integer jennyA = countsA.computeIfAbsent("Jenny", mapperA); // 15
        Integer samA = countsA.computeIfAbsent("Sam", mapperA); // 1
        Integer tomA = countsA.computeIfAbsent("Tom", mapperA); // 1
        System.out.println(countsA); // {Tom=1, Jenny=15, Sam=1}        

    }
}
