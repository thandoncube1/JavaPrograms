import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePlay extends JPanel implements KeyListener, ActionListener {

    private boolean play = false;
    private int score = 0;
    private int totalBricks = 21;
    private Timer timer;
    private int delay = 8;
    private int playerX = 310;
    private int ballPosX = 120;
    private int ballPosY = 350;
    private int ballXDir = -1;
    private int ballYDir = -2;
    private MapGenerator map;

    public GamePlay() {
        map = new MapGenerator(3, 7);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
    }

    public void paint(Graphics graphic) {
        graphic.setColor(Color.black);
        graphic.fillRect(1, 1, 692, 592);
        map.draw((Graphics2D) graphic);
        graphic.setColor(Color.YELLOW);
        graphic.fillRect(0, 0, 3, 592);
        graphic.fillRect(0, 0, 692, 3);
        graphic.fillRect(692, 0, 0, 592);

        graphic.setColor(Color.WHITE);
        graphic.setFont(new Font("serif", Font.BOLD, 25));
        graphic.drawString("" + score, 590, 30);

        graphic.setColor(Color.YELLOW);
        graphic.fillRect(playerX, 550, 100, 8);

        graphic.setColor(Color.GREEN);
        graphic.fillOval(ballPosX, ballPosY, 20, 20);

        if (ballPosY > 570) {
            play = false;
            ballXDir = 0;
            ballYDir = 0;
            graphic.setColor(Color.RED);
            graphic.setFont(new Font("serif", Font.BOLD, 30));
            graphic.drawString("Game Over Score : " + score, 190, 300);

            graphic.setFont(new Font("serif", Font.BOLD, 30));
            graphic.drawString("Press Enter to Restart ", 190, 340);
        }

        if (totalBricks == 0) {
            play = false;
            ballYDir = -2;
            ballXDir = -1;
            graphic.setColor(Color.RED);
            graphic.setFont(new Font("serif", Font.BOLD, 30));
            graphic.drawString("Game Over Score : " + score, 190, 300);
        }
        graphic.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        if (play) {
            if (new Rectangle(ballPosX, ballPosY, 20, 20).intersects(new Rectangle(playerX, 550, 100, 8))) {
                ballYDir = -ballYDir;
            }
            A:
            for (int i = 0; i < map.map.length; i++) {
                for (int j = 0; j < map.map[0].length; j++) {
                    if (map.map[i][j] > 0) {
                        int brickX = j * map.brickWidth + 80;
                        int brickY = i * map.brickHeight + 50;
                        int bricksWidth = map.brickWidth;
                        int bricksHeight = map.brickHeight;

                        Rectangle rectangle = new Rectangle(brickX, brickY, bricksWidth, bricksHeight);
                        Rectangle ballRect = new Rectangle(ballPosX, ballPosY, 20, 20);
                        Rectangle brickRect = rectangle;

                        if (ballRect.intersects(brickRect)) {
                            map.setBrickValue(0, i, j);
                            totalBricks--;
                            score += 5;
                            if (ballPosX + 19 <= brickRect.x || ballPosX + 1 >= brickRect.x + bricksWidth) {
                                ballXDir = -ballXDir;
                            } else {
                                ballYDir = -ballYDir;
                            }
                            break A;
                        }
                    }
                }
            }
            ballPosX += ballXDir;
            ballPosY += ballYDir;
            if (ballPosX < 0) {
                ballXDir = -ballXDir;
            }
            if (ballPosY < 0) {
                ballYDir = -ballYDir;
            }
            if (ballPosX > 670) {
                ballXDir = -ballXDir;
            }
        }
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == KeyEvent.VK_RIGHT) {
            if (playerX >= 600) {
                playerX = 600;
            } else {
                moveRight();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (playerX < 10) {
                playerX = 10;
            } else {
                moveLeft();
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!play) {
                ballPosX = 120;
                ballPosY = 350;
                ballXDir = -1;
                ballYDir = -2;
                score = 0;
                playerX = 310;
                totalBricks = 21;
                map = new MapGenerator(3, 7);
                repaint();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void moveRight() {
        play = true;
        playerX += 20;
    }

    public void moveLeft() {
        play = true;
        playerX -= 20;
    }
}
