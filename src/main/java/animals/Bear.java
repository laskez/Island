package animals;

import island.Cell;
import island.Island;

import java.util.concurrent.ThreadLocalRandom;

public class Bear extends Predator {

    public Bear(Cell cell) {
        super(AnimalType.BEAR, cell);
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
            if (ThreadLocalRandom.current().nextInt(100) < 8) {
                cell.getAnimals().add(new Bear(cell));
            }
        }
    }
}
