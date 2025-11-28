package animals;

import island.Cell;
import island.Island;
import plant.Plant;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Duck extends Herbivore {

    public Duck(Cell cell) {
        super(AnimalType.DUCK, cell);
    }

    @Override
    protected void move(Island island) {
        Cell target = getRandomTargetCell(island);
        moveTo(target);
    }

    @Override
    protected void eat() {
        List<Plant> plants = new ArrayList<>(cell.getPlants());
        for (Plant plant : plants) {
            if (!isAlive() || satiety >= type.getFoodNeed()) break;
            satiety += plant.getWeight();
            cell.getPlants().remove(plant);
        }

        if (satiety < type.getFoodNeed()) {
            List<Animal> others = new ArrayList<>(cell.getAnimals());
            for (Animal other : others) {
                if (!other.isAlive() || other == this) continue;
                if (other.type != AnimalType.CATERPILLAR) continue;
                if (satiety >= type.getFoodNeed()) break;

                satiety += other.type.getWeight();
                other.die();
                cell.getAnimals().remove(other);
            }
        }
    }

    @Override
    protected void reproduce() {
        long same = cell.getAnimals().stream()
                .filter(a -> a.isAlive() && a.type == this.type)
                .count();

        if (same >= 2 && same < type.getMaxPerCell()) {
            if (ThreadLocalRandom.current().nextInt(100) < 25) {
                cell.getAnimals().add(new Duck(cell));
            }
        }
    }
}
