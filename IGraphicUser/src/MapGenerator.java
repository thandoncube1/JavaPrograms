import java.awt.*;

public class MapGenerator {
    public int[][] map;
    public int brickWidth;
    public int brickHeight;

    public MapGenerator(int row, int column) {
        map = new int[row][column];
        for (int [] map1: map) {
            for (int j = 0; j < map[0].length; j++) {
                map1[j] = 1;
            }
        }
        brickWidth = 540/column;
        brickHeight = 150/row;
    }

    public void draw(Graphics2D graphic) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] > 0) {
                    graphic.setColor(Color.RED);
                    graphic.fillRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
                    graphic.setStroke(new BasicStroke(3));
                    graphic.setColor(Color.BLACK);
                    graphic.drawRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
                }
            }
        }
    }

    public void setBrickValue(int value, int row, int column) {
        map[row][column] = value;
    }
}
