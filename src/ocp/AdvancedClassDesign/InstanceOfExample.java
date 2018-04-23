/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocp.AdvancedClassDesign;

import java.util.ArrayList;

/**
 *
 * @author PietroS
 */
public class InstanceOfExample {
    public static void main (String... strargs) {
    Elephant e = new Elephant();
    HeavyAnimal a = new HeavyAnimal();    
    System.out.println(e instanceof Elephant);
    System.out.println(e instanceof ElephantCub);
    System.out.println(e instanceof HeavyAnimal);
    System.out.println(a instanceof HeavyAnimal);
    System.out.println(a instanceof Hippo); 
    System.out.println(a instanceof Elephant);   
    e = null;
    System.out.println(e instanceof Elephant); 
    ArrayList<Elephant> l = new ArrayList<>();
    Runnable r = new Thread();
//    System.out.println(l instanceof Elephant); //does not compile
    System.out.println(r instanceof Elephant); 

    }
}

class HeavyAnimal { }
class Hippo extends HeavyAnimal { }
class Elephant extends HeavyAnimal { }
class ElephantCub extends Elephant { }