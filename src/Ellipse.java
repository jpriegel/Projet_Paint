import java.awt.Color;
import java.awt.Graphics;

public class Ellipse extends Figure {
    protected int gaxe;
    protected int paxe;

    public Ellipse(int px, int py, Color c) {
        super(new Point(px, py), c);
        setBoundingBox(0, 0);
    }

    @Override
    public void setBoundingBox(int widthBB, int heightBB) {
        this.gaxe = widthBB;
        this.paxe = heightBB;
    }

    @Override
    protected void setBoundingBox(Point start, Point end) {
        minX = Math.min(start.getX(), end.getX());
        minY = Math.min(start.getY(), end.getY());
        gaxe = Math.abs(end.getX() - start.getX());
        paxe = Math.abs(end.getY() - start.getY());

    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getC());
        g.drawOval(minX, minY, gaxe, paxe);
        g.fillOval(minX, minY, gaxe, paxe);
    }

    @Override
    public String toString() {
        return "Ellipse [semi-major axis=" + gaxe + " | semi-minor axis=" + paxe + " | Origin:" + getStart() + "]\n";
    }
}
