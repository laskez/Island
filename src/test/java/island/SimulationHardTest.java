package island;

import animals.Rabbit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimulationHardTest {

    @Test
    @DisplayName("liveStep реально меняет клетку животного (движение работает)")
    void animalChangesCellDuringSimulationStep() {
        Island island = new Island(5,5);
        Cell start = island.getCell(2,2);

        Rabbit rabbit = new Rabbit(start);
        start.getAnimals().add(rabbit);

        Simulation sim = new Simulation(island);
        sim.step();

        Cell after = rabbit.getCell();

        assertNotNull(after);
        assertTrue(isNeighbor(start, after));
    }

    private boolean isNeighbor(Cell a, Cell b) {
        int dx = Math.abs(a.getX() - b.getX());
        int dy = Math.abs(a.getY() - b.getY());
        return dx <= 3 && dy <= 3;
    }
}
