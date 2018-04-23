/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocp.GenericsCollections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author PietroS
 */
public class ArrayArrayList {

    public static void main(String[] args) {

        String[] array = {"gerbil", "mouse"}; // [gerbil, mouse]
        List<String> list = Arrays.asList(array); // returns fixed size list
        list.set(1, "test"); // [gerbil, test]
        array[0] = "new"; // [new, test]
        String[] array2 = (String[]) list.toArray(); // [new, test]
//        list.remove(1); // throws UnsupportedOperationException

        //sorting and searching
        int[] numbers = {6, 9, 1, 8};
        Arrays.sort(numbers); // [1,6,8,9]
        System.out.println(Arrays.binarySearch(numbers, 6)); // 1
        System.out.println(Arrays.binarySearch(numbers, 3)); // -2

        List<Integer> ilist = Arrays.asList(9, 7, 5, 3);
        Collections.sort(ilist); // [3, 5, 7, 9]
        System.out.println(Collections.binarySearch(ilist, 3)); // 0
        System.out.println(Collections.binarySearch(ilist, 2)); // -1

        //autoboxing and unboxing
        List<Integer> inumbers = new ArrayList<Integer>();
        inumbers.add(1);
        inumbers.add(new Integer(3));
        inumbers.add(new Integer(5));
        inumbers.remove(1);
        inumbers.remove(new Integer(5));
        System.out.println(inumbers);
    }
}
