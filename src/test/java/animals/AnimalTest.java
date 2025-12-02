package animals;

import island.Cell;
import island.Island;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;


class AnimalTest {

    static class TestAnimal extends Animal {
        boolean moved = false;
        boolean eaten = false;
        boolean reproduced = false;

        public TestAnimal(Cell cell) {
            super(AnimalType.RABBIT, cell);
        }

        @Override
        protected void move(Island island) {
            moved = true;
        }

        @Override
        protected void eat() {
            eaten = true;
        }

        @Override
        protected void reproduce() {
            reproduced = true;
        }
    }

    @Test
    @DisplayName("Животное выполняет полный жизненный цикл")
    void testLiveStep() {
        Island island = new Island(3, 3);
        Cell cell = island.getCell(1, 1);

        TestAnimal a = new TestAnimal(cell);
        cell.getAnimals().add(a);

        a.liveStep(island);

        assertTrue(a.moved);
        assertTrue(a.eaten);
        assertTrue(a.reproduced);
    }

    @Test
    @DisplayName("Животное становится мертвым после вызова die()")
    void testDie() {
        Cell c = new Cell(0, 0);
        TestAnimal a = new TestAnimal(c);

        a.die();

        assertFalse(a.isAlive());
    }

    @Test
    @DisplayName("Животное умирает при нулевой сытости")
    void testStarvation() {
        Island island = new Island(3, 3);
        Cell cell = island.getCell(1, 1);

        TestAnimal a = new TestAnimal(cell);
        a.satiety = 0;

        a.liveStep(island);

        assertFalse(a.isAlive());
    }

    @Test
    @DisplayName("Животное корректно перемещается в другую клетку")
    void testMoveTo() {
        Island island = new Island(3, 3);
        Cell c1 = island.getCell(0, 0);
        Cell c2 = island.getCell(1, 1);

        TestAnimal a = new TestAnimal(c1);
        c1.getAnimals().add(a);

        a.moveTo(c2);

        assertEquals(c2, a.getCell());
        assertFalse(c1.getAnimals().contains(a));
        assertTrue(c2.getAnimals().contains(a));
    }
}

@Test
@DisplayName("Животное умирает при нулевой сытости в liveStep()")
void diesFromStarvation() {
    Island island = new Island(3, 3);
    Cell cell = island.getCell(1, 1);

    TestAnimal a = new TestAnimal(cell);
    a.satiety = 0;

    a.liveStep(island);

    assertFalse(a.isAlive());
}

@Test
@DisplayName("Метод die() делает животное мёртвым")
void dieMarksDead() {
    Cell cell = new Cell(0, 0);
    TestAnimal a = new TestAnimal(cell);

    a.die();

    assertFalse(a.isAlive());
}

@Test
@DisplayName("moveTo() корректно переносит животное в другую клетку")
void moveToMovesAnimal() {
    Island island = new Island(3, 3);
    Cell c1 = island.getCell(0, 0);
    Cell c2 = island.getCell(1, 1);

    TestAnimal a = new TestAnimal(c1);
    c1.getAnimals().add(a);

    a.moveTo(c2);

    assertEquals(c2, a.getCell());
    assertFalse(c1.getAnimals().contains(a));
    assertTrue(c2.getAnimals().contains(a));
}

