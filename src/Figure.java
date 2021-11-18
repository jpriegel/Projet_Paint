import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

public abstract class Figure implements Serializable  {

    protected abstract void setBoundingBox (int widthBB, int heightBB);
    protected abstract void setBoundingBox(Point a, Point b);
    protected abstract void draw (Graphics g);
    private Color c;
    protected Point start;
    protected int minX;
    protected int minY;



    public Figure(Point p, Color c){
        start=p;
        this.c=c;
    }

    public Figure() {
        c = new Color(255,255,255);
        start = new Point(0, 0);
    }

    //GETTER:
    public Color getC(){return c;}
    public Point getStart(){return start;}

    //SETTER
    public void setStart(Point start) {
        this.start = start;
    }


    public void setC(Color c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "[ Color: "+getC() +" | Start : " + getStart()+" ]";
    }
}
