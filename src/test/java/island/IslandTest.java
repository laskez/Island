package island;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;


@Epic("Остров")
@Feature("Карта острова")
class IslandTest {

    @Test
    @Story("Получение клеток")
    @DisplayName("Можно получить клетку по координатам")
    void testGetCell() {
        Island island = new Island(5, 5);

        Cell cell = island.getCell(2, 3);

        assertNotNull(cell);
        assertEquals(2, cell.getX());
        assertEquals(3, cell.getY());
    }

    @Test
    @Story("Границы карты")
    @DisplayName("Клетка вне карты возвращает null")
    void testOutOfBounds() {
        Island island = new Island(5, 5);

        assertNull(island.getCell(-1, 0));
        assertNull(island.getCell(0, -1));
        assertNull(island.getCell(5, 5));
        assertNull(island.getCell(10, 10));
    }
}
