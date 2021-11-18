public class Point{
    private int X;
    private int Y;

    @Override public String toString() {
        return "("+ this.X + ',' + this.Y +")";
    }

    public Point(){
        X=0;
        Y=0;
    }

    public Point(int X, int Y){
        this.X=X;
        this.Y=Y;
    }

    //GETTER:
    public int getX(){return X;}
    public int getY() {return Y;}

    //SETTER:
    public void setX(int X){
        this.X=X;
    }
    public void setY(int Y){
        this.Y=Y;
    }
}
