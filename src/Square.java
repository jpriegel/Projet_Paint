import java.awt.Color;
import java.awt.Graphics;

public class Square extends Rectangle {
    protected int coté;

    public Square(int px, int py, Color c) {
        super(px, py, c);
        setBoundingBox(0, 0);
    }


    @Override
    public void setBoundingBox(int widthBB, int heightBB) {
        super.setBoundingBox(widthBB, heightBB);
        if (widthBB < heightBB) {
            longueur = widthBB;
            largeur = widthBB;
        } else {
            longueur = heightBB;
            largeur = heightBB;
        }
    }

    @Override
    protected void setBoundingBox(Point start, Point end) {
        minX = Math.min(start.getX(), end.getX());
        minY = Math.min(start.getY(), end.getY());
        longueur = Math.abs(end.getX() - start.getX());
        largeur = Math.abs(end.getY() - start.getY());
        coté = largeur;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getC());
        g.drawRect(minX, minY, coté, coté);
        g.fillRect(minX, minY, coté, coté);
    }

    @Override
    public String toString() {
        return "square [side=" + coté + " | origin:" + getStart() + "]";
    }
}
