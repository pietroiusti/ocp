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
import java.io.*;
import java.util.*;

public class AnimalSerializableExec {

    public static List<AnimalSerializable> getAnimals(File dataFile) throws IOException,
            ClassNotFoundException {
        List<AnimalSerializable> animals = new ArrayList<AnimalSerializable>();
        try (ObjectInputStream in = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream(dataFile)))) {
            while (true) {
                Object object = in.readObject();
                if (object instanceof AnimalSerializable) {
                    animals.add((AnimalSerializable) object);
                }

            }

        } catch (EOFException e) {
// File end reached
        }
        return animals;
    }

    public static void createAnimalsFile(List<AnimalSerializable> animals, File dataFile)
            throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream(dataFile)))) {
            for (AnimalSerializable animal : animals) {
                out.writeObject(animal);
            }
        }
    }

    public static void main(String[] args) throws IOException,
            ClassNotFoundException {
        List<AnimalSerializable> animals = new ArrayList<AnimalSerializable>();
        animals.add(new AnimalSerializable("Tommy Tiger", 5, 'T'));
        animals.add(new AnimalSerializable("Peter Penguin", 8, 'P'));
        File dataFile = new File("animal.data");
        createAnimalsFile(animals, dataFile);
        System.out.println(getAnimals(dataFile));
    }
}
