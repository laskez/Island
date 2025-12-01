package animals;

import island.Cell;
import island.Island;
import plant.Plant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CaterpillarTest {

    @Test
    @DisplayName("Гусеница не есть, если уже сытая")
    void caterpillarDoesNotEatWhenFull() {

        Island island = new Island(3, 3);
        Cell cell = island.getCell(1, 1);

        cell.getPlants().add(new Plant());
        Caterpillar c = new Caterpillar(cell);
        cell.getAnimals().add(c);

        c.liveStep(island);

        assertEquals(1, cell.getPlants().size());
    }
}
