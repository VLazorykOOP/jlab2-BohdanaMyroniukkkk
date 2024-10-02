public class Line {
    private double a, b, c;
    private static int lineCount = 0;

    public Line(double a, double b, double c) { 
        this.a = a;
        this.b = b;
        this.c = c;
        lineCount++;
    }

    public Line() { 
        this(1, -1, 0);
    }

    @Override
    public String toString() {
        return String.format("%.0fx + %.0fy + %.0f = 0", a, b, c);
    }

    public boolean isPointOnLine(double x, double y) {
        return a * x + b * y + c == 0;
    }

    public double[] intersection(Line other) {
        double denominator = a * other.b - b * other.a;
        if (denominator == 0) {
            return null;
        }
        double x = (b * other.c - c * other.b) / denominator;
        double y = (c * other.a - a * other.c) / denominator;
        return new double[]{x, y};
    }

    public boolean equals(Line other) {
        return (a == other.a && b == other.b && c == other.c);
    }

    public static int getLineCount() {
        return lineCount;
    }
}
