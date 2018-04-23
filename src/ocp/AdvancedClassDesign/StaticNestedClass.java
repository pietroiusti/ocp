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
public class StaticNestedClass {

    private static class Nested {
        private static int price = 6;
    }
     private static class Nested2 {
        private  int price = 6;
    }   
    public int getPrice () {
    
        return Nested.price;
    }

    public static void main(String[] args) {
        Nested2 nested = new Nested2();
        System.out.println(nested.price);
        System.out.println(Nested.price);
    }
}
