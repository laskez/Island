package island;

import animals.AnimalType;

public class Config {

    private static final int[][] EAT_CHANCE =
            new int[AnimalType.values().length][AnimalType.values().length];

    static {
        // Excel
        put(AnimalType.WOLF, AnimalType.HORSE, 10);
        put(AnimalType.WOLF, AnimalType.DEER, 15);
        put(AnimalType.WOLF, AnimalType.RABBIT, 60);
        put(AnimalType.WOLF, AnimalType.MOUSE, 80);
        put(AnimalType.WOLF, AnimalType.GOAT, 60);
        put(AnimalType.WOLF, AnimalType.SHEEP, 70);
        put(AnimalType.WOLF, AnimalType.BOAR, 15);
        put(AnimalType.WOLF, AnimalType.BUFFALO, 10);
        put(AnimalType.WOLF, AnimalType.DUCK, 40);
        put(AnimalType.WOLF, AnimalType.CATERPILLAR, 0);

        put(AnimalType.FOX, AnimalType.RABBIT, 70);
        put(AnimalType.FOX, AnimalType.MOUSE, 90);
        put(AnimalType.FOX, AnimalType.DUCK, 60);
        put(AnimalType.FOX, AnimalType.CATERPILLAR, 40);

        put(AnimalType.BEAR, AnimalType.HORSE, 40);
        put(AnimalType.BEAR, AnimalType.DEER, 80);
        put(AnimalType.BEAR, AnimalType.BOAR, 50);
        put(AnimalType.BEAR, AnimalType.BUFFALO, 20);
        put(AnimalType.BEAR, AnimalType.RABBIT, 80);
        put(AnimalType.BEAR, AnimalType.MOUSE, 90);
        put(AnimalType.BEAR, AnimalType.GOAT, 70);
        put(AnimalType.BEAR, AnimalType.SHEEP, 70);
        put(AnimalType.BEAR, AnimalType.DUCK, 10);

        put(AnimalType.BOA, AnimalType.FOX, 15);
        put(AnimalType.BOA, AnimalType.RABBIT, 20);
        put(AnimalType.BOA, AnimalType.MOUSE, 40);
        put(AnimalType.BOA, AnimalType.DUCK, 10);

        put(AnimalType.EAGLE, AnimalType.FOX, 10);
        put(AnimalType.EAGLE, AnimalType.RABBIT, 90);
        put(AnimalType.EAGLE, AnimalType.MOUSE, 90);
        put(AnimalType.EAGLE, AnimalType.DUCK, 80);

    }

    private static void put(AnimalType predator, AnimalType prey, int chance) {
        EAT_CHANCE[predator.ordinal()][prey.ordinal()] = chance;
    }

    public static int getEatChance(AnimalType predator, AnimalType prey) {
        return EAT_CHANCE[predator.ordinal()][prey.ordinal()];
    }
}
