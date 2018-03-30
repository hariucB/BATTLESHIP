import java.awt.*;

public class Ship {
    public int x;
    public int y;
    public int xDirection, yDirection; //unde se misca nava
    int direction; //1 -up, 2- down
    boolean shot;
    Rectangle bullet;
    int score, hp;
    int bx, by; //pt bullet;


    public Ship(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    public void move() {
        x += xDirection;
        y += yDirection;

        //Collision detection
        if (x <= 10) {
            x = 10;
        }
        if (x >= 415) {
            x = 415;
        }
        if (y <= 30)
        {
            y = 30;
        }
        if (y >= 450)
        {
            y = 450;
        }
    }
    public void shoot() {
        if (shot == true)
        {
            if(direction == 1)
            by = by - 2;
            else if(direction == 2)
                by = by + 2;
        }
       if (shot == false)
        {
            if(direction == 1)
            {
                bx = x + 25;
                by = y - 10;
            }
            else if(direction == 2)
            {
                bx = x + 25;
                by = y + 20;
            }
        }
        //resetung values
        if (by <= -5) {
            if (direction == 1) {
                bx = x + 25;
                by = y - 10;
                bullet = new Rectangle(bx, by, 10, 10);
                shot = false;
            }
        }
        if(by >= 465)
            if (direction == 2)
            {
                bx = x + 25;
                by = y + 20;
                bullet = new Rectangle(bx, by, 10, 10);
                shot = false;
            }
    }

    public void PaintMyShip(Graphics g)
    {
        //nava mea
        bullet = new Rectangle(bx, by, 10, 10);
        g.setColor(Color.WHITE);
        g.fillRect(x,y,60,20);

        if(direction == 1)
        g.fillRect(x+25,y-10, 10, 10);
        else if (direction == 2)
            g.fillRect(x+25, y+20, 10, 10);

        if(shot == true)
        {
            g.setColor(Color.BLACK);
            g.fillRect(bx, by, bullet.width, bullet.height);
        }
       // repaint();
    }




}
