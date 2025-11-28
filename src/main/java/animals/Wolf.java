package animals;

import island.Cell;
import island.Island;

import java.util.concurrent.ThreadLocalRandom;

public class Wolf extends Predator {

    public Wolf(Cell cell) {
        super(AnimalType.WOLF, cell);
    }

    @Override
    protected void move(Island island) {
        Cell target = getRandomTargetCell(island);
        moveTo(target);
    }

    @Override
    protected void reproduce() {
        long same = cell.getAnimals().stream()
                .filter(a -> a.isAlive() && a.getType() == this.getType())
                .count();

        if (same >= 2 && same < type.getMaxPerCell()) {
            if (ThreadLocalRandom.current().nextInt(100) < 20) { // было 10–15
                cell.getAnimals().add(new Wolf(cell));
            }
        }
    }
}
