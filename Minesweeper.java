import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.Timer;

public class Minesweeper{
    JFrame frame;
    JPanel panel;
    int [][] board = new int [10][10];
    JButton[][] button;
    ImageIcon icon;
    JButton restartButton;
    Timer timer;
    int seconds=0;
    JPanel topPanel;
    JLabel timerLabel;
    public Minesweeper(){
        frame= new JFrame("Minesweeper");
      frame.setSize(500,500);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLayout(new BorderLayout());
     
      icon = new ImageIcon("C:\\Users\\Lenovo\\Downloads\\bomb.png");
      frame.setIconImage(icon.getImage());

      topPanel= new JPanel();
      topPanel.setLayout(new GridLayout(1,2));
            
      panel = new JPanel();
      panel.setLayout(new GridLayout(10,10));
      
      restartButton = new JButton("Restart 🔁");
      restartButton.setBackground(Color.lightGray);
      restartButton.setForeground(Color.BLACK);
      restartButton.addActionListener(e->restartGame());
      
      timerLabel= new JLabel("Time: 0 seconds",JLabel.CENTER);
      timerLabel.setFont(new Font("Arial",Font.PLAIN,14));
      
        timer = new Timer(1000, e -> {
            seconds++;
            timerLabel.setText("Time: " + seconds + " seconds");
        });
        timer.start();

       
      button = new JButton[10][10];
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                button[row][col] = new JButton(); 
                button[row][col].setBackground(new Color(0,100,0));
                button[row][col].setFocusable(false);
                final int r = row;
                final int c = col;
                
              
                button[row][col].addActionListener(e -> checkMine(r, c));
             panel.add(button[row][col]);
          }

       }

     topPanel.add(restartButton);
     topPanel.add(timerLabel);
     frame.add(topPanel,BorderLayout.NORTH);
     frame.add(panel,BorderLayout.CENTER); 
     generateMines();
     frame.setLocationRelativeTo(null);
     frame.setVisible(true) ;
    }
     
    public void restartGame() {
       if (timer != null) {
        timer.stop();
      }
      seconds = 0;
      timerLabel.setText("Time: 0 seconds");

     for (int row = 0; row < 10; row++) {
        for (int col = 0; col < 10; col++) {
            board[row][col] = 0;
        }
    }

    
    for (int row = 0; row < 10; row++) {
        for (int col = 0; col < 10; col++) {
            button[row][col].setText("");
            button[row][col].setBackground(new Color(0,100,0)); 
            button[row][col].setForeground(Color.BLACK);
        }
    }
        timer = new Timer(1000, e -> {
        seconds++;
        timerLabel.setText("Time: " + seconds + " seconds");
        });
       timer.start();
    
        generateMines();
       }
    
      public void generateMines(){
        int placedMines=0;
         while(placedMines<10){
           int row= (int)(Math.random()*10);
           int col= (int)(Math.random()*10);

            if(board[row][col]==0){
                board[row][col]=1;
                placedMines++;
            }
         }
      }

     public void checkMine(int r, int c) {
        if(board[r][c]==1){
          timer.stop();
          button[r][c].setText("💣");
          button[r][c].setForeground(Color.BLACK);
          button[r][c].setBackground(Color.RED);
          JOptionPane.showMessageDialog(frame,"BOOM!" );
        }
        else{
        int count=0;
         for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                 int newRow= r+i;
                 int newCol= c+j;


                  if(newRow>=0 && newRow<=9 && newCol>=0 &&newCol<=9){
                      if(board[newRow][newCol]==1){
                        count++;

                      }

                  }
            }
          }
         button[r][c].setText(String.valueOf(count));
         button[r][c].setForeground(Color.BLACK);
         button[r][c].setBackground(new Color(152,251,152));
         }
          int openedCells = 0;
            for (int row = 0; row < 10; row++) {
                for (int col = 0; col < 10; col++) {
                    if (!button[row][col].getText().equals("") && !button[row][col].getText().equals("💣")) {
                        openedCells++;
                    }
                }
            }

            
            if (openedCells == 90) {
                timer.stop();
                JOptionPane.showMessageDialog(frame, "Congratulations you won the game in" + seconds + " seconds! 👑🏆");
            }
        }
    

     public static void main(String[] args){
       new Minesweeper();

    }

}