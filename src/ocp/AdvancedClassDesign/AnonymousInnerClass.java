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
public class AnonymousInnerClass {

    abstract class SaleTodayOnly {

        abstract int dollarsOff();
    }

    interface SaleTodayOnlyI {

        int dollarsOff();
    }

    public int admissioni(int basePrice) {
        SaleTodayOnly sale = new SaleTodayOnly() {// Anonymous class that implements an interface
            @Override
            public int dollarsOff() {
                return 3;
            }
        };
        return basePrice - sale.dollarsOff();
    }
    
    
    public int admission(int basePrice) {
        SaleTodayOnly sale = new SaleTodayOnly() { // Anonymous class that extends an abstract class
            @Override
            int dollarsOff() {
                return 3;
            }
        };
        return basePrice - sale.dollarsOff();
    }
    
    
    public int pay() {
        return admission(5, new SaleTodayOnlyI() {
            public int dollarsOff() {
                return 3;
            }
        });
    }

    public int admission(int basePrice, SaleTodayOnlyI sale) {
        return basePrice - sale.dollarsOff();
    }
}


