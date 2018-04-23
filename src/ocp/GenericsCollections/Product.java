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

//If you write a class that implements Comparable, you introduce new business logic for
//determining equality. The compareTo() method returns 0 if two objects are equal, while
//your equals() method returns true if two objects are equal. A natural ordering that
//uses compareTo() is said to be consistent with equals if, and only if, x.equals(y) is true
//whenever x.compareTo(y) equals 0. You are strongly encouraged to make your Comparable
//classes consistent with equals because not all collection classes behave predictably if
//the compareTo() and equals() methods are not consistent.
//For example, the following Product class defines a compareTo() method that is not consistent
//with equals:
public class Product implements Comparable<Product> {

    int id;
    String name;

    public boolean equals(Object obj) {
        if (!(obj instanceof Product)) {
            return false;
        }
        Product other = (Product) obj;
        return this.id == other.id;
    }

    public int compareTo(Product obj) {
        return this.name.compareTo(obj.name);
    }
}
