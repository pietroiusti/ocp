/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocp.GenericsCollections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author PietroS
 */
public class OldStyleArrayList {

    public static void main(String args[]) {
        List partList = new ArrayList(3);

        partList.add(new Integer(1111));
        partList.add(new Integer(2222));
        partList.add(new Integer(3333));
        partList.add("Oops a string!"); // causes runtime error: ClassCastException

        Iterator elements = partList.iterator();
        while (elements.hasNext()) {
            Integer partNumberObject = (Integer) (elements.next()); // error?
            int partNumber = partNumberObject.intValue();

            System.out.println("Part number: " + partNumber);
//      GenericArrayList: causes compiler error instead of runtime error  
            List<Integer> partListg = new ArrayList<>(3);

            partListg.add(new Integer(1111));
            partListg.add(new Integer(2222));
            partListg.add(new Integer(3333));
//    partListg.add("Bad Data");  // compiler error now 

            Iterator<Integer> elementsg = partListg.iterator();
            while (elementsg.hasNext()) {
                Integer partNumberObjectg = elementsg.next();
                int partNumberg = partNumberObjectg.intValue();

                System.out.println("Part number: " + partNumberg);
            }
            
            for (Integer partNumberObjectg : partListg) {
                int partNumberg = partNumberObjectg; // Demos auto unboxing
                System.out.println("Part number: " + partNumberg);
            }

        }
    }
}
