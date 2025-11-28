package animals;

import island.Cell;
import island.Island;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal {

    protected final AnimalType type;

    protected double satiety = 0;
    protected boolean alive = true;
    protected Cell cell;

    protected Animal(AnimalType type, Cell cell) {
        this.type = type;
        this.cell = cell;
        this.satiety = type.getFoodNeed(); // начинаем сытым
    }

    public AnimalType getType() {
        return type;
    }

    public boolean isAlive() {
        return alive;
    }

    public Cell getCell() {
        return cell;
    }

    public void die() {
        alive = false;
    }

    public void liveStep(Island island) {
        if (!alive) return;

        move(island);
        eat();
        reproduce();
        checkStarvation();
    }

    protected abstract void move(Island island);
    protected abstract void eat();
    protected abstract void reproduce();


    protected void checkStarvation() {
        satiety -= type.getFoodNeed() * 0.10;

        if (satiety <= 0) {
            die();
            return;
        }

        if (satiety > type.getFoodNeed()) {
            satiety = type.getFoodNeed();
        }
    }

    protected Cell getRandomTargetCell(Island island) {
        int speed = type.getSpeed();
        if (speed <= 0) {
            return cell;
        }

        int x = cell.getX();
        int y = cell.getY();

        int dx = ThreadLocalRandom.current().nextInt(-speed, speed + 1);
        int dy = ThreadLocalRandom.current().nextInt(-speed, speed + 1);

        if (dx == 0 && dy == 0) {
            return cell;
        }

        int newX = Math.max(0, Math.min(island.getWidth() - 1, x + dx));
        int newY = Math.max(0, Math.min(island.getHeight() - 1, y + dy));

        return island.getCell(newX, newY);
    }

    protected void moveTo(Cell target) {
        if (target == null || target == cell) return;

        cell.getAnimals().remove(this);
        target.getAnimals().add(this);
        this.cell = target;
    }
}
