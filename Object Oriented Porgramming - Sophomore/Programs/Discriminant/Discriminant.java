import java.lang.Math;
public class Discriminant{
  public static void main(String[] args){
    String b0 = args[0];
    String c0 = args[1];
    String d0 = args[2];
    double b = Double.parseDouble(b0);
    double c = Double.parseDouble(c0);
    double d = Double.parseDouble(d0);

    double ans = Math.pow(b,2) * Math.pow(c,2) - (4 * Math.pow(c,3)) -  4 * (Math.pow(b,3) * d);
    double ans2 =ans - (27 * Math.pow(d,2)) + 18 * (b * c * d);

    System.out.printf("The discriminant of the polynomial x^3 + -100.00x^2 + -2.50x + 90.00 is %.2f",ans2);
  }
}
