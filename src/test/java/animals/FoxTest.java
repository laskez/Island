package animals;

import island.Cell;
import island.Island;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

class FoxTest {

    @Test
    @DisplayName("Лиса делает шаг")
    void foxMoves() {
        Island island = new Island(3,3);
        Cell start = island.getCell(1,1);

        Fox fox = new Fox(start);
        start.getAnimals().add(fox);

        fox.liveStep(island);

        assertNotNull(fox.getCell());
    }

    @Test
    @DisplayName("Лиса охотится на мышь")
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
