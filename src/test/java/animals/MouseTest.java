package animals;

import island.Cell;
import island.Island;
import plant.Plant;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;


class MouseTest {

    @Test
    @DisplayName("Мышь перемещается")
    void mouseMoves() {
        Island island = new Island(3,3);
        Cell start = island.getCell(1,1);

        Mouse mouse = new Mouse(start);
        start.getAnimals().add(mouse);

        mouse.liveStep(island);

        assertNotNull(mouse.getCell());
    }

    @Test
    @DisplayName("Мышь ест растения")
    void mouseEatsPlants() {
        Island island = new Island(3,3);
        Cell cell = island.getCell(1,1);

        Mouse mouse = new Mouse(cell);
        cell.getAnimals().add(mouse);

        cell.getPlants().add(new Plant());

        mouse.satiety = 0;
        mouse.eat();

        assertTrue(mouse.satiety > 0);
    }
}
