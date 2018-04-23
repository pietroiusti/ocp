/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocp.FunctionalProgramming;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
//import static java.util.stream.Collectors.*;
import java.util.stream.Stream;

/**
 *
 * @author PietroS
 */
public class AdvancedStreaming {

    public static void main(String[] args) {

//Collecting Using Basic Collectors        
        Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
        String result = ohMy.collect(Collectors.joining(", "));
        System.out.println(result); // lions, tigers, bears   

        Stream<String> ohMy2 = Stream.of("lions", "tigers", "bears");
        TreeSet<String> result2 = ohMy2.filter(s -> s.startsWith("t")).collect(Collectors.toCollection(TreeSet::new));
        System.out.println(result); // [tigers]        

//Collecting into Maps
        ohMy = Stream.of("lions", "tigers", "bears");
        TreeMap<Integer, String> map = ohMy.collect(Collectors.toMap(String::length, k -> k, (s1, s2) -> s1 + "," + s2, TreeMap::new));
        System.out.println(map); // // {5=lions,bears, 6=tigers}
        System.out.println(map.getClass()); // class. java.util.TreeMap

//Collecting Using Grouping, Partitioning, and Mapping      
        ohMy = Stream.of("lions", "tigers", "bears");
        Map<Integer, List<String>> map2 = ohMy.collect(Collectors.groupingBy(String::length));
        System.out.println(map2); // {5=[lions, bears], 6=[tigers]}

//Partitioning by
        Stream<String> ohMyp1 = Stream.of("lions", "tigers", "bears");
        Map<Boolean, List<String>> mapp1 = ohMyp1.collect(Collectors.partitioningBy(s -> s.length() <= 7));
        System.out.println(mapp1); // {false=[], true=[lions, tigers, bears]}

// mapping() collector  
//    
        Stream<String> ohMyc1 = Stream.of("lions", "tigers", "bears");
        Map<Integer, Optional<Character>> mapc1 = ohMyc1.collect(Collectors.groupingBy(String::length, Collectors.mapping(s -> s.charAt(0), Collectors.<Character>minBy(Comparator.<Character>naturalOrder()))));
        System.out.println(mapc1);

// {5=Optional[b], 6=Optional[t]}
    }

    private static void threeDigit(Optional<Integer> optional) {
        optional.map(n -> "" + n) // part 1
                .filter(s -> s.length() == 3) // part 2
                .ifPresent(System.out::println); // part 3
    }

    private static List<String> createSafe() {
        try {
            return ExceptionCaseStudy.create();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

class ExceptionCaseStudy {

    protected static List<String> create() throws IOException {
        throw new IOException();
    }
}
