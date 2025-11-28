package island;

import animals.Rabbit;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@Epic("Остров")
@Feature("Статистика")
class StatisticsTest {

    @Test
    @Story("Печать статистики")
    @DisplayName("Statistics.print не вызывает ошибок")
    void testPrint() {
        Island island = new Island(3,3);
        island.getCell(1,1).getAnimals().add(new Rabbit(island.getCell(1,1)));

        assertDoesNotThrow(() -> Statistics.print(island, 1));
    }
}
