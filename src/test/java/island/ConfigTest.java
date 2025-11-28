package island;

import animals.AnimalType;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;


@Epic("Остров")
@Feature("Конфигурация")
class ConfigTest {

    @Test
    @Story("Таблица вероятностей")
    @DisplayName("Chance волк → кролик равен 60")
    void testWolfRabbitChance() {
        int chance = Config.getEatChance(AnimalType.WOLF, AnimalType.RABBIT);
        assertEquals(60, chance);
    }

    @Test
    @Story("Таблица вероятностей")
    @DisplayName("Chance волк → гусеница равен 0")
    void testWolfCaterpillarChance() {
        int chance = Config.getEatChance(AnimalType.WOLF, AnimalType.CATERPILLAR);
        assertEquals(0, chance);
    }
}
