/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocp.io;

/**
 *
 * @author PietroS
 */
import java.io.Serializable;

public class AnimalSerializable implements Serializable {

    private static final long serialVersionUID = 1L;
//    private String name;
//    private int age;
//    private char type;

    //object creation
    //For the exam, make sure that you understand that the constructor and any default
    //initializations are ignored during the deserialization process.
    private transient String name;
    private transient int age = 10;
    private static char type = 'C';

    {
        this.age = 14;
    }

    public AnimalSerializable() {
        this.name = "Unknown";
        this.age = 12;
        this.type = 'Q';
    }

    public AnimalSerializable(String name, int age, char type) {
        this.name = name;
        this.age = age;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public char getType() {
        return type;
    }

    public String toString() {
        return "Animal [name=" + name + ", age=" + age + ", type=" + type + "]";
    }
}
