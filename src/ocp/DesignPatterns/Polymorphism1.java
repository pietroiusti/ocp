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
public class Polymorphism1 {

    interface LivesInOcean {

        public void makeSound();
    }

    class Dolphin implements LivesInOcean {

        public void makeSound() {
            System.out.println("whistle");
        }
    }

    class Whale implements LivesInOcean {

        public void makeSound() {
            System.out.println("sing");
        }
    }

    class Oceanographer {

        public void checkSound(LivesInOcean animal) {
            animal.makeSound();
        }

    }

    public static void main(String[] args) {
        Polymorphism1 o = new Polymorphism1();
        Oceanographer oc = o.new Oceanographer();
        oc.checkSound(o.new Dolphin());
        oc.checkSound(o.new Whale());
    }
}
