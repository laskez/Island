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
class SheepTest {

    @Test
    @Story("Движение")
    @DisplayName("Овца делает шаг")
    void sheepMoves() {
        Island island = new Island(3,3);
        Cell start = island.getCell(1,1);

        Sheep sheep = new Sheep(start);
        start.getAnimals().add(sheep);

        sheep.liveStep(island);

        assertNotNull(sheep.getCell());
    }

    @Test
    @Story("Еда")
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
