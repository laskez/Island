package island;

import animals.Rabbit;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;


@Epic("Остров")
@Feature("Симуляция")
class SimulationTest {

    @Test
    @Story("Рост растений")
    @DisplayName("Шаг симуляции добавляет растения")
    void testGrowPlants() {
        Island island = new Island(2, 2);
        Simulation sim = new Simulation(island);

        int before = island.getCell(0,0).getPlants().size();

        sim.step();

        int after = island.getCell(0,0).getPlants().size();
        assertTrue(after >= before);
    }

    @Test
    @Story("Шаг симуляции")
    @DisplayName("Шаг симуляции вызывается без ошибок")
    void testSimulationStep() {
        Island island = new Island(3,3);
        Simulation sim = new Simulation(island);

        assertDoesNotThrow(sim::step);
    }

    @Test
    @Story("Жизненные циклы")
    @DisplayName("Животные совершают liveStep во время симуляции")
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
