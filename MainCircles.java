import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainCircles extends JFrame {
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainCircles();
            }
        });
    }

    Sprite[] sprites = new Sprite[10];
    Sprite[] mouseSprites = new Sprite[5];

    private MainCircles() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        GameCanvas canvas = new GameCanvas(this);
        add(canvas, BorderLayout.CENTER);
        initApplication();
        setTitle("Circles");
        setVisible(true);
        addMouseListener(new MouseListener() {
            int count = 0;
            @Override
            public void mouseClicked(MouseEvent e) {
                // часть с удалением не работает.
               /* if (e.getButton() == MouseEvent.BUTTON3) {
                    for (int i = mouseSprites.length; i <= 0; i--){
                        if (mouseSprites[i] != null) {
                            mouseSprites[i] = null;
                            break;
                        }
                    }
                }*/
            if (e.getButton() == MouseEvent.BUTTON1 && count < mouseSprites.length) {
                mouseSprites[count] = new Ball();
                count++;
                } else if (count >= mouseSprites.length) JOptionPane.showMessageDialog(null," допустимо 5 новых шариков");

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    private void initApplication() {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i] = new Ball();
        }
    }

    public void onDrawFrame(GameCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
        setBackGround(canvas);
    }

    private void update(GameCanvas canvas, float deltaTime) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].update(canvas, deltaTime);
        }
        for (int i = 0; i < mouseSprites.length; i++){
            if (mouseSprites[i] != null){
                mouseSprites[i].update(canvas, deltaTime);
            }
        }
    }

    private void render(GameCanvas canvas, Graphics g) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].render(canvas, g);
        }
        for (int i = 0; i < mouseSprites.length; i++){
            if (mouseSprites[i] != null){
                mouseSprites[i].render(canvas, g);
            }
        }
    }

    public void setBackGround(GameCanvas canvas){
    new BackGround().setBackGround(canvas);
    }
}
