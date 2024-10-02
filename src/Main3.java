public class Main3 {
    public static void main(String[] args) {
        
        Drib fraction1 = new Drib(1, 2); 
        Drib fraction2 = new Drib(3, 4);
        
        System.out.println("Дроби:");
        System.out.println("Fraction 1: " + fraction1);
        System.out.println("Fraction 2: " + fraction2);

        Drib sum = fraction1.add(fraction2);
        System.out.println("Сума: " + sum);

        Drib difference = fraction1.subtract(fraction2);
        System.out.println("Piзниця: " + difference);

        Drib product = fraction1.multiply(fraction2);
        System.out.println("Добуток: " + product);

        Drib quotient = fraction1.divide(fraction2);
        System.out.println("Частка: " + quotient);

        System.out.println("Kiлькicть створених дpoбiв: " + Drib.getCount());

        System.out.println("Fraction 1 дopiвнює Fraction 2: " + fraction1.equals(fraction2));
    }
}
