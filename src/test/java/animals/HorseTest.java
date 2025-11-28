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
class HorseTest {

    @Test
    @Story("Движение")
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
    @Story("Еда")
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
