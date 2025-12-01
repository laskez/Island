package animals;

import island.Cell;
import island.Island;
import plant.Plant;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;


class BuffaloTest {

    @Test
    @DisplayName("Буйвол делает шаг")
    void buffaloMoves() {
        Island island = new Island(3,3);
        Cell start = island.getCell(1,1);

        Buffalo buffalo = new Buffalo(start);
        start.getAnimals().add(buffalo);

        buffalo.liveStep(island);

        assertNotNull(buffalo.getCell());
    }

    @Test
    @DisplayName("Буйвол питается растениями")
    void buffaloEatsPlants() {
        Island island = new Island(3,3);
        Cell cell = island.getCell(1,1);

        Buffalo buffalo = new Buffalo(cell);
        cell.getAnimals().add(buffalo);

        cell.getPlants().add(new Plant());

        buffalo.satiety = 0;
        buffalo.eat();

        assertTrue(buffalo.satiety > 0);
    }
}
