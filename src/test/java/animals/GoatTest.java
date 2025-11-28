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
class GoatTest {

    @Test
    @Story("Движение")
    @DisplayName("Коза движется")
    void goatMoves() {
        Island island = new Island(3,3);
        Cell start = island.getCell(1,1);

        Goat goat = new Goat(start);
        start.getAnimals().add(goat);

        goat.liveStep(island);

        assertNotNull(goat.getCell());
    }

    @Test
    @Story("Еда")
    @DisplayName("Коза ест растения")
    void goatEatsPlants() {
        Island island = new Island(3,3);
        Cell cell = island.getCell(1,1);

        Goat goat = new Goat(cell);
        cell.getAnimals().add(goat);

        cell.getPlants().add(new Plant());

        goat.satiety = 0;
        goat.eat();

        assertTrue(goat.satiety > 0);
    }
}
