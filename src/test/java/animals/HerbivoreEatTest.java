package animals;

import island.Cell;
import island.Island;
import plant.Plant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HerbivoreEatTest {

    @Test
    @DisplayName("Травоядное ест растение и увеличивает сытость")
    void herbivoreEatsPlant() {
        Island island = new Island(3,3);
        Cell cell = island.getCell(1,1);

        Goat goat = new Goat(cell);
        cell.getAnimals().add(goat);

        // Добавляем растения
        cell.getPlants().add(new Plant());
        goat.satiety = 0;

        goat.eat();

        assertTrue(goat.satiety > 0); // сытость выросла
        assertEquals(0, cell.getPlants().size()); // растение съедено
    }
}
