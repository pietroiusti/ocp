/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocp.AdvancedClassDesign;

/**
 *
 * @author PietroS
 */
abstract class Animal {

    public abstract void feed();

    public void careFor() {
        play();
    }

    public void play() {
        System.out.println("pet animal");
    }

}

class Lion extends Animal {

    public void feed() {
        addMeat();
    }

    private void addMeat() {
        System.out.println("add meat");
    }

    public void play() {
        System.out.println("toss in meat");
    }
    
  
    

}

public class VirtualMethodExample {

    public void feedAnimal(Animal animal) {
        animal.feed();
    }  

    public static void main(String... args) {
        VirtualMethodExample vme = new VirtualMethodExample();
        Animal animal = new Lion();
        animal.careFor();
        vme.feedAnimal(animal);
    }
}
