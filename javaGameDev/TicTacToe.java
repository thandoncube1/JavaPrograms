import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe extends JFrame {
    private JButton[][] buttons = new JButton[3][3];
    private boolean isXTurn = true;
    private boolean gameEnded = false;
    private JLabel statusLabel;

    public TicTacToe() {
        // Set up the frame
        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(480, 640);
        setLayout(new BorderLayout());

        // Create status label
        statusLabel = new JLabel("X's Turn", SwingConstants.CENTER);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(statusLabel, BorderLayout.NORTH);

        // Create main game panel
        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayout(3, 3));

        // Initialize buttons
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col] = new JButton("");
                buttons[row][col].setFont(new Font("Arial", Font.BOLD, 60));
                buttons[row][col].setFocusPainted(false);

                // Add action listener to each button
                final int currentRow = row;
                final int currentCol = col;
                buttons[row][col].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        makeMove(currentRow, currentCol);
                    }
                });

                gamePanel.add(buttons[row][col]);
            }
        }

        add(gamePanel, BorderLayout.CENTER);

        // Add reset button
        JButton resetButton = new JButton("Reset Game");
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGame();
            }
        });
        add(resetButton, BorderLayout.SOUTH);

        // Center the frame on screen
        setLocationRelativeTo(null);
    }

    private void makeMove(int row, int col) {
        // If the game has ended or the button is already clicked, return
        if (gameEnded || !buttons[row][col].getText().equals("")) {
            return;
        }

        // Set X or O based on whose turn it is
        buttons[row][col].setText(isXTurn ? "X" : "O");

        // Check for win or draw
        if (checkWin(row, col)) {
            statusLabel.setText((isXTurn ? "X" : "O") + " Wins!");
            gameEnded = true;
            highlightWinningCombination();
            return;
        }

        // Check for draw
        if (checkDraw()) {
            statusLabel.setText("It's a Draw!");
            gameEnded = true;
            return;
        }

        // Switch turns
        isXTurn = !isXTurn;
        statusLabel.setText((isXTurn ? "X" : "O") + "'s Turn");
    }

    private boolean checkWin(int row, int col) {
        String symbol = buttons[row][col].getText();

        // Check row
        if (buttons[row][0].getText().equals(symbol) &&
            buttons[row][1].getText().equals(symbol) &&
            buttons[row][2].getText().equals(symbol)) {
            return true;
        }

        // Check column
        if (buttons[0][col].getText().equals(symbol) &&
            buttons[1][col].getText().equals(symbol) &&
            buttons[2][col].getText().equals(symbol)) {
            return true;
        }

        // Check diagonals
        if (row == col &&
            buttons[0][0].getText().equals(symbol) &&
            buttons[1][1].getText().equals(symbol) &&
            buttons[2][2].getText().equals(symbol)) {
            return true;
        }

        if (row + col == 2 &&
            buttons[0][2].getText().equals(symbol) &&
            buttons[1][1].getText().equals(symbol) &&
            buttons[2][0].getText().equals(symbol)) {
            return true;
        }

        return false;
    }

    private void highlightWinningCombination() {
        // This method could be implemented to highlight the winning combination
        // by changing the background color of the winning buttons
    }

    private boolean checkDraw() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (buttons[row][col].getText().equals("")) {
                    return false;
                }
            }
        }
        return true;
    }

    private void resetGame() {
        // Reset all buttons
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col].setText("");
                buttons[row][col].setBackground(null);
            }
        }

        // Reset game state
        isXTurn = true;
        gameEnded = false;
        statusLabel.setText("X's Turn");
    }

    public static void main(String[] args) {
        // Create and display the game on the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TicTacToe().setVisible(true);
            }
        });
    }
}