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
import java.util.*;

public class ReviewQuestionsGenerics10 implements Comparator<String> {

    @Override
    public int compare(String a, String b) {
//        return b.toLowerCase().compareTo(a.toLowerCase());
        return a.toLowerCase().compareTo(b.toLowerCase());        
    }

    public static void main(String[] args) {
        String[] values = {"123", "Abb", "aab"};
        Arrays.sort(values, new ReviewQuestionsGenerics10());
        for (String s : values) {
            System.out.print(s + " ");
        }
    }
}
