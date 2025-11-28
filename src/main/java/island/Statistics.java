package island;

import animals.Animal;
import animals.AnimalType;
import plant.Plant;

import java.util.EnumMap;
import java.util.Map;

public class Statistics {

    public static void print(Island island, int step) {
        Map<AnimalType, Integer> counters = new EnumMap<>(AnimalType.class);
        for (AnimalType t : AnimalType.values()) {
            counters.put(t, 0);
        }
        int plants = 0;

        for (Cell[] row : island.getGrid()) {
            for (Cell cell : row) {
                for (Animal a : cell.getAnimals()) {
                    counters.put(a.getType(), counters.get(a.getType()) + 1);
                }
                plants += cell.getPlants().size();
            }
        }

        System.out.println("------------------------");
        System.out.println("=== Шаг " + step + " ===");
        for (AnimalType t : AnimalType.values()) {
            System.out.printf("%-10s %d%n", t.name() + ":", counters.get(t));
        }
        System.out.println("PLANTS: " + plants);

        System.out.println();
        System.out.println("Карта острова:");
        printMap(island);
        System.out.println();
    }

    private static void printMap(Island island) {
        Cell[][] grid = island.getGrid();

        for (int y = 0; y < island.getHeight(); y++) {
            StringBuilder row = new StringBuilder();
            for (int x = 0; x < island.getWidth(); x++) {
                Cell cell = grid[y][x];

                String symbol;

                if (!cell.getAnimals().isEmpty()) {
                    Animal a = cell.getAnimals().get(0);
                    symbol = a.getType().getSymbol();
                } else if (!cell.getPlants().isEmpty()) {
                    symbol = "🌿";
                } else {
                    symbol = "·";
                }

                row.append(symbol).append(' ');
            }
            System.out.println(row);
        }
    }
}
