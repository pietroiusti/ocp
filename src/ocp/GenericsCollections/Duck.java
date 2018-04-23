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
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//We still need to know what the compareTo() method returns so that we can write our
//own. There are three rules to know:
//¡¡ The number zero is returned when the current object is equal to the argument to compareTo().
//¡¡ A number less than zero is returned when the current object is smaller than the argument
//to compareTo().
//¡¡ A number greater than zero is returned when the current object is larger than the argument
//to compareTo().
public class Duck implements Comparable<Duck> {

    private final String name;

    private int weight;

    public Duck(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public String toString() {
        return name;
    }

    public int compareTo(Duck d) {
        return name.compareTo(d.name);
    }

    public static void main(String[] args) {
        List<Duck> ducks = new ArrayList<>();
        ducks.add(new Duck("Quack", 15));
        ducks.add(new Duck("Puddles", 10));
        Collections.sort(ducks); // sort by name
        System.out.println(ducks); // [Puddles, Quack]

        Comparator<Duck> byWeight = new Comparator<Duck>() {
            public int compare(Duck d1, Duck d2) {
                return d1.getWeight() - d2.getWeight();
            }
        };
        ducks = new ArrayList<>();
        ducks.add(new Duck("Quack", 7));
        ducks.add(new Duck("Puddles", 10));
        Collections.sort(ducks);
        System.out.println(ducks); // [Puddles, Quack]
        Collections.sort(ducks, byWeight);
        System.out.println(ducks); // [Quack, Puddles]

//Comparator is a functional interface since there is only one abstract method to implement.
//This means that we can rewrite the comparator in the previous example as any of the
//following:
        Comparator<Duck> byWeight2 = (d1, d2) -> d1.getWeight() - d2.getWeight();
        Comparator<Duck> byWeight3 = (Duck d1, Duck d2) -> d1.getWeight() - d2.getWeight();
        Comparator<Duck> byWeight4 = (d1, d2) -> {
            return d1.getWeight() - d2.getWeight();
        };
        Comparator<Duck> byWeight5 = (Duck d1, Duck d2) -> {
            return d1.getWeight()
                    - d2.getWeight();
        };

    }

}
