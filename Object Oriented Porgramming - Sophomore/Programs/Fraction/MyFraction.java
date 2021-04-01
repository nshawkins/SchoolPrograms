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
        numberator = 0;
        denominator = 1;
    }


    // Create a constructor that accepts two parameters
    // for the numerator and denominator. When the constructor
    // is used, the whole number value is 0.
    public Fraction(int numerator, int denominator)
    {   
        this.numerator = numerator;
        this.denominator = denominator;
    }


    // Create a constructor that accepts three parameters
    // for the whole number, numerator, and denominator.
    public Fraction(int whole, int numerator, int denominator)
    {
        this.whole = whole;
        this.numerator = numerator;
        this.denominator = denominator;
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
        gcd(numerator, denominator);
        if (numerator > denominator){
            whole = numerator / denominator;
            remainder = numerator % denominator;
            remainder = numerator;
        }
    }

    // Add the current Fraction to Fraction A, return the result as a new Fraction (reduced, of course)
    public Fraction add(Fraction A)
    {
           
    }

    // Fraction C = this - A;
    // Subtract the current Fraction Fraction A, return the result as a new Fraction (reduced, of course)
    public Fraction substract(Fraction A)
    {

    }

    // Multiply the current Fraction to Fraction A, return the result as a new Fraction (reduced, of course)
    public Fraction multiply(Fraction A)
    {

    }

    // Divide Fractions (this/A), return the result as a new Fraction (reduced, of course)
    // You may assume that A will be a non-zero value
    public Fraction divide(Fraction A)
    {

    }

    // raturns a string that contains a fraction in the format:
    // whole number, a space, the numerator, a slash (/), and a denominator (e.g: 2 3/4).
    // When the whole number is 0, just display the fraction part (e.g: 1/2 instead of 0 1/2.
    // When the numerator is 0, just display the whole number (e.g: 2 instead of 2 0/3).
    // Also, just display 3 instead of 3/1.
    public string toString()
    {
        if (denominator == 1 || numerator == 0){
            String result = whole;
        }
        else if (whole = 0){
            String result = numerator + "/" + denominator;
        }
        else {
            String result = whole + numerator + "/" + denominator;
        }
    }
}