/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocp.GenericsCollections;

import java.util.*;

public class SearchingSorting {

    static class Rabbit {

        int id;
    }

    public static void main(String[] args) {
        List<Rabbit> rabbits = new ArrayList<>();
        rabbits.add(new Rabbit());
        Comparator<Rabbit> c = (r1, r2) -> r1.id - r2.id;
//        Collections.sort(rabbits); // DOES NOT COMPILE
        Collections.sort(rabbits, c);
    }
}
