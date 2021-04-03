public class Fraction
{
    private int whole;
    private int numerator;
    private int denominator;


    // Create a paramaterless constructor, which sets
    // the whole number and numerator to 0 and the denominator to 1.
    public Fraction()
    {
        whole = 0;
        numerator = 0;
        denominator = 1;
       
    }


    // Create a constructor that accepts two parameters
    // for the numerator and denominator. When the constructor
    // is used, the whole number value is 0.
    public Fraction(int numerator, int denominator)
    {
        this.numerator = numerator;
        this.denominator = denominator;
        whole = 0;
        
    }


    // Create a constructor that accepts three parameters
    // for the whole number, numerator, and denominator.
    public Fraction(int whole, int numerator, int denominator)
    {
        this.whole = 0;
        this.numerator = numerator;
        this.denominator = denominator;
        if(whole < 0){
            this.numerator = -this.numerator;
        }
        this.numerator += (whole * denominator);

    }

    // This calculates greatest common divisor (GCD)
    // I expect that you will find it useful
    int gcd(int a, int b)
    {
        if( b == 0 )
            return a;
        return gcd(b,a%b);
    }

    // Reduces the Fraction value to the lowest possible denominator
    // example 72/20 should be reduced to 18/5, which is also 3 3/5.
    public void reduce()
    {
    int total = gcd(numerator, denominator);
    numerator = numerator/total;
    denominator = denominator/total;


    }

    // Add the current Fraction to Fraction A, return the result as a new Fraction (reduced, of course)
    public Fraction add(Fraction A)
    {
        Fraction F = new Fraction();
        F.denominator = denominator * A.denominator;
        F.numerator = (numerator * A.denominator) + (denominator * A.numerator);
        F.reduce();
        return F;
    }


    // Fraction C = this - A;
    // Subtract the current Fraction Fraction A, return the result as a new Fraction (reduced, of course)
    public Fraction substract(Fraction A)
    {
        Fraction F = new Fraction();
        F.denominator = denominator * A.denominator;
        F.numerator = (numerator * A.denominator) - (denominator * A.numerator);
        F.reduce();
        return F;

    }

    // Multiply the current Fraction to Fraction A, return the result as a new Fraction (reduced, of course)
    public Fraction multiply(Fraction A)
    {
        Fraction F = new Fraction();
        F.denominator = denominator * A.denominator;
        F.numerator = numerator * A.numerator;
        F.reduce();
        return F;

    }

    // Divide Fractions (this/A), return the result as a new Fraction (reduced, of course)
    // You may assume that A will be a non-zero value
    public Fraction divide(Fraction A)
    {
        Fraction F = new Fraction();
        F.denominator = denominator * A.numerator;
        F.numerator = numerator * A.denominator;

        F.reduce();
        return F;
    }

    // raturns a string that contains a fraction in the format:
    // whole number, a space, the numerator, a slash (/), and a denominator (e.g: 2 3/4).
    // When the whole number is 0, just display the fraction part (e.g: 1/2 instead of 0 1/2.
    // When the numerator is 0, just display the whole number (e.g: 2 instead of 2 0/3).
    // Also, just display 3 instead of 3/1.
    public String toString()
    {
        int numer = numerator % denominator;
        int wholenum = numerator / denominator;
        if(numer == 0){
            return "" + wholenum;
        }
        if(denominator == 1){
            return "" + wholenum;
        }
        if(wholenum == 0){
            if( denominator <0 && numer > 0){
                denominator = -denominator;
                numer = -numer;
            }
            return numer + "/" + denominator;
        }
        else{
            denominator = Math.abs(denominator);
            if(numer < 0){
                numer = -numer;
            }
            return wholenum + " " + numer + "/" + denominator;
        }

    }
}