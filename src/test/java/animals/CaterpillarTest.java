package animals;

import island.Cell;
import island.Island;
import plant.Plant;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Epic("Животные")
@Feature("Травоядные")
class CaterpillarTest {

    @Test
    @Story("Питание гусеницы")
    @DisplayName("Гусеница НЕ ест растения, если она уже сытая")
    void caterpillarDoesNotEatWhenFull() {

        Island island = new Island(3, 3);
        Cell cell = island.getCell(1, 1);

        cell.getPlants().add(new Plant());
        Caterpillar c = new Caterpillar(cell);
        cell.getAnimals().add(c);

        c.liveStep(island);

        assertEquals(1, cell.getPlants().size());
    }
}
