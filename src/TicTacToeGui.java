import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class TicTacToeGui extends JFrame implements ActionListener {
    public static final Color BACKGROUND_COLOR = Color.decode("#011627");
    public static final Color X_COLOR = Color.decode("#E71D36");
    public static final Color O_COLOR = Color.decode("#2EC4B6");
    public static final Color BAR_COLOR = Color.decode("#FF9F1C");
    public static final Color BOARD_COLOR = Color.decode("#FDFFFC");

    public static final Dimension FRAME_SIZE = new Dimension(540, 760);
    public static final Dimension BOARD_SIZE = new Dimension((int)(FRAME_SIZE.width * 0.96), (int)(FRAME_SIZE.height * 0.60));
    public static final Dimension BUTTON_SIZE = new Dimension(100, 100);
    public static final Dimension RESULT_DIALOG_SIZE = new Dimension((int)(FRAME_SIZE.width/3), (int)(FRAME_SIZE.height/6));


    public static final String X_LABEL = "X";
    public static final String O_LABEL = "O";
    public static final String SCORE_LABEL = "X: 0 | O: 0";
    private int xScore, oScore, moveCounter;

    private boolean isPlayerOne;

    private JLabel turnLabel, scoreLabel, resultLabel;
    private JButton[][] board;
    private JDialog resultDialog;

    public TicTacToeGui(){
        super("Tic Tac Toe (Java Swing)");
        setSize(FRAME_SIZE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(BACKGROUND_COLOR);

        createResultDialog();
        board = new JButton[3][3];

        isPlayerOne = true;

        addGuiComponent();
    }

    private void addGuiComponent(){
        addToolbar();
        JLabel barLabel = new JLabel();
        barLabel.setOpaque(true);
        barLabel.setBackground(BAR_COLOR);
        barLabel.setBounds(0, 0, FRAME_SIZE.width, 25);

        turnLabel = new JLabel(X_LABEL);
        turnLabel.setHorizontalAlignment(SwingConstants.CENTER);
        turnLabel.setFont(new Font("Dialog", Font.PLAIN, 40));
        turnLabel.setPreferredSize(new Dimension(100, turnLabel.getPreferredSize().height));
        turnLabel.setOpaque(true);
        turnLabel.setBackground(X_COLOR);
        turnLabel.setForeground(BOARD_COLOR);
        turnLabel.setBounds(
                (FRAME_SIZE.width - turnLabel.getPreferredSize().width)/2,
                0,
                turnLabel.getPreferredSize().width,
                turnLabel.getPreferredSize().height
        );

        scoreLabel = new JLabel(SCORE_LABEL);
        scoreLabel.setFont(new Font("Dialog", Font.PLAIN, 40));
        scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        scoreLabel.setForeground(BOARD_COLOR);
        scoreLabel.setBounds(0,
                turnLabel.getY() + turnLabel.getPreferredSize().height + 25,
                FRAME_SIZE.width,
                scoreLabel.getPreferredSize().height
        );

        GridLayout gridLayout = new GridLayout(3, 3);
        JPanel boardPanel = new JPanel(gridLayout);
        boardPanel.setBounds(0,
                scoreLabel.getY() + scoreLabel.getPreferredSize().height + 35,
                BOARD_SIZE.width,
                BOARD_SIZE.height
        );

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                JButton button = new JButton();
                button.setFont(new Font("Dialog", Font.PLAIN, 180));
                button.setPreferredSize(BUTTON_SIZE);
                button.setBackground(BACKGROUND_COLOR);
                button.addActionListener(this);
                button.setBorder(BorderFactory.createLineBorder(BOARD_COLOR));


                board[i][j] = button;
                boardPanel.add(board[i][j]);
            }

        }

        JButton resetButton = new JButton("Reset");
        resetButton.setFont(new Font("Dialog", Font.PLAIN, 24));
        resetButton.addActionListener(this);
        resetButton.setBackground(BOARD_COLOR);
        resetButton.setBounds(
                (FRAME_SIZE.width - resetButton.getPreferredSize().width)/2,
                FRAME_SIZE.height - 100,
                resetButton.getPreferredSize().width,
                resetButton.getPreferredSize().height
        );

        getContentPane().add(turnLabel);
        getContentPane().add(barLabel);
        getContentPane().add(scoreLabel);
        getContentPane().add(boardPanel);
        getContentPane().add(resetButton);

    }
    private void addToolbar(){
        JToolBar toolBar = new JToolBar();
        toolBar.setBounds(0, 0, 50, 20);
        toolBar.setFloatable(false);
        JMenuBar menuBar = new JMenuBar();
        toolBar.add(menuBar);
        JMenu backMenu = new JMenu("Menu");
        menuBar.add(backMenu);
        JMenuItem loadMenu= new JMenuItem("Back to Menu");
        loadMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                
                JFrame menuFrame = new Menu();
                menuFrame.setVisible(true);
            }
        });
        backMenu.add(loadMenu);
        add(toolBar);
    }
    private void createResultDialog(){
        resultDialog = new JDialog();
        resultDialog.getContentPane().setBackground(BACKGROUND_COLOR);
        resultDialog.setResizable(false);
        resultDialog.setTitle("Result");
        resultDialog.setSize(RESULT_DIALOG_SIZE);
        resultDialog.setLocationRelativeTo(this);
        resultDialog.setModal(true);
        resultDialog.setLayout(new GridLayout(2, 1));
        resultDialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                resetGame();
            }
        });

        resultLabel = new JLabel();
        resultLabel.setFont(new Font("Dialog", Font.BOLD, 18));
        resultLabel.setForeground(BOARD_COLOR);
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JButton restartButton = new JButton("Play Again");
        restartButton.setBackground(BOARD_COLOR);
        restartButton.addActionListener(this);

        resultDialog.add(resultLabel);
        resultDialog.add(restartButton);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if(command.equals("Reset") || command.equals("Play Again")){
            resetGame();

            if(command.equals("Reset"))
                xScore = oScore = 0;

            if(command.equals("Play Again"))
                resultDialog.setVisible(false);

        }else{
            JButton button = (JButton) e.getSource();
            if(button.getText().equals("")){
                moveCounter++;

                if(isPlayerOne){
                    button.setText(X_LABEL);
                    button.setForeground(X_COLOR);

                    turnLabel.setText(O_LABEL);
                    turnLabel.setBackground(O_COLOR);

                    isPlayerOne = false;
                }else {
                    button.setText(O_LABEL);
                    button.setForeground(O_COLOR);

                    turnLabel.setText(X_LABEL);
                    turnLabel.setBackground(X_COLOR);

                    isPlayerOne = true;
                }

                if(isPlayerOne){
                    checkOWin();
                }{
                    checkXWin();
                }

                checkDraw();

                scoreLabel.setText("X: " + xScore + " | O: " + oScore);
            }

            repaint();
            revalidate();
        }
    }

    private void checkXWin(){
        String result = "X wins!";

        for(int row = 0; row < board.length; row++){
            if(board[row][0].getText().equals("X") && board[row][1].getText().equals("X") && board[row][2].getText().equals("X")){
                resultLabel.setText(result);

                resultDialog.setVisible(true);

                xScore++;
            }
        }

        for(int col = 0; col < board.length; col++){
            if(board[0][col].getText().equals("X") && board[1][col].getText().equals("X") && board[2][col].getText().equals("X")){
                resultLabel.setText(result);

                resultDialog.setVisible(true);

                xScore++;
            }
        }

        if(board[0][0].getText().equals("X") && board[1][1].getText().equals("X") && board[2][2].getText().equals("X")){
            resultLabel.setText(result);

            resultDialog.setVisible(true);

            xScore++;
        }

        if(board[2][0].getText().equals("X") && board[1][1].getText().equals("X") && board[0][2].getText().equals("X")) {
            resultLabel.setText(result);

            resultDialog.setVisible(true);

            xScore++;
        }
    }

    private void checkOWin(){
        String result = "O wins!";

        for(int row = 0; row < board.length; row++){
            if(board[row][0].getText().equals("O") && board[row][1].getText().equals("O") && board[row][2].getText().equals("O")){
                resultLabel.setText(result);

                resultDialog.setVisible(true);

                oScore++;
            }
        }

        for(int col = 0; col < board.length; col++){
            if(board[0][col].getText().equals("O") && board[1][col].getText().equals("O") && board[2][col].getText().equals("O")){
                resultLabel.setText(result);

                resultDialog.setVisible(true);

                oScore++;
            }
        }

        if(board[0][0].getText().equals("O") && board[1][1].getText().equals("O") && board[2][2].getText().equals("O")){
            resultLabel.setText(result);

            resultDialog.setVisible(true);

            oScore++;
        }

        if(board[2][0].getText().equals("O") && board[1][1].getText().equals("O") && board[0][2].getText().equals("O")) {
            resultLabel.setText(result);

            resultDialog.setVisible(true);

            oScore++;
        }
    }

    private void checkDraw(){
        if(moveCounter >= 9){
            resultLabel.setText("Draw!");
            resultDialog.setVisible(true);
        }
    }

    private void resetGame(){
        isPlayerOne = true;
        turnLabel.setText(X_LABEL);
        turnLabel.setBackground(X_COLOR);

        scoreLabel.setText(SCORE_LABEL);

        moveCounter = 0;

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                board[i][j].setText("");
            }
        }
    }
}
