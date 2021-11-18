import java.awt.Color;
import java.awt.Graphics;

public class Ellipse extends Figure {
    protected int gaxe;
    protected int paxe;

    public Ellipse(int px, int py, Color c) {super(new Point(px,py),c);
    setBoundingBox(0,0);
    }

    @Override
    public void setBoundingBox(int widthBB, int heightBB){
        this.gaxe=widthBB;
        this.paxe=heightBB;
    }

    @Override
    protected void setBoundingBox(Point start, Point end) {
        minX = Math.min(start.getX(), end.getX());
        minY = Math.min(start.getY(), end.getY());
        gaxe = Math.abs(end.getX() - start.getX());
        paxe = Math.abs(end.getY() - start.getY());

    }

    /* @Override
        protected void setBoundingBox(Point start, Point end) {
            if (start.getX() < end.getX() & start.getY() < end.getY()) {
                gaxe = (end.getX() - start.getX()) / 2;
                paxe = (end.getY() - start.getY()) / 2;
            }
            else if (start.getX() < end.getX() & end.getY() < start.getX()) {
                Point originBis = new Point(start.getX(), end.getY());
                Point secondBis = new Point(end.getX(), start.getY());
                super.start = originBis;
                gaxe = (secondBis.getX() - originBis.getX()) / 2;
                paxe = (secondBis.getY() - originBis.getY()) / 2;
            }
            else if (end.getX() < start.getX() & start.getY() < end.getY()) {
                Point originBis = new Point(end.getX(), start.getY());
                Point secondBis = new Point(start.getX(), end.getY());
                super.start = originBis;
                gaxe = (secondBis.getX() - originBis.getX()) / 2;
                paxe = (secondBis.getY() - originBis.getY()) / 2;
            }
            else if (end.getX() < start.getX() & end.getY() < start.getY()) {
                Point originBis = new Point(end.getX(), end.getY());
                Point secondBis = new Point(start.getX(), start.getY());
                super.start = originBis;
                gaxe = (secondBis.getX() - originBis.getX()) / 2;
                paxe = (secondBis.getY() - originBis.getY()) / 2;
            }
        }*/
    @Override
    public void draw(Graphics g) {
       g.setColor(getC());
       //g.fillOval(origin.getX(), origin.getY(), semiAxisX * 2, semiAxisY * 2);
        g.drawOval(minX, minY, gaxe, paxe);
        g.fillOval(minX, minY, gaxe, paxe);
    }

    @Override
    public String toString() {
        return "Ellipse [semi-major axis=" + gaxe + " | semi-minor axis=" + paxe + " | Origin:" + getStart()+"]\n";
    }
}
