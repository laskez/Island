package island;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IslandTest {

    @Test
    @DisplayName("getCell() возвращает клетку по корректным координатам")
    void getCellReturnsCorrect() {
        Island i = new Island(5,5);

        Cell c = i.getCell(2,3);

        assertNotNull(c);
        assertEquals(2, c.getX());
        assertEquals(3, c.getY());
    }
}
