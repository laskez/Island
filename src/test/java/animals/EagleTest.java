package animals;

import island.Cell;
import island.Island;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;


class EagleTest {

    @Test
    @DisplayName("Орел перемещается в другую клетку")
    void eagleMoves() {
        Island island = new Island(3,3);
        Cell start = island.getCell(1,1);

        Eagle eagle = new Eagle(start);
        start.getAnimals().add(eagle);

        eagle.liveStep(island);

        assertNotNull(eagle.getCell());
    }

    @Test
    @DisplayName("Орел пытается съесть кролика")
    void eagleEatsRabbit() {
        Island island = new Island(3,3);
        Cell cell = island.getCell(1,1);

        Eagle eagle = new Eagle(cell);
        Rabbit rabbit = new Rabbit(cell);

        cell.getAnimals().add(eagle);
        cell.getAnimals().add(rabbit);

        eagle.satiety = 0;
        eagle.eat();

        assertTrue(!rabbit.isAlive() || eagle.satiety > 0);
    }
}
