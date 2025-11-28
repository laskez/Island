package animals;

import island.Cell;
import island.Island;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;


@Epic("Животные")
@Feature("Хищники")
class BearTest {

    @Test
    @Story("Движение")
    @DisplayName("Медведь делает шаг")
    void bearMoves() {
        Island island = new Island(3, 3);
        Cell start = island.getCell(1, 1);

        Bear bear = new Bear(start);
        start.getAnimals().add(bear);

        bear.liveStep(island);

        assertNotNull(bear.getCell());
    }

    @Test
    @Story("Еда")
    @DisplayName("Медведь пытается съесть мышь")
    void bearEatsMouse() {
        Island island = new Island(3, 3);
        Cell cell = island.getCell(1, 1);

        Bear bear = new Bear(cell);
        Mouse mouse = new Mouse(cell);

        cell.getAnimals().add(bear);
        cell.getAnimals().add(mouse);

        bear.satiety = 0;
        bear.eat();

        assertTrue(!mouse.isAlive() || bear.satiety > 0);
    }
}
