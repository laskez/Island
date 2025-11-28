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
class DuckTest {

    @Test
    @Story("Движение")
    @DisplayName("Утка перемещается")
    void duckMoves() {
        Island island = new Island(3,3);
        Cell start = island.getCell(1,1);

        Duck duck = new Duck(start);
        start.getAnimals().add(duck);

        duck.liveStep(island);

        assertNotNull(duck.getCell());
    }

    @Test
    @Story("Еда растений")
    @DisplayName("Утка ест растения")
    void duckEatsPlants() {
        Island island = new Island(3,3);
        Cell cell = island.getCell(1,1);

        Duck duck = new Duck(cell);
        cell.getAnimals().add(duck);

        cell.getPlants().add(new Plant());

        duck.satiety = 0;
        duck.eat();

        assertTrue(duck.satiety > 0);
    }

    @Test
    @Story("Еда гусениц")
    @DisplayName("Утка может съесть гусеницу")
    void duckEatsCaterpillar() {
        Island island = new Island(3,3);
        Cell cell = island.getCell(1,1);

        Duck duck = new Duck(cell);
        Caterpillar cat = new Caterpillar(cell);

        cell.getAnimals().add(duck);
        cell.getAnimals().add(cat);

        duck.satiety = 0;
        duck.eat();

        assertTrue(!cat.isAlive() || duck.satiety > 0);
    }
}
