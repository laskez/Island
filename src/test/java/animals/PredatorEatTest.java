package animals;

import island.Cell;
import island.Island;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PredatorEatTest {

    @Test
    @DisplayName("Хищник съедает жертву, если вероятность в Config > 0")
    void predatorEatsVictim() {
        Island island = new Island(3,3);
        Cell cell = island.getCell(1,1);

        Wolf wolf = new Wolf(cell);
        Rabbit rabbit = new Rabbit(cell);

        cell.getAnimals().add(wolf);
        cell.getAnimals().add(rabbit);

        wolf.satiety = 0;
        wolf.eat();

        assertTrue(!rabbit.isAlive() || wolf.satiety > 0);
    }
}
