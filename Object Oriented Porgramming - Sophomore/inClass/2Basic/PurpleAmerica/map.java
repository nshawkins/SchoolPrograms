import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class map{
  public static void main(String[] args) throws FileNotFoundException {
    String file_name = "purple/" + args[0] + ".txt";
    File input = new File(file_name);
    Scanner sc = new Scanner(input);

    //read minimum long/lat
    double xmin = sc.nextDouble();
    double ymin = sc.nextDouble();

    //reading max long/lat
    double xmax = sc.nextDouble();
    double ymax = sc.nextDouble();

    StdDraw.setXscale(xmin, xmax);
    StdDraw.setYscale(ymin, ymax);

    //reading number of sub-regions (counties)
    int num_subregions = sc.nextInt();

    System.out.println("xmin/ymin: " + xmin + " / " + ymin);
    System.out.println("xmax/ymax: " + xmax + " / " + ymax);
    System.out.println("Subregions: " + num_subregions);

    for (int i = 0; i < num_subregions; i++){

      String junk = sc.nextLine(); //skipping the new line after double
      String space = sc.nextLine(); //consumes blank line
      // read Subregion name
      String subregion = sc.nextLine();
      String region = sc.nextLine();

      int num_points = sc.nextInt();
      double [] lats = new double[num_points];
      double [] longs = new double[num_points];
      for (int j = 0; j < num_points; j++){
        longs[j] = sc.nextDouble();
        lats[j] = sc.nextDouble();
      }
      StdDraw.polygon(longs, lats);
    }
  }
}
