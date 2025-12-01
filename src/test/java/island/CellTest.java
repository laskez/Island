package island;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;


class CellTest {

    @Test
    @DisplayName("Клетка корректно хранит координаты")
    void testCoordinates() {
        Cell c = new Cell(4, 7);

        assertEquals(4, c.getX());
        assertEquals(7, c.getY());
    }

    @Test
    @DisplayName("Клетка инициализирует списки животных и растений")
    void testListsNotNull() {
        Cell c = new Cell(0, 0);

        assertNotNull(c.getAnimals());
        assertNotNull(c.getPlants());
    }
}
