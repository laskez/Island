package island;

import animals.*;
import plant.Plant;
import ui.IslandFrame;

import javax.swing.SwingUtilities;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {
        Island island = new Island(20, 10);
        initIsland(island);

        final IslandFrame[] frameHolder = new IslandFrame[1];
        SwingUtilities.invokeLater(() -> frameHolder[0] = new IslandFrame(island));

        Simulation simulation = new Simulation(island);
        AtomicInteger step = new AtomicInteger(0);

        ScheduledExecutorService scheduler =
                Executors.newScheduledThreadPool(2);

        scheduler.scheduleAtFixedRate(() -> {
            int s = step.incrementAndGet();
            simulation.step();
            Statistics.print(island, s);

            SwingUtilities.invokeLater(() -> {
                if (frameHolder[0] != null) {
                    frameHolder[0].refresh();
                }
            });

            if (s >= 100) {
                scheduler.shutdown();
            }
        }, 0, 500, TimeUnit.MILLISECONDS);
    }

    private static void initIsland(Island island) {
        for (int y = 0; y < island.getHeight(); y++) {
            for (int x = 0; x < island.getWidth(); x++) {

                Cell cell = island.getCell(x, y);

                int plants = ThreadLocalRandom.current().nextInt(5, 25);
                for (int i = 0; i < plants; i++) {
                    cell.getPlants().add(new Plant());
                }

                // Хищники
                if (rnd(8)) cell.getAnimals().add(new Wolf(cell));
                if (rnd(6)) cell.getAnimals().add(new Fox(cell));
                if (rnd(4)) cell.getAnimals().add(new Bear(cell));
                if (rnd(3)) cell.getAnimals().add(new Eagle(cell));
                if (rnd(5)) cell.getAnimals().add(new Boa(cell));

                // Травоядные
                if (rnd(12)) cell.getAnimals().add(new Horse(cell));
                if (rnd(12)) cell.getAnimals().add(new Deer(cell));
                if (rnd(20)) cell.getAnimals().add(new Rabbit(cell));
                if (rnd(18)) cell.getAnimals().add(new Mouse(cell));
                if (rnd(15)) cell.getAnimals().add(new Goat(cell));
                if (rnd(15)) cell.getAnimals().add(new Sheep(cell));
                if (rnd(10)) cell.getAnimals().add(new Boar(cell));
                if (rnd(8))  cell.getAnimals().add(new Buffalo(cell));
                if (rnd(18)) cell.getAnimals().add(new Duck(cell));
                if (rnd(20)) cell.getAnimals().add(new Caterpillar(cell));
            }
        }
    }

    private static boolean rnd(int percent) {
        return ThreadLocalRandom.current().nextInt(100) < percent;
    }
}
