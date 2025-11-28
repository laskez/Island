package animals;

import island.Config;
import animals.AnimalType;
import island.Cell;
import island.Island;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Epic("Животные")
@Feature("Хищники")
class BoaTest {

    @Test
    @Story("Проверка возможности поедания")
    @DisplayName("Удав МОЖЕТ съесть мышь согласно Config")
    void boaCanEatMouse() {

        int chance = Config.getEatChance(AnimalType.BOA, AnimalType.MOUSE);

        assertTrue(chance > 0);
    }
}
