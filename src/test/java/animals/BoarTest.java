package animals;

import island.Cell;
import island.Island;
import plant.Plant;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;


class BoarTest {

    @Test
    @DisplayName("Кабан перемещается по острову")
    void boarMoves() {
        Island island = new Island(3,3);
        Cell start = island.getCell(1,1);

        Boar boar = new Boar(start);
        start.getAnimals().add(boar);

        boar.liveStep(island);

        assertNotNull(boar.getCell());
    }

    @Test
    @DisplayName("Кабан ест растения на клетке")
    void boarEatsPlants() {
        Island island = new Island(3,3);
        Cell cell = island.getCell(1,1);

        Boar boar = new Boar(cell);
        cell.getAnimals().add(boar);

        cell.getPlants().add(new Plant());

        boar.satiety = 0;
        boar.eat();

        assertTrue(boar.satiety > 0);
    }
}
