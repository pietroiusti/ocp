/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocp.FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author PietroS
 */
public class Streams {

    public static void main(String[] args) {

        Stream<String> empty = Stream.empty(); // count = 0
        Stream<Integer> singleElement = Stream.of(1); // count = 1
        Stream<Integer> fromArray = Stream.of(1, 2, 3); // count = 3
        System.out.println(fromArray.count());

        List<String> list = Arrays.asList("a", "b", "c");
        Stream<String> fromList = list.stream();
        Stream<String> fromListParallel = list.parallelStream();
    }
}
