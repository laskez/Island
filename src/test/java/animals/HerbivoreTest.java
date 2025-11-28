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
class HerbivoreTest {

    @Test
    @Story("Еда растений")
    @DisplayName("Травоядное ест растения в клетке")
    void testHerbivoreEatsPlants() {
        Island island = new Island(3, 3);
        Cell cell = island.getCell(1, 1);

        Goat goat = new Goat(cell);
        cell.getAnimals().add(goat);

        cell.getPlants().add(new Plant());
        cell.getPlants().add(new Plant());

        goat.satiety = 0;

        goat.eat();

        assertTrue(goat.satiety > 0);
        assertEquals(0, cell.getPlants().size());
    }
}
