package animals;

import island.Cell;
import island.Island;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

class MoveToTest {

    @Test
    @DisplayName("moveTo() корректно переносит животное между клетками")
    void moveToMovesAnimal() {
        Island island = new Island(3, 3);

        Cell c1 = island.getCell(0,0);
        Cell c2 = island.getCell(1,1);

        Rabbit r = new Rabbit(c1);
        c1.getAnimals().add(r);

        r.moveTo(c2);

        assertEquals(c2, r.getCell()); // Новая клетка
        assertFalse(c1.getAnimals().contains(r)); // ушел из старой
        assertTrue(c2.getAnimals().contains(r)); // пришел в новую
    }
}
