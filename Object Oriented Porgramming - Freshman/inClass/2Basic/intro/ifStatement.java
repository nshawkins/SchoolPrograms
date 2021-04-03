public class Example5 {
  public static void main(String[] args){
    if (x > 0){
      x *= -1;
      y += 2;
    }

    double rate = .22;

    if (income > 311950)
      rate = 0.35;

    else if (income > 174700)
      rate = 0.33;

    else if (income > 114650)
      rate = 0.28;

    else if (income > 47450)
      rate = 0.25;

    else if (income > 0)
      rate = 0.22;
  }
}
