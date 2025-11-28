package island;

public class Island {
    private final int width;
    private final int height;
    private final Cell[][] grid;

    public Island(int width, int height) {
        this.width = width;
        this.height = height;
        grid = new Cell[height][width];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                grid[y][x] = new Cell(x, y);
            }
        }
    }

    public int getWidth() { return width; }
    public int getHeight() { return height; }

    public Cell getCell(int x, int y) {
        if (x < 0 || y < 0 || x >= width || y >= height) return null;
        return grid[y][x];
    }

    public Cell[][] getGrid() {
        return grid;
    }
}
