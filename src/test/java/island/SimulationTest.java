package island;

import animals.Rabbit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;


class SimulationTest {

    @Test
    @DisplayName("Во время шага симуляции растения вырастают")
    void testGrowPlants() {
        Island island = new Island(2, 2);
        Simulation sim = new Simulation(island);

        int before = island.getCell(0,0).getPlants().size();

        sim.step();

        int after = island.getCell(0,0).getPlants().size();
        assertTrue(after >= before);
    }

    @Test
    @DisplayName("step() симуляции выполняется без ошибок")
    void testSimulationStep() {
        Island island = new Island(3,3);
        Simulation sim = new Simulation(island);

        assertDoesNotThrow(sim::step);
    }

    @Test
    @DisplayName("Животные выполняют свой жизненный цикл в процессе шага симуляции")
    void testAnimalsRunLifeCycle() {
        Island island = new Island(3,3);
        Cell cell = island.getCell(1,1);

        Rabbit r = new Rabbit(cell);
        cell.getAnimals().add(r);

        Simulation sim = new Simulation(island);
        sim.step();

        assertTrue(r.isAlive());
    }
}
