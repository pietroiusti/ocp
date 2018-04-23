/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocp.GenericsCollections;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author PietroS
 */
class Squirrel {

    private int weight;
    private String species;

    public Squirrel(String theSpecies) {
        if (theSpecies == null) {
            throw new IllegalArgumentException();
        }
        species = theSpecies;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getSpecies() {
        return species;
    }
}

class ChainingComparator implements Comparator<Squirrel> {

    public int compare(Squirrel s1, Squirrel s2) {
        Comparator<Squirrel> c = Comparator.comparing(s -> s.getSpecies());
        c = c.thenComparingInt(s -> s.getWeight());      
        return c.compare(s1, s2);
    }
}

public class ComparableComparator {

    public static void main(String[] args) {
        Set<ComparableStudent> studentList = new TreeSet<>();

        studentList.add(new ComparableStudent("Thomas Jefferson", 1111, 3.8));
        studentList.add(new ComparableStudent("John Adams", 2222, 3.9));
        studentList.add(new ComparableStudent("George Washington", 3333, 3.4));

        for (ComparableStudent student : studentList) {
            System.out.println(student);
        }
    }
}

class ComparableStudent implements Comparable<ComparableStudent> {

    private String name;
    private long id = 0;
    private double gpa = 0.0;

    public ComparableStudent(String name, long id, double gpa) {
        // Additional code here
    }

    public String getName() {
        return this.name;
    }
    // Additional code here

    public int compareTo(ComparableStudent s) {
        int result = this.name.compareTo(s.getName());
        if (result > 0) {
            return 1;
        } else if (result < 0) {
            return -1;
        } else {
            return 0;
        }
    }
}

//class Student{}
//class StudentSortName implements Comparator<Student>{
//    public int compare(Student s1, Student s2){
//        int result = s1.getName().compareTo(s2.getName());
//        if (result != 0) { return result; }
//        else { 
//            return 0;  // Or do more comparing
//        } 
//    }
//}
//
//class StudentSortGpa implements Comparator<Student>{
//    public int compare(Student s1, Student s2){
//        if (s1.getGpa() < s2.getGpa()) { return 1; }
//        else if (s1.getGpa() > s2.getGpa()) { return -1; }
//        else { return 0; } 
//    }
//}
//public class TestComparator {
//    public static void main(String[] args){
//        List<Student> studentList = new ArrayList<>(3);
//        Comparator<Student> sortName = new StudentSortName();
//        Comparator<Student> sortGpa = new StudentSortGpa();
// 
//        // Initialize list here        
//        
//        Collections.sort(studentList, sortName);       
//        for(Student student:studentList){
//            System.out.println(student);
//        }
//        
//        Collections.sort(studentList, sortGpa);       
//        for(Student student:studentList){
//            System.out.println(student);
//        }
//    }
// }
//
//The example in the slide shows how the two Comparator objects are used with a collection. 
//Note: Some code has been commented out to save space. 
//Notice how the Comparator objects are initialized on lines 4 and 5. After the sortName and sortGpa variables are created, they can be passed to the sort() method by name. Running the program produces the following output.
//Name: George Washington  ID: 3333  GPA:3.4
//Name: John Adams  ID: 2222  GPA:3.9
//Name: Thomas Jefferson  ID: 1111  GPA:3.8
//Name: John Adams  ID: 2222  GPA:3.9
//Name: Thomas Jefferson  ID: 1111  GPA:3.8
//Name: George Washington  ID: 3333  GPA:3.4
//Notes:
//The Collections utility class provides a number of useful methods for various collections. Methods include min(), max(), copy(), and sort(). 
//The Student class has overridden the toString() method.

