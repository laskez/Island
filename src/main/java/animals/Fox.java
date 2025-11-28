package animals;

import island.Cell;
import island.Island;

import java.util.concurrent.ThreadLocalRandom;

public class Fox extends Predator {

    public Fox(Cell cell) {
        super(AnimalType.FOX, cell);
    }

    @Override
    protected void move(Island island) {
        Cell target = getRandomTargetCell(island);
        moveTo(target);
    }

    @Override
    protected void reproduce() {
        long same = cell.getAnimals().stream()
                .filter(a -> a.isAlive() && a.type == this.type)
                .count();

        if (same >= 2 && same < type.getMaxPerCell()) {
            if (ThreadLocalRandom.current().nextInt(100) < 20) {
                cell.getAnimals().add(new Fox(cell));
            }
        }
    }
}
