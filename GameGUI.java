import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameGUI extends JFrame {
    private JLabel backgroundLabel;
    private JLabel characterLabel;
    private JLabel textLabel;
    private int characterX;
    private int characterY;
    public GameGUI(){
        setTitle("Game Zombie"); //judul
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //klo window ditutup, jframe jg ikut ditutup
        setSize(800, 600);
        setLocationRelativeTo(null); //window di tengah layar
        setResizable(false); //apakah bisa diubah ukurannya

        // masukkan image ke label > setbounds label > add label to jfram
        ImageIcon backgroundImage = new ImageIcon("asset/background.jpg");
        backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, 775, 600);
        add(backgroundLabel);

        ImageIcon characterImage = new ImageIcon("asset/character.png");
        characterLabel = new JLabel(characterImage);
        characterLabel.setBounds(475, 100, 300, 300);
        backgroundLabel.add(characterLabel);

        textLabel = new JLabel("Hello, welcome to my game!");
        textLabel.setFont(new Font("Arial", Font.BOLD, 24));
        textLabel.setForeground(Color.BLACK);
        textLabel.setBounds(100, 200, 400, 30);
        backgroundLabel.add(textLabel);

        characterX = 475;
        characterY = 100;

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                int keycode = e.getKeyCode();
                switch (keycode){
                    case KeyEvent.VK_W :
                        characterY -= 10;
                        break;
                    case KeyEvent.VK_S :
                        characterY += 10;
                        break;
                    case KeyEvent.VK_A :
                        characterX -= 10;
                        break;
                    case KeyEvent.VK_D :
                        characterX += 10;
                        break;
                    default:
                        break;
                }
                characterLabel.setLocation(characterX, characterY);
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });

        setVisible(true); //untuk menampilkan window
    }
}
