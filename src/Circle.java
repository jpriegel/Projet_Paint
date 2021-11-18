import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Ellipse {
    private int rayon;

    public Circle(int px, int py, Color c) {
        super(px, py, c);
    }

    @Override
    public void setBoundingBox(int widthBB, int heightBB) {
        super.setBoundingBox(heightBB, widthBB);
        if (heightBB < widthBB) {
            gaxe = heightBB / 2;
            paxe = heightBB / 2;
            rayon = paxe;
        }
        else {
            gaxe = widthBB / 2;
            paxe = widthBB / 2;
            rayon = paxe;
        }
    }

    @Override
    protected void setBoundingBox(Point start, Point end) {
        minX = Math.min(start.getX(), end.getX());
        minY = Math.min(start.getY(), end.getY());
        gaxe = Math.abs(end.getX() - start.getX());
        paxe = Math.abs(end.getY() - start.getY());
        rayon= paxe;

    }

    /*
        @Override
        protected void setBoundingBox(Point origin, Point second) {
            super.setBoundingBox(origin, second);
            if (gaxe < paxe) {
                rayon = paxe = gaxe;

                if (origin.getX() < second.getX() & second.getY() < origin.getY()) { // tire en haut à droite
                    super.start.setY(origin.getY() - rayon * 2);

                } else if (second.getX() < origin.getX() & second.getY() < origin.getY()) { // tire en haut à gauche
                    super.start.setY(origin.getY() - rayon * 2);
                }
            } else {
                rayon = gaxe = paxe;

                if (second.getX() < origin.getX() & origin.getY() < second.getY()) { // Tire en bas a à gauche
                    super.start.setX(origin.getX() - rayon * 2);
                } else if (second.getX() < origin.getX() & second.getY() < origin.getY()) { // tire en haut à gauche
                    super.start.setX(origin.getX() - rayon * 2);
                }
            }
        }

    */
    @Override
    public void draw(Graphics g) {
        g.setColor(getC());
        //g.fillOval(origin.getX(), origin.getY(), semiAxisX * 2, semiAxisY * 2);
        g.drawOval(minX, minY, rayon, rayon);
        g.fillOval(minX, minY, rayon, rayon);
    }

    @Override
    public String toString() {
        return " Circle [radius=" + rayon + " | Origin=" + getStart() + "]";
    }
}
