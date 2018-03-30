import java.awt.*;
import java.awt.geom.Ellipse2D;

public class RandomShip {

    public int x;
    public int y;
    int direction; //1 -up, 2- down
    boolean shot;
    int score;
    int hp;
    Ellipse2D.Double bullet;
    int bx, by; //pt bullet;

    public RandomShip()
    {
        RandomCoordinateFactory RANDOM = new RandomCoordinateFactory();
        int xr = RANDOM.RandomX();
        int yr = RANDOM.RandomY();
        this.x = xr;
        this.y = yr;
    }
    public void PaintRandomShip(Graphics g)
    {
        bullet = new Ellipse2D.Double(bx, by, 10, 10);

        g.setColor(Color.BLACK);
        g.fillRect(x,y,60,20);
        if(direction == 1)
            g.fillRect(x+25,y-10, 10, 10);
        else if (direction == 2)
            g.fillRect(x+25, y+20, 10, 10);
        if(shot == true)
        {
            g.setColor(Color.BLACK);
            g.fillOval(bx, by, (int)bullet.width, (int)bullet.height);
        }

    }
    public void move( Ship S) //S-nava mea
    {
        if (this.x-S.x > 80)
        {
            x -= 1;
        }
        if (this.x-S.x < -80)
        {
            x += 1;
        }
        if(this.y-S.y > 100)
        {
            y -= 1;
            direction = 1;
        }
        if(this.y-S.y < -100)
        {
            y += 1;
            direction = 2;
        }
       // shot = false;

        if(Math.abs(this.y-S.y) < 100)
            shot = true;
    }
    void ResetValuesUP() {
        bx = x + 25;
        by = y - 10;
        bullet = new Ellipse2D.Double(bx, by, 10, 10);
        shot = false;
    }
    void ResetValuesDOWN(){
        bx = x + 25;
        by = y + 20;
        bullet = new Ellipse2D.Double(bx, by, 10, 10);
        shot = false;
    }
    public void shoot(Ship S)
    {
        if (shot == true) {
            if(direction == 1)
                by = by - 2;
            else if(direction == 2)
                by = by + 2;
        }

        if (shot == false) {
            if(direction == 1) {
                bx = x + 25;
                by = y - 10;
            }
            else if(direction == 2) {
                bx = x + 25;
                by = y + 20;
            }
        }
        //Resetting values
        if (by <= -5) {
            if (direction == 1) {
                ResetValuesUP();
            }
        }
        if(by >= 465)
            if (direction == 2) {
                ResetValuesDOWN();
            }
        }

    }

