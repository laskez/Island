package island;

import animals.Rabbit;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;


@Epic("Остров")
@Feature("Клетка")
class CellTest {

    @Test
    @Story("Создание клетки")
    @DisplayName("Клетка хранит координаты X и Y")
    void testCoordinates() {
        Cell c = new Cell(4, 7);

        assertEquals(4, c.getX());
        assertEquals(7, c.getY());
    }

    @Test
    @Story("Списки содержимого")
    @DisplayName("Списки животных и растений не null")
    void testListsNotNull() {
        Cell c = new Cell(0, 0);

        assertNotNull(c.getAnimals());
        assertNotNull(c.getPlants());
    }
}
