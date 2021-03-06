import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.awt.Color;

public class Purple {
    public static void main(String[] args) throws FileNotFoundException { // if unable to read, skips over
        String file_name = "purple/" + args[0] + ".txt";
        File input = new File(file_name); // directs to the file
        Scanner sc = new Scanner(input);

        // read minimum long/lat
        double xmin = sc.nextDouble();
        double ymin = sc.nextDouble();

        // read maximum long/lat
        double xmax = sc.nextDouble();
        double ymax = sc.nextDouble();

        StdDraw.setXscale(xmin, xmax);
        StdDraw.setYscale(ymin, ymax);

        // read number of subregions (state = counties / country = states)
        
        int num_subregions = sc.nextInt();

        System.out.println("xmin/ymin: " + xmin + "/" + ymin);
        System.out.println("xmax/ymax: " + xmax + "/" + ymax);
        System.out.println("Subregions: " + num_subregions);

        for (int i = 0; i < num_subregions; i++) {
            String junk = sc.nextLine(); // stripping the new line after double
            String space = sc.nextLine(); // stripping the empty line

            // read the subregion name
            String subregion = sc.nextLine();
            String region = sc.nextLine();

            int num_points = sc.nextInt();
            double[] lats = new double[num_points];
            double[] longs = new double[num_points];
            for (int j = 0; j < num_points; j++) {
                longs[j] = sc.nextDouble();
                lats[j] = sc.nextDouble();
            }
            double total = 18968 + 10122 + 569;
            int R = (int) (18968 / total * 255);
            int G = (int) (10122 / total * 255);
            int B = (int) (569 / total * 255);
            
            Color color = new Color(R, G, B);
            StdDraw.setPenColor(color);
            StdDraw.filledPolygon(longs, lats);
        }
    }
}