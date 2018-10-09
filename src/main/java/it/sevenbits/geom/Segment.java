package it.sevenbits.geom;

public class Segment {
    private Point a, b;

    public Segment(Point a, Point b) {
        this.a = a;
        this.b = b;
    }

    public Segment(int x0, int y0, int x1, int y1) {
        this.a = new Point(x0, y0);
        this.b = new Point(x1, y1);
    }

    public Point getA() {
        return a;
    }

    public Point getB() {
        return b;
    }

    public double getLength() {
        double dx = a.getX() - b.getX();
        double dy = a.getY() - b.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }
}
