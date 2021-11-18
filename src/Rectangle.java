import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Figure {
    protected int longueur;
    protected int largeur;

    public Rectangle(int px, int py, Color c) {
        super(new Point(px, py), c);
        setBoundingBox(0, 0);

    }

    @Override
    public void setBoundingBox(int widthBB, int heightBB) {
        this.longueur = widthBB;
        this.largeur = heightBB;
    }


    /* Cette partie du prgramme sert a construire le rectangle et le faire dans le cas ou l'on essaye
    d'etirer la figure vers --> en bas à droite
                            --> en bas à gauche
                            --> en haut à droite
                            --> en haut à gauche
    */
    @Override
    protected void setBoundingBox(Point start, Point end) {
        minX = Math.min(start.getX(), end.getX());
        minY = Math.min(start.getY(), end.getY());
        longueur = Math.abs(end.getX() - start.getX());
        largeur = Math.abs(end.getY() - start.getY());
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getC());
        g.drawRect(minX, minY, longueur, largeur);
        g.fillRect(minX, minY, longueur, largeur);
    }

    @Override
    public String toString() {
        return "Rectangle [length=" + longueur + " | width=" + largeur + " | origin:" + getStart() + "]";
    }


    @Override
    public Point getStart() {
        return super.getStart();
    }

    @Override
    public void setStart(Point start) {
        super.setStart(start);
    }

    @Override
    public Color getC() {
        return super.getC();
    }

    @Override
    public void setC(Color c) {
        super.setC(c);
    }
}
