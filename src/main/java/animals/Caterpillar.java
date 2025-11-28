package animals;

import island.Cell;
import island.Island;

import java.util.concurrent.ThreadLocalRandom;

public class Caterpillar extends Herbivore {

    public Caterpillar(Cell cell) {
        super(AnimalType.CATERPILLAR, cell);
    }

    @Override
    protected void move(Island island) {
    }

    @Override
    protected void reproduce() {
        long same = cell.getAnimals().stream()
                .filter(a -> a.isAlive() && a.type == this.type)
                .count();

        if (same >= 2 && same < type.getMaxPerCell()) {
            if (ThreadLocalRandom.current().nextInt(100) < 30) {
                cell.getAnimals().add(new Caterpillar(cell));
            }
        }
    }
}
