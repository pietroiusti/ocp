/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocp.GenericsCollections;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author PietroS
 */
public class MapExample {

    public static void main(String... args) {
        Map<String, String> map = new HashMap<>();
        map.put("koala", "bamboo");
        map.put("lion", "meat");
        map.put("giraffe", "leaf");
        String food = map.get("koala"); // bamboo
        for (String key : map.keySet()) {
            System.out.print(key + ","); // koala,giraffe,lion,
        }

        Map<String, String> map2 = new TreeMap<>();
        map2.put("koala", "bamboo");
        map2.put("lion", "meat");
        map2.put("giraffe", "leaf");
        String foods = map2.get("koala"); // bamboo
        for (String key : map2.keySet()) {
            System.out.print(key + ","); // giraffe,koala,lion,
        }
//System.out.println(map.contains("lion")); // DOES NOT COMPILE
        System.out.println(map.containsKey("lion")); // true
        System.out.println(map.containsValue("lion")); // false
        System.out.println(map.size()); // 3
//The first line is a little tricky. contains() is a method on the Collection interface but
//not the Map interface. The next two lines show that keys and values are checked separately.
//Finally, we see that there are three key/value pairs in our map.

    }
}
