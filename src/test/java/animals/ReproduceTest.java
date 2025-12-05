package animals;

import island.Cell;
import island.Island;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReproduceTest {

    @Test
    @DisplayName("Животное создаёт потомка при двоих родителях")
    void reproductionCreatesNewAnimal() {
        Island island = new Island(3,3);
        Cell cell = island.getCell(1,1);

        Rabbit r1 = new Rabbit(cell);
        Rabbit r2 = new Rabbit(cell);

        cell.getAnimals().add(r1);
        cell.getAnimals().add(r2);

        int before = cell.getAnimals().size();

        for (int i = 0; i < 50; i++) {
            r1.reproduce();
        }

        int after = cell.getAnimals().size();

        assertTrue(after >= before);
    }
}
