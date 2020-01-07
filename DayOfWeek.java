public class DayOfWeek{
  public static void main(String[] args){
    String month = args[0];
    String day = args[1];
    String year = args[2];
    int m = Integer.parseInt(month);
    int d = Integer.parseInt(day);
    int y = Integer.parseInt(year);

    int y0 = y - (14 - m) / 12;
    int x = y0 + y0/4 - y0/100 + y0/400;
    int m0 = m + 12 * ((14-m) / 12) - 2;
    int d0 = (d + x +(31 * m0) / 12);
    int ans = d0 % 7;

    System.out.println("" + m + " " + d + " " + y + " falls on " + ans);
  }
}
