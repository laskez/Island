package island;

import animals.Animal;
import plant.Plant;

import java.util.ArrayList;
import java.util.List;

public class Cell {
    private final int x;
    private final int y;

    private final List<Animal> animals = new ArrayList<>();
    private final List<Plant> plants = new ArrayList<>();

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }

    public List<Animal> getAnimals() {
        return animals;
    }

    public List<Plant> getPlants() {
        return plants;
    }
}
