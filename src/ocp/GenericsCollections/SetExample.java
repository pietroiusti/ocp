/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocp.GenericsCollections;

import java.util.HashSet;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author PietroS
 */
public class SetExample {

    public static void main(String[] args) {
        Set<String> set = new TreeSet<>();

        set.add("one");
        set.add("two");
        set.add("three");
        set.add("three"); // not added, only unique

        for (String item : set) {
            System.out.println("Item: " + item);
        }

        Set<Integer> setih = new HashSet<>();
        boolean b1 = setih.add(66); // true
        boolean b2 = setih.add(10); // true
        boolean b3 = setih.add(66); // false
        boolean b4 = setih.add(8); // true
        for (Integer integer : setih) {
            System.out.print(integer + ","); // 66,8,10,        
        }
        Set<Integer> setit = new TreeSet<>();

        b1 = setit.add(66); // true
        b2 = setit.add(10); // true
        b3 = setit.add(66); // false
        b4 = setit.add(8); // true
        for (Integer integer : setit) {
            System.out.print(integer + ","); // 8,10,66        
        }

        
        NavigableSet<Integer> setn = new TreeSet<>();
        for (int i = 1; i <= 20; i++) {
            setn.add(i);
        }
        System.out.println(setn.lower(10)); // 9
        System.out.println(setn.floor(10)); // 10
        System.out.println(setn.ceiling(20)); // 20
        System.out.println(setn.higher(20)); // null
        //Method Description
        //E lower(E e) Returns greatest element that is < e, or null if no such element
        //E floor(E e) Returns greatest element that is <= e, or null if no such element
        //E ceiling(E e) Returns smallest element that is >= e, or null if no such element
        //E higher(E e) Returns smallest element that is > e, or null if no such element

        
               
    }
}
