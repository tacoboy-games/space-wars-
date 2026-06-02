
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SpaceWar extends JPanel implements ActionListener, KeyListener {
    int heroX = 400, heroY = 500;
    boolean left, right, up, down;

    Timer timer = new Timer(16, this);

    public SpaceWar() {
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (left) heroX -= 5;
        if (right) heroX += 5;
        if (up) heroY -= 5;
        if (down) heroY += 5;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.WHITE);
        g.drawString("Space War (Java conversion starter)", 10, 20);

        g.setColor(Color.GREEN);
        g.fillRect(heroX, heroY, 40, 40);
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) left = true;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) right = true;
        if (e.getKeyCode() == KeyEvent.VK_UP) up = true;
        if (e.getKeyCode() == KeyEvent.VK_DOWN) down = true;
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) left = false;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) right = false;
        if (e.getKeyCode() == KeyEvent.VK_UP) up = false;
        if (e.getKeyCode() == KeyEvent.VK_DOWN) down = false;
    }

    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Space War");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new SpaceWar());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
