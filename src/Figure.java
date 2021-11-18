import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

public abstract class Figure implements Serializable {
    protected Point start;
    protected int minX;
    protected int minY;
    private Color c;

    public Figure(Point p, Color c) {
        start = p;
        this.c = c;
    }

    protected abstract void setBoundingBox(int widthBB, int heightBB);

    protected abstract void setBoundingBox(Point a, Point b);

    protected abstract void draw(Graphics g);

    //GETTER:
    public Color getC() {
        return c;
    }

    public void setC(Color c) {
        this.c = c;
    }

    public Point getStart() {
        return start;
    }

    //SETTER
    public void setStart(Point start) {
        this.start = start;
    }

    @Override
    public String toString() {
        return "[ Color: " + getC() + " | Start : " + getStart() + " ]";
    }
}
