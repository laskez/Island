package animals;

import island.Config;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PredatorTest {

    @Test
    @DisplayName("Хищник имеет шанс съесть добычку по таблице вероятностей")
    void predatorCanEatPrey() {

        int chance = Config.getEatChance(AnimalType.WOLF, AnimalType.RABBIT);

        assertTrue(chance > 0);
    }
}
