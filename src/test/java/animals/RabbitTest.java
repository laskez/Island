package animals;

import island.Cell;
import island.Island;
import plant.Plant;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;


class RabbitTest {

    @Test
    @DisplayName("Кролик делает шаг")
    void rabbitMoves() {
        Island island = new Island(3,3);
        Cell start = island.getCell(1,1);

        Rabbit rabbit = new Rabbit(start);
        start.getAnimals().add(rabbit);

        rabbit.liveStep(island);

        assertNotNull(rabbit.getCell());
    }

    @Test
    @DisplayName("Кролик питается растениями")
    void rabbitEatsPlants() {
        Island island = new Island(3,3);
        Cell cell = island.getCell(1,1);

        Rabbit rabbit = new Rabbit(cell);
        cell.getAnimals().add(rabbit);

        cell.getPlants().add(new Plant());

        rabbit.satiety = 0;
        rabbit.eat();

        assertTrue(rabbit.satiety > 0);
    }
}
