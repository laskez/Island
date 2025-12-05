package animals;

import island.Cell;
import island.Island;
import island.Simulation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReproduceHardTest {

    @Test
    @DisplayName("Массовое размножение: при большом количестве кроликов рождаются новые")
    void massReproductionWorks() {
        Island island = new Island(5,5);
        Cell cell = island.getCell(2,2);

        for (int i = 0; i < 20; i++) {
            cell.getAnimals().add(new Rabbit(cell));
        }

        int before = cell.getAnimals().size();

        Simulation sim = new Simulation(island);
        for (int i = 0; i < 20; i++) {
            sim.step();
        }

        int after = cell.getAnimals().size();

        assertTrue(after > before,
                "Ожидалось увеличение количества животных после шагов симуляции");
    }
}
