/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocp.DesignPatterns;

/**
 *
 * @author PietroS
 */
//Applying an Immutable Strategy
//Although there are a variety of techniques for writing an immutable class, you should be
//familiar with a common strategy for making a class immutable for the exam:
//1. Use a constructor to set all properties of the object.
//2. Mark all of the instance variables private and final .
//3. Don’t define any setter methods.
//4. Don’t allow referenced mutable objects to be modified or accessed directly.
//5. Prevent methods from being overridden.
import java.util.*;

public final class ImmutableExample {

    private final List<String> favoriteFoods;

    public ImmutableExample(List<String> favoriteFoods) {
        if (favoriteFoods == null) {
            throw new RuntimeException("favoriteFoods is required");
        }
        this.favoriteFoods = new ArrayList<String>(favoriteFoods);
    }

    public List<String> getFavoriteFoods() { // MAKES CLASS MUTABLE!
        return favoriteFoods;
    }
}

final class AnimalImmutable {

    private final String species;
    private final int age;
    private final List<String> favoriteFoods;

    public AnimalImmutable(String species, int age, List<String> favoriteFoods) {
        this.species = species;
        this.age = age;
        if (favoriteFoods == null) {
            throw new RuntimeException("favoriteFoods is required");
        }
        this.favoriteFoods = new ArrayList<String>(favoriteFoods);
    }

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    public int getFavoriteFoodsCount() {
        return favoriteFoods.size();
    }

    public String getFavoriteFood(int index) {
        return favoriteFoods.get(index);
    }
}
