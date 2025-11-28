package animals;

import island.Cell;
import island.Island;

import java.util.concurrent.ThreadLocalRandom;

public class Rabbit extends Herbivore {

    public Rabbit(Cell cell) {
        super(AnimalType.RABBIT, cell);
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
            if (ThreadLocalRandom.current().nextInt(100) < 10) {
                cell.getAnimals().add(new Rabbit(cell));
            }
        }
    }
}
