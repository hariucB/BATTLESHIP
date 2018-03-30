import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

import java.awt.image.ImageObserver;


public class Draw extends JFrame implements Runnable,ImageObserver {

    Image dbImage;
    Graphics dbGraphics;

    //create Ship - nava mea
    Ship S = new Ship(200, 465);
    RandomShip G = new RandomShip();
    public void run() {
        try {
            while (true) {
                S.move();
                G.move(S);
                G.shoot(S);
                S.shoot();
                Thread.sleep(7);
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

   public Draw()
   {
       super("BattleShip Game");
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setVisible(true);
       setSize(500,500);
       setLocationRelativeTo(null);
       setResizable(false);
       addKeyListener(new AL());
       setBackground(Color.CYAN);
   }


    public void paint(Graphics g)
    {
        dbImage = createImage(getWidth(), getHeight());
        dbGraphics = dbImage.getGraphics();
        G.PaintRandomShip(dbGraphics);
        S.PaintMyShip(dbGraphics);

        repaint();
        g.drawImage(dbImage, 0, 0,  this);

    }

    public class AL extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if (key == e.VK_LEFT) {
                S.xDirection = -2;
            }
            if (key == e.VK_RIGHT) {
                S.xDirection = 2;
            }
            if (key == e.VK_DOWN) {
                S.yDirection = 2;
                S.direction = 2;
            }
            if (key == e.VK_UP) {
                S.yDirection = -2;
                S.direction = 1;
            }
            if (key == e.VK_SPACE) {
                S.shot = true;
            }
        }

        public void keyReleased(KeyEvent e) {
            int keyCode = e.getKeyCode();
            if (keyCode == e.VK_LEFT) {
                S.xDirection = 0;
            }
            if (keyCode == e.VK_RIGHT) {
                S.xDirection = 0;
            }
            if (keyCode == e.VK_DOWN) {
                S.yDirection = 0;
            }
            if (keyCode == e.VK_UP) {
                S.yDirection = 0;
            }
            if (keyCode == e.VK_SPACE) {
                if(S.direction == 1)
                {
                    S.bx = S.x + 25;
                    S.by = S.y - 10;
                }
                else if(S.direction == 2)
                {
                    S.bx = S.x + 25;
                    S.by = S.y + 20;
                }
                S.shot = false;
            }
        }
    }
}
