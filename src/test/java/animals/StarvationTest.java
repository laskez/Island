package animals;

import island.Cell;
import island.Island;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StarvationTest {

    @Test
    @DisplayName("Животное умирает при нулевой сытости после liveStep()")
    void diesFromStarvation() {
        Island island = new Island(3,3);
        Cell cell = island.getCell(1,1);

        Rabbit r = new Rabbit(cell);
        r.satiety = 0;     // если satiety = 0, то кролик должен умереть

        r.liveStep(island);

        assertFalse(r.isAlive());
    }
}
