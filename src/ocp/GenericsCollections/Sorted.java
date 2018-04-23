/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocp.GenericsCollections;

/**
 *
 * @author PietroS
 */
import java.util.Comparator;
import java.util.TreeSet;

public class Sorted implements Comparable<Sorted>, Comparator<Sorted> {
//14. C. This question is hard because it defines both Comparable and Comparator on the same
//object. t1 doesn’t specify a Comparator so it uses the Comparable object’s compareTo()
//method. This sorts by the text instance variable. t2 did specify a Comparator when calling
//the constructor, so it uses the compare() method, which sorts by the int.
    private int num;
    private String text;

    Sorted(int n, String t) {
        this.num = n;
        this.text = t;
    }

    public String toString() {
        return "" + num;
    }

    @Override
    public int compareTo(Sorted s) {
        return text.compareTo(s.text);
    }

    @Override
    public int compare(Sorted s1, Sorted s2) {
        return s1.num - s2.num;
    }

    public static void main(String[] args) {
        Sorted s1 = new Sorted(88, "a");
        Sorted s2 = new Sorted(55, "b");
        TreeSet<Sorted> t1 = new TreeSet<>();
        t1.add(s1);
        t1.add(s2);
//        TreeSet<Sorted> t2 = new TreeSet<>(s1);
        TreeSet<Sorted> t2 = new TreeSet<>(s2);        
        t2.add(s1);
        t2.add(s2);
        System.out.println(t1 + " " + t2);
    }
}
