/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocp;

/**
 *
 * @author PietroS
 */
public class Color {
    private int hue = 10;
    public class Shade{
        public int hue = Color.this.hue;
    }
    public static void main(String[] args) {
        // TODO code application logic here
//        Color col = new Color();
        System.out.println(new Color().new Shade().hue);
        
    }   
}
