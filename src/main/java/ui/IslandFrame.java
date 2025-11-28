package ui;

import animals.Animal;
import animals.AnimalType;
import island.Cell;
import island.Island;

import javax.swing.*;
import java.awt.*;

public class IslandFrame extends JFrame {

    private final Island island;
    private final IslandPanel panel;

    public IslandFrame(Island island) {
        this.island = island;
        this.panel = new IslandPanel();

        setTitle("Остров");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        add(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void refresh() {
        panel.repaint();
    }

    private class IslandPanel extends JPanel {

        private static final int CELL_SIZE = 26;

        public IslandPanel() {
            int width = island.getWidth() * CELL_SIZE;
            int height = island.getHeight() * CELL_SIZE;
            setPreferredSize(new Dimension(width, height));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Font emojiFont = new Font("Segoe UI Emoji", Font.PLAIN, 20);
            if (!emojiFont.canDisplay('A')) {
                emojiFont = new Font("Segoe UI Symbol", Font.PLAIN, 20);
            }
            g.setFont(emojiFont);

            for (int y = 0; y < island.getHeight(); y++) {
                for (int x = 0; x < island.getWidth(); x++) {
                    Cell cell = island.getCell(x, y);

                    String symbol;
                    Color fgColor;
                    Color bgColor = new Color(20, 60, 20); // фон клетки

                    if (!cell.getAnimals().isEmpty()) {
                        Animal a = cell.getAnimals().get(0);
                        AnimalType type = a.getType();
                        symbol = type.getSymbol();
                        fgColor = getColorFor(type);
                    } else if (!cell.getPlants().isEmpty()) {
                        symbol = "🌿";
                        fgColor = new Color(0, 220, 0);
                    } else {
                        symbol = "·";
                        fgColor = new Color(80, 80, 80);
                    }

                    int px = x * CELL_SIZE;
                    int py = y * CELL_SIZE;

                    g.setColor(bgColor);
                    g.fillRect(px, py, CELL_SIZE, CELL_SIZE);

                    g.setColor(new Color(40, 90, 40));
                    g.drawRect(px, py, CELL_SIZE, CELL_SIZE);

                    g.setColor(fgColor);
                    FontMetrics fm = g.getFontMetrics();
                    int textX = px + (CELL_SIZE - fm.stringWidth(symbol)) / 2;
                    int textY = py + (CELL_SIZE + fm.getAscent() - fm.getDescent()) / 2;
                    g.drawString(symbol, textX, textY);
                }
            }
        }

        private Color getColorFor(AnimalType type) {
            switch (type) {
                case WOLF:
                    return new Color(200, 200, 200);    // серый
                case FOX:
                    return new Color(255, 140, 0);      // рыжий
                case BEAR:
                    return new Color(139, 69, 19);      // коричневый
                case BOA:
                    return new Color(0, 200, 100);      // зелёный
                case EAGLE:
                    return new Color(255, 215, 0);      // золотой
                case HORSE:
                    return new Color(210, 105, 30);
                case DEER:
                    return new Color(160, 82, 45);
                case RABBIT:
                    return new Color(245, 245, 245);
                case MOUSE:
                    return new Color(180, 180, 180);
                case GOAT:
                    return new Color(230, 230, 230);
                case SHEEP:
                    return new Color(255, 255, 255);
                case BOAR:
                    return new Color(101, 67, 33);
                case BUFFALO:
                    return new Color(92, 51, 23);
                case DUCK:
                    return new Color(255, 255, 0);
                case CATERPILLAR:
                    return new Color(0, 255, 0);
                default:
                    return Color.WHITE;
            }
        }
    }
}
