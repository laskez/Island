package island;

import animals.AnimalType;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;


class ConfigTest {

    @Test
    @DisplayName("Вероятность: волк -> кролик равна 60")
    void testWolfRabbitChance() {
        int chance = Config.getEatChance(AnimalType.WOLF, AnimalType.RABBIT);
        assertEquals(60, chance);
    }

    @Test
    @DisplayName("Вероятность: волк -> гусеница равна 0")
    void testWolfCaterpillarChance() {
        int chance = Config.getEatChance(AnimalType.WOLF, AnimalType.CATERPILLAR);
        assertEquals(0, chance);
    }
}
