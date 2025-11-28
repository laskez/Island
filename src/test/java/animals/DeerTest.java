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
class DeerTest {

    @Test
    @Story("Движение")
    @DisplayName("Олень перемещается")
    void deerMoves() {
        Island island = new Island(3,3);
        Cell start = island.getCell(1,1);

        Deer deer = new Deer(start);
        start.getAnimals().add(deer);

        deer.liveStep(island);

        assertNotNull(deer.getCell());
    }

    @Test
    @Story("Еда")
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
