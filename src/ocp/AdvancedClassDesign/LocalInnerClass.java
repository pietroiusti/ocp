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
public class LocalInnerClass {

    private int length = 5;

    public void calculate() {
        final int width = 20;
        class Inner {

            public void multiply() {
                System.out.println(length * width);
            }
        }
        Inner inner = new Inner();
        inner.multiply();
    }

    public static void main(String[] args) {
        LocalInnerClass outer = new LocalInnerClass();
        outer.calculate();
    }

}
