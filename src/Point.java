public class Point {
    private int X;
    private int Y;

    public Point(int X, int Y) {
        this.X = X;
        this.Y = Y;
    }

    @Override
    public String toString() {
        return "(" + this.X + ',' + this.Y + ")";
    }

    //GETTER:
    public int getX() {
        return X;
    }

    //SETTER:
    public void setX(int X) {
        this.X = X;
    }

    public int getY() {
        return Y;
    }

    public void setY(int Y) {
        this.Y = Y;
    }
}
