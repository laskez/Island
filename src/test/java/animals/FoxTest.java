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
class FoxTest {

    @Test
    @Story("Движение")
    @DisplayName("Лиса движется по острову")
    void foxMoves() {
        Island island = new Island(3,3);
        Cell start = island.getCell(1,1);

        Fox fox = new Fox(start);
        start.getAnimals().add(fox);

        fox.liveStep(island);

        assertNotNull(fox.getCell());
    }

    @Test
    @Story("Еда")
    @DisplayName("Лиса пытается съесть мышь")
    void foxEatsMouse() {
        Island island = new Island(3,3);
        Cell cell = island.getCell(1,1);

        Fox fox = new Fox(cell);
        Mouse mouse = new Mouse(cell);

        cell.getAnimals().add(fox);
        cell.getAnimals().add(mouse);

        fox.satiety = 0;
        fox.eat();

        assertTrue(!mouse.isAlive() || fox.satiety > 0);
    }
}
