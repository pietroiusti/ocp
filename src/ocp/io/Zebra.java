/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocp.io;

import java.io.Serializable;

/**
 *
 * @author PietroS
 */
public class Zebra implements Serializable {
//21. Assuming the following class has proper public getter/setter methods for all of its private
//fields, which of the following fields will always be null after an instance of the class is
//serialized and then deserialized? (Choose all that apply.)
    private static final long serialUID = 1L;
    private transient String name = "George";
    private static String birthPlace = "Africa";
    private transient Integer age;
    private java.util.List<Zebra> friends = new java.util.ArrayList<>();
    private Object tail = null;

    {
        age = 10;
    }

    public Zebra() {
        this.name = "Sophia";
    }
}
