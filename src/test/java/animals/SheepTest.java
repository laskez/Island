package animals;

import island.Cell;
import island.Island;
import plant.Plant;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;


class SheepTest {

    @Test
    @DisplayName("Овца перемещается")
    void sheepMoves() {
        Island island = new Island(3,3);
        Cell start = island.getCell(1,1);

        Sheep sheep = new Sheep(start);
        start.getAnimals().add(sheep);

        sheep.liveStep(island);

        assertNotNull(sheep.getCell());
    }

    @Test
    @DisplayName("Овца ест растения")
    void sheepEatsPlants() {
        Island island = new Island(3,3);
        Cell cell = island.getCell(1,1);

        Sheep sheep = new Sheep(cell);
        cell.getAnimals().add(sheep);

        cell.getPlants().add(new Plant());

        sheep.satiety = 0;
        sheep.eat();

        assertTrue(sheep.satiety > 0);
    }
}
