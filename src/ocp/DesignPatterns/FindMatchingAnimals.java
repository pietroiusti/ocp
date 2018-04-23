/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocp.DesignPatterns;

/**
 *
 * @author PietroS
 */
import java.util.function.Predicate;

public class FindMatchingAnimals {

    private static void print(Animal animal, Predicate<Animal> trait) { // instead of using interface CheckTrait 
        if (trait.test(animal)) {
            System.out.println(animal);
        }
    }

    public static void main(String[] args) {
        print(new Animal("fish", false, true), a -> a.canHop());
        print(new Animal("kangaroo", true, false), a -> a.canHop());
    }
}

//public class FindMatchingAnimals {
//
//    private static void print(Animal animal, CheckTrait trait) {
//        if (trait.test(animal)) {
//            System.out.println(animal);
//        }
//    }
//
//    public static void main(String[] args) {
////        Animal(String speciesName, boolean hopper, boolean swimmer)
//        print(new Animal("fish", false, true), a -> a.canHop());
//        print(new Animal("kangaroo", true, false), a -> a.canHop());
//        print(new Animal("fish", false, true), a -> a.canSwim());
//        print(new Animal("kangaroo", true, false), a -> a.canSwim());
//    }
//}
