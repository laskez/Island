package animals;

import island.Cell;
import island.Island;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;


@Epic("Животные")
@Feature("Хищники")
class WolfTest {

    @Test
    @Story("Движение")
    @DisplayName("Волк делает шаг по острову")
    void wolfMoves() {
        Island island = new Island(3, 3);
        Cell start = island.getCell(1, 1);

        Wolf wolf = new Wolf(start);
        start.getAnimals().add(wolf);

        wolf.liveStep(island);

        assertNotNull(wolf.getCell());
    }

    @Test
    @Story("Еда")
    @DisplayName("Волк МОЖЕТ съесть кролика")
    void wolfEatsRabbit() {
        int chance = island.Config.getEatChance(AnimalType.WOLF, AnimalType.RABBIT);

        assertTrue(chance > 0);
    }
}
