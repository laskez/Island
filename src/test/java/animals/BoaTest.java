package animals;

import island.Config;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoaTest {

    @Test
    @DisplayName("Удав имеет вероятность съесть мыщь согласно Config")
    void boaCanEatMouse() {

        int chance = Config.getEatChance(AnimalType.BOA, AnimalType.MOUSE);

        assertTrue(chance > 0);
    }
}
