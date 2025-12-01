package animals;

import island.Cell;
import island.Island;
import plant.Plant;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;


class DeerTest {

    @Test
    @DisplayName("Олень перемещается по острову")
    void deerMoves() {
        Island island = new Island(3,3);
        Cell start = island.getCell(1,1);

        Deer deer = new Deer(start);
        start.getAnimals().add(deer);

        deer.liveStep(island);

        assertNotNull(deer.getCell());
    }

    @Test
    @DisplayName("Олень ест растения")
    void deerEatsPlants() {
        Island island = new Island(3,3);
        Cell cell = island.getCell(1,1);

        Deer deer = new Deer(cell);
        cell.getAnimals().add(deer);

        cell.getPlants().add(new Plant());

        deer.satiety = 0;
        deer.eat();

        assertTrue(deer.satiety > 0);
    }
}
