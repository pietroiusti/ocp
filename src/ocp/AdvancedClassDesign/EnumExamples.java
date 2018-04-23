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
public class EnumExamples {

    public enum Season {
        WINTER {
            public void printHours() {
                System.out.println("9am-3pm");
            }
        }, SPRING {
            public void printHours() {
                System.out.println("9am-5pm");
            }
        }, SUMMER {
            public void printHours() {
                System.out.println("9am-7pm");
            }
        }, FALL {
            public void printHours() {
                System.out.println("9am-5pm");
            }
        }; //semicolon required if anything other than values

        public abstract void printHours(); // must be implemented by every enum.... or  concrete default implementation that can be overriden by every enum
    }

    public enum OnlyOne { // constructor only called once
        ONCE(true);

        private OnlyOne(boolean b) {
            System.out.println("constructing");
        }
    }

    public static void main(String... args) {
        OnlyOne firstCall = OnlyOne.ONCE; // prints constructing
        OnlyOne secondCall = OnlyOne.ONCE; // doesn't print anything

        Season summer = Season.SUMMER;

        switch (summer) {
//            case Season.SPRING: //
//                System.out.println("SPRING");
//                break;
            case WINTER:
                System.out.println("Get out the sled!");
                break;
            case SUMMER:
                System.out.println("Time for the pool!");
                break;
            default:
                System.out.println("Is it summer yet?");
//            case 0: // DOES NOT COMPILE
//                System.out.println("Get out the sled!");
//                break;
        }

        Season s1 = Season.valueOf("SUMMER"); // SUMMER
//        Season s2 = Season.valueOf("summer"); // exception Exception in thread "main" java.lang.IllegalArgumentException: No enum constant ocp.AdvancedClassDesign.EnumExamples.Season.summer

    }

}
