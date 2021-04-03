import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.awt.Color;

public class RedAndBlue{
  public static void main(String[] args) throws FileNotFoundException {
    String file_name = "purple/" + args[0] + args[1] + ".txt";
    File input = new File(file_name);
    Scanner sc = new Scanner(input);

    String file_result = "purple/" + args[0] + args[1] + ".txt";
    Scanner sc_result = new Scanner(new File(file_result));
    String line = sc_result.nextLine();
    //read minimum long/lat
    double xmin = sc.nextDouble();
    double ymin = sc.nextDouble();

    //reading max long/lat
    double xmax = sc.nextDouble();
    double ymax = sc.nextDouble();

    StdDraw.setCanvasSize(650, 512);
    StdDraw.setXscale(xmin, xmax);
    StdDraw.setYscale(ymin, ymax);

    //reading number of sub-regions (counties)
    int num_subregions = sc.nextInt();

    /*System.out.println("xmin/ymin: " + xmin + " / " + ymin);
    System.out.println("xmax/ymax: " + xmax + " / " + ymax);
    System.out.println("Subregions: " + num_subregions);*/

    String subregion, region;
    int i = 0;
    int j = 0;
    int num_coordinates;

      subregion = sc.nextLine();
      region = sc.nextLine();

      double [] longs;
      double [] lats;

      int num_points = sc.nextInt();
      while (i++ < num_subregions && sc.hasNext()){
        sc.nextLine();
        sc.nextLine();
        subregion = sc.nextLine();
        region = sc.nextLine();

        num_coordinates = sc.nextInt();
        lats = new double[num_coordinates];
        longs = new double[num_coordinates];

        for (j = 0; j < num_points; j++){
          longs[j] = sc.nextDouble();
          lats[j] = sc.nextDouble();
        }

        Color red = new Color(255, 0, 0);
        Color blue = new Color(0, 0, 255);

        String [] array = line.split(",");
        while (!(array[0].equals(subregion)) && sc_result.hasNextLine()){
          int column1 = Integer.parseInt(array[1]);
          int column2 = Integer.parseInt(array[2]);
          if (column1 > column2) {
            StdDraw.setPenColor(StdDraw.RED); //sets color to red
          }
          else {
            StdDraw.setPenColor(StdDraw.BLUE);
          }
          break;
        }
        StdDraw.filledPolygon(longs, lats);

      }
    }
  }
