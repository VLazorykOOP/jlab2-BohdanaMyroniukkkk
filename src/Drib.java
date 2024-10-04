public class Drib { 
    private int numerator; 
    private int denominator; 
    private static int count = 0; 

    public Drib(int numerator, int denominator) throw IllegalArgumentException { 
        if (denominator == 0) { 
            throw new IllegalArgumentException("Знаменник не може бути нулем."); 
        }
        this.numerator = numerator; 
        this.denominator = denominator; 
        count++; 
        reduce(); 
    }

    private void reduce() { 
        int gcd = gcd(numerator, denominator); 
        numerator /= gcd; 
        denominator /= gcd; 
    }

    private int gcd(int a, int b) { 
        return b == 0 ? a : gcd(b, a % b); 
    }

    public Drib add(Drib other) { 
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator; 
        int newDenominator = this.denominator * other.denominator; 
        return new Drib(newNumerator, newDenominator); 
    }

    public Drib subtract(Drib other) { 
        int newNumerator = this.numerator * other.denominator - other.numerator * this.denominator; 
        int newDenominator = this.denominator * other.denominator; 
        return new Drib(newNumerator, newDenominator); 
    }

    public Drib multiply(Drib other) { 
        int newNumerator = this.numerator * other.numerator; 
        int newDenominator = this.denominator * other.denominator; 
        return new Drib(newNumerator, newDenominator); 
    }

    public Drib divide(Drib other) { 
        if (other.numerator == 0) { 
            throw new IllegalArgumentException("Ділення на нуль не можливе."); 
        }
        int newNumerator = this.numerator * other.denominator; 
        int newDenominator = this.denominator * other.numerator; 
        return new Drib(newNumerator, newDenominator); 
    }

    public static int getCount() { 
        return count; 
    }

    @Override
    public String toString() { 
        return numerator + "/" + denominator; 
    }

    @Override
    public boolean equals(Object obj) { 
        if (this == obj) return true; 
        if (obj == null || getClass() != obj.getClass()) return false; 
        Drib other = (Drib) obj; 
        return this.numerator == other.numerator && this.denominator == other.denominator; 
    }
}
