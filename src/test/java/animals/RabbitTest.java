package animals;

import island.Cell;
import island.Island;
import plant.Plant;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;


@Epic("Животные")
@Feature("Травоядные")
class RabbitTest {

    @Test
    @Story("Движение")
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
    @Story("Еда")
    @DisplayName("Кролик ест растения")
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
