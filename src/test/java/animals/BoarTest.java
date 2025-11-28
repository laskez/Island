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
class BoarTest {

    @Test
    @Story("Движение")
    @DisplayName("Кабан делает шаг")
    void boarMoves() {
        Island island = new Island(3,3);
        Cell start = island.getCell(1,1);

        Boar boar = new Boar(start);
        start.getAnimals().add(boar);

        boar.liveStep(island);

        assertNotNull(boar.getCell());
    }

    @Test
    @Story("Еда")
    @DisplayName("Кабан ест растения")
    void boarEatsPlants() {
        Island island = new Island(3,3);
        Cell cell = island.getCell(1,1);

        Boar boar = new Boar(cell);
        cell.getAnimals().add(boar);

        cell.getPlants().add(new Plant());

        boar.satiety = 0;
        boar.eat();

        assertTrue(boar.satiety > 0);
    }
}
