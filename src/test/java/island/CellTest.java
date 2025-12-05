package island;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {

    @Test
    @DisplayName("Клетка корректно хранит координаты X и Y")
    void storesCoordinates() {
        Cell c = new Cell(4,7);
        assertEquals(4, c.getX());
        assertEquals(7, c.getY());
    }
}
