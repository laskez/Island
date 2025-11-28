package island;

import animals.Animal;
import plant.Plant;

import java.util.concurrent.ThreadLocalRandom;

public class Simulation {

    private final Island island;

    public Simulation(Island island) {
        this.island = island;
    }

    public void step() {
        growPlants();
        lifeCycle();
    }

    // рост растений
    private void growPlants() {
        int maxPlantsPerCell = 200;

        for (Cell[] row : island.getGrid()) {
            for (Cell cell : row) {
                int current = cell.getPlants().size();
                if (current >= maxPlantsPerCell) continue;

                int toAdd = ThreadLocalRandom.current().nextInt(0, 3); // максимум 2 растения за ход

                for (int i = 0; i < toAdd; i++) {
                    cell.getPlants().add(new Plant());
                }
            }
        }
    }

    // движение, поедание, размножение
    private void lifeCycle() {
        for (Cell[] row : island.getGrid()) {
            for (Cell cell : row) {
                var snapshot = new java.util.ArrayList<>(cell.getAnimals());
                for (Animal animal : snapshot) {
                    if (animal.isAlive()) {
                        animal.liveStep(island);
                    }
                }
                cell.getAnimals().removeIf(a -> !a.isAlive());
            }
        }
    }
}
