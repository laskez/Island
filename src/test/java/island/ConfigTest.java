package island;

import animals.AnimalType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConfigTest {

    @Test
    @DisplayName("Вероятность волк → кролик равна 60")
    void wolfRabbitChanceCorrect() {
        assertEquals(60, Config.getEatChance(AnimalType.WOLF, AnimalType.RABBIT));
    }
}
