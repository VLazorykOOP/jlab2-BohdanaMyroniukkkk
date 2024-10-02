public class Main2 {
    public static void main(String[] args) {
        Line line1 = new Line(2, -3, 1);
        Line line2 = new Line();

        System.out.println("Line 1: " + line1);
        System.out.println("Line 2: " + line2);

        double x = 1, y = 1;
        System.out.println("Точка (" + x + ", " + y + ") належить лiнiї 1: " + line1.isPointOnLine(x, y));

        double[] intersection = line1.intersection(line2);
        if (intersection != null) {
            System.out.println("Точка перетину лiнiї 1 i лiнiї 2: (" + intersection[0] + ", " + intersection[1] + ")");
        } else {
            System.out.println("Лінії паралельні i не перетинаються.");
        }

        System.out.println("Лiнiя 1 дорiвнює лiнiї 2: " + line1.equals(line2));

        System.out.println("Кiлькiсть створених лiнiй: " + Line.getLineCount());
    }
}

