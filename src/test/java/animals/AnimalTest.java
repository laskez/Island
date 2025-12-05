package animals;

import island.Cell;
import island.Island;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    static class TestAnimal extends Animal {

        boolean moved = false;
        boolean eaten = false;
        boolean reproduced = false;

        TestAnimal(Cell cell) {
            super(AnimalType.RABBIT, cell);
        }

        @Override
        protected void move(Island island) { moved = true; }

        @Override
        protected void eat() { eaten = true; }

        @Override
        protected void reproduce() { reproduced = true; }
    }
    
    @Test
    @DisplayName("Жизненный цикл вызывает move(), eat(), reproduce() по порядку")
    void lifeStepCallsAllActions() {
        Island island = new Island(3, 3);
        Cell cell = island.getCell(1,1);

        TestAnimal a = new TestAnimal(cell);
        cell.getAnimals().add(a);

        a.liveStep(island);

        assertTrue(a.moved);
        assertTrue(a.eaten);
        assertTrue(a.reproduced);
    }
}
