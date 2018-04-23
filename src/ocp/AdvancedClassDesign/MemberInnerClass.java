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
public class MemberInnerClass {

    private String greeting = "Hi";

    protected class InnerClass {

        public int repeat = 3;

        public void go() {
            for (int i = 0; i < repeat; i++) {
                System.out.println(greeting);
            }
        }
    }

    public void callInner() {
        InnerClass inner = new InnerClass();
        inner.go();
    }

    public static void main(String[] args) {
        MemberInnerClass outer = new MemberInnerClass();
        outer.callInner();
        InnerClass inner = outer.new InnerClass();
        inner.go();
    }
}
