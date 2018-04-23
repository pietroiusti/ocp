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

class CacheAny <T>{
      
    private T t;
  
    public void add(T t){
        this.t = t;
    }
  
    public T get(){
        return this.t;
    }  
 }


public class GenericClassesInterfaces<T, U> {

    private T contents;
    private U sizeLimit;

    public GenericClassesInterfaces(T contents, U sizeLimit) {
        this.contents = contents;
        this.sizeLimit = sizeLimit;
    }
    
    public static void main (String... args) {
        //Generics
    CacheAny<String> myGenericMessage = new CacheAny<String>(); 
    CacheAny<Integer> myGenericMessage2 = new CacheAny<>(); 
 
    myGenericMessage.add("Save this for me"); // Type
    myGenericMessage2.add(2); // Generic       

    }

}

//Generic Interfaces

interface Shippable<T> {

    void ship(T t);
}

class ShippableRobotCrate implements Shippable<Robot> {

    public void ship(Robot t) {
    }
}

class ShippableAbstractCrate<U> implements Shippable<U> {

    public void ship(U t) {
    }
}

class ShippableCrate implements Shippable {

    public void ship(Object t) {
    }
}

class Robot {
}

