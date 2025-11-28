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
class BuffaloTest {

    @Test
    @Story("Движение")
    @DisplayName("Буйвол совершает шаг")
    void buffaloMoves() {
        Island island = new Island(3,3);
        Cell start = island.getCell(1,1);

        Buffalo buffalo = new Buffalo(start);
        start.getAnimals().add(buffalo);

        buffalo.liveStep(island);

        assertNotNull(buffalo.getCell());
    }

    @Test
    @Story("Еда")
    @DisplayName("Буйвол ест растения")
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
