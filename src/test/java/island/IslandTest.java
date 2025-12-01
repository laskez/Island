package island;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

class IslandTest {

    @Test
    @DisplayName("Остров возвращает клетку по координатам")
    void testGetCell() {
        Island island = new Island(5, 5);

        Cell cell = island.getCell(2, 3);

        assertNotNull(cell);
        assertEquals(2, cell.getX());
        assertEquals(3, cell.getY());
    }

    @Test
    @DisplayName("Остров возвращает null, если координаты вне границы")
    void testOutOfBounds() {
        Island island = new Island(5, 5);

        assertNull(island.getCell(-1, 0));
        assertNull(island.getCell(0, -1));
        assertNull(island.getCell(5, 5));
        assertNull(island.getCell(10, 10));
    }
}
