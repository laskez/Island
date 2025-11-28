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
class PredatorTest {

    @Test
    @Story("Проверка возможности поедания")
    @DisplayName("Волк МОЖЕТ съесть кролика согласно Config")
    void predatorCanEatPrey() {

        int chance = Config.getEatChance(AnimalType.WOLF, AnimalType.RABBIT);

        assertTrue(chance > 0);
    }
}
