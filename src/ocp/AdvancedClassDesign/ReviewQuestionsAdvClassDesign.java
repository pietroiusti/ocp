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
public class ReviewQuestionsAdvClassDesign {

    public static void main(String[] args) {
        //What is the result of the following code? See seperate class
        //20. What is the result of the following code?
        FourLegged f = new FourLegged.BabyRhino();
        FourLegged.BabyRhino b = new FourLegged.BabyRhino();
        System.out.println(f.walk);
        System.out.println(b.walk);
    }
}
//20. What is the result of the following code?

class FourLegged {

    String walk = "walk,";

    static class BabyRhino extends FourLegged {

        String walk = "toddle,";
    }
}

//21. Which of the following could be inserted to fill in the blank? (Choose all that apply.)
interface Otter {

    default void play() {
    }
}

class RiverOtter implements Otter {
//_____________________________

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return 42;
    }

    @Override
    public void play() {
    }
}
