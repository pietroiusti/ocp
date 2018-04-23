/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocp.GenericsCollections;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeSet;

/**
 *
 * @author PietroS
 */
public class ReviewQuestionsGenerics {

    public static void main(String[] args) {

//8. What is the result of the following code?      
//E lower(E e) Returns greatest element that is < e, or null if no such element
//E floor(E e) Returns greatest element that is <= e, or null if no such element
//E ceiling(E e) Returns smallest element that is >= e, or null if no such element
//E higher(E e) Returns smallest element that is > e, or null if no such element
        TreeSet<String> tree = new TreeSet<String>();
        tree.add("one");
        tree.add("One");
        tree.add("ONE");
        System.out.println(tree);
        System.out.println(tree.ceiling("On"));
        System.out.println(tree.higher("On"));
        System.out.println(tree.lower("On"));
        System.out.println(tree.floor("On"));
        TreeSet<Integer> tree2 = new TreeSet<Integer>();
        tree2.add(1);
        tree2.add(2);
        tree2.add(3);
        tree2.add(6);
        System.out.println(tree2);
        System.out.println(tree2.ceiling(5));
        System.out.println(tree2.higher(6));
        System.out.println(tree2.lower(1));
        System.out.println(tree2.floor(1));

//9. Which of the answer choices are valid given the following declaration?
        Map<String, Double> map = new HashMap<>();
        map.put("pi", 3.14159);

//10. What is the result of the following program? SEE SEPERATE CLASS
//11. What is the result of the following code?
        Map<Integer, Integer> map2 = new HashMap<>(10);
        System.out.println(map2);
        for (int i = 1; i <= 10; i++) {
            map2.put(i, i * i);
        }
        System.out.println(map2);
        System.out.println(map2.get(4));

// 14. What is the result of the following program? SEE SORTED
//15. What is the result of the following code?
//        Comparator<Integer> c = (o1, o2) -> o1 - o2;
        Comparator<Integer> c = (o1, o2) -> o2 - o1;
        List<Integer> list = Arrays.asList(5, 4, 7, 1);
        Collections.sort(list, c);
        System.out.println(list);
        System.out.println(Collections.binarySearch(list, 1));
//19. Which options are true of the following code? (Choose all that apply.)   
        System.out.println("---------19 - LIST-------------");
        List<Integer> q = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        q.add(10);
        q.add(12);
        q.remove(1); //by index
        System.out.println(q);
        System.out.println("---------19 - QUEUE-------------");
        q2.add(10);
        q2.add(12);
        q2.remove(1); //by object
        System.out.println(q2);
//20. What is the result of the following code?  
        System.out.println("---------20 - MAP-------------");
        Map m = new HashMap();
        m.put(123, "456");
        m.put("abc", "def");
        m.put(true, "def");     
        System.out.println(m.put(true, "def"));          
//    System.out.println(m.contains("123"));
        System.out.println(m.containsKey("abc"));
        System.out.println(m.containsKey(123));    
        System.out.println(m.containsKey("true"));  
        System.out.println(m.containsKey(true));    
        System.out.println(m);     
//25. What is the result of the following?
        System.out.println("---------25-------------");
        Map<Integer, Integer> map25 = new HashMap<>();
        map25.put(1, 10);
        map25.put(2, 20);
        map25.put(3, null);
        map25.merge(1, 3, (a, b) -> a + b);
        map25.merge(3, 3, (a, b) -> a + b);
        System.out.println(map25);
    }

}
