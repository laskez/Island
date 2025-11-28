package animals;

import island.Island;
import plant.Plant;

import java.util.ArrayList;
import java.util.List;

public abstract class Herbivore extends Animal {

    protected Herbivore(AnimalType type, island.Cell cell) {
        super(type, cell);
    }

    @Override
    protected void eat() {
        List<Plant> plants = new ArrayList<>(cell.getPlants());
        for (Plant plant : plants) {
            if (!isAlive() || satiety >= type.getFoodNeed()) break;

            satiety += plant.getWeight();
            cell.getPlants().remove(plant);
        }
    }
}
