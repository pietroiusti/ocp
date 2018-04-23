/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocp.GenericsCollections;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PietroS
 */
class A {
}

class B extends A {
}

class C extends B {
}

public class Bounds {

    public static void printList(List<Object> list) {
        for (Object x : list) {
            System.out.println(x);
        }
    }

    public static void printList2(List<?> list) {
        for (Object x : list) {
            System.out.println(x);
        }
    }

    public static void main(String[] args) {

        List<? super IOException> exceptions = new ArrayList<Exception>();
//        exceptions.add(new Exception()); // DOES NOT COMPILE
        exceptions.add(new IOException());
        exceptions.add(new FileNotFoundException());

        List<String> keywords = new ArrayList<>();
        keywords.add("java");
//        printList(keywords); // DOES NOT COMPILE
        printList2(keywords);

//        Upper-Bounded Wildcards
        List<? extends Number> list = new ArrayList<>();

        List<String> strings = new ArrayList<>();
        strings.add("tweet");
        List<Object> objects = new ArrayList<>(strings);
        addSound(strings);
        addSound(objects);

        //TESTING
        List<?> list1 = new ArrayList<A>();
        List<? extends A> list0 = new ArrayList<>();
        List<? extends A> list2 = new ArrayList<A>();
        List<? super A> list3 = new ArrayList<>();
//List<? extends B> list4 = new ArrayList<A>(); // DOES NOT COMPILE
        List<? super B> list5 = new ArrayList<A>();
// List<?> list6 = new ArrayList<? extends A>(); // DOES NOT COMPILE

    }

    public static long total(List<? extends Number> list) {
        long count = 0;
        for (Number number : list) {
            count += number.longValue();
        }
        return count;
    }

    public static void addSound(List<? super String> list) { // lower bound
        list.add("quack");
    }
//    public static void addSound(List<? extends Object> list) { // lower bound
////        list.add("quack");
//    }
}
