package island;

import animals.Rabbit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class StatisticsTest {

    @Test
    @DisplayName("Метод Statistics.print работает без ошибок")
    void testPrint() {
        Island island = new Island(3,3);
        island.getCell(1,1).getAnimals().add(new Rabbit(island.getCell(1,1)));

        assertDoesNotThrow(() -> Statistics.print(island, 1));
    }
}
