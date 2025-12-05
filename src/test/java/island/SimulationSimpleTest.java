package island;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class SimulationSimpleTest {

    @Test
    @DisplayName("Шаг симуляции выполняется без ошибок")
    void simulationRuns() {
        Island island = new Island(3,3);
        Simulation sim = new Simulation(island);

        assertDoesNotThrow(sim::step);
    }
}
