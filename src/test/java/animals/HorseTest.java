package animals;

import island.Cell;
import island.Island;
import plant.Plant;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;


class HorseTest {

    @Test
    @DisplayName("Лошадь делает шаг")
    void horseMoves() {
        Island island = new Island(3,3);
        Cell start = island.getCell(1,1);

        Horse horse = new Horse(start);
        start.getAnimals().add(horse);

        horse.liveStep(island);

        assertNotNull(horse.getCell());
    }

    @Test
    @DisplayName("Лошадь ест растения")
    void horseEatsPlants() {
        Island island = new Island(3,3);
        Cell cell = island.getCell(1,1);

        Horse horse = new Horse(cell);
        cell.getAnimals().add(horse);

        cell.getPlants().add(new Plant());

        horse.satiety = 0;
        horse.eat();

        assertTrue(horse.satiety > 0);
    }
}
