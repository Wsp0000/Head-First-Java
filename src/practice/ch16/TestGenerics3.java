package practice.ch16;

import java.util.ArrayList;
import java.util.List;

public class TestGenerics3 {

    public static void main(String[] args) {
        new TestGenerics3().go();
    }

    public void go() {
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Dog());
        animals.add(new Cat());
        animals.add(new Dog());

        takeAnimals(animals);

        ArrayList<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog());
        dogs.add(new Dog());
//        takeAnimals(dogs);
//        ArrayList<Dog> dogs1 = new ArrayList<Animal>();
//        ArrayList<Animal> animals1 = new ArrayList<Dog>();
        List<Animal> list = new ArrayList<Animal>();
    }

    public void takeAnimals(ArrayList<Animal> animals) {
        for (Animal a :
                animals) {
            a.eat();
        }
    }
}
