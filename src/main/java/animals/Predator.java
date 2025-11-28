package animals;

import island.Cell;
import island.Config;
import island.Island;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Predator extends Animal {

    public Predator(AnimalType type, Cell cell) {
        super(type, cell);
    }

    @Override
    protected void move(Island island) {
        int speed = type.getSpeed();
        if (speed <= 0) return;

        Cell target = getRandomTargetCell(island);
        moveTo(target);
    }

    @Override
    protected void eat() {
        List<Animal> others = new ArrayList<>(cell.getAnimals());

        for (Animal victim : others) {
            if (!isAlive()) return;
            if (satiety >= type.getFoodNeed()) break;
            if (victim == this || !victim.isAlive()) continue;

            int chance = Config.getEatChance(this.type, victim.type);
            if (chance <= 0) continue;

            int roll = ThreadLocalRandom.current().nextInt(100);
            if (roll < chance) {
                satiety += victim.type.getWeight();
                victim.die();
                cell.getAnimals().remove(victim);
            }
        }
    }
}
