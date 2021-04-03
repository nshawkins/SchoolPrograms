import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.awt.Color;

public class RedBlue {
    public static void main(String[] args) throws FileNotFoundException { 
        String file_name = "purple/" + args[0] + ".txt";
        Scanner sc = new Scanner(new File(file_name));

        String file_result = "purple/" + args[0] + args[1] + ".txt";
        Scanner sc_result = new Scanner(new File(file_result));
        String line = sc_result.nextLine();

        double xmin = sc.nextDouble();
        double ymin = sc.nextDouble();
        double xmax = sc.nextDouble();
        double ymax = sc.nextDouble();

        StdDraw.setXscale(xmin, xmax);
        StdDraw.setYscale(ymin, ymax);

        int num_subregions = sc.nextInt();

        String subregion, region;
        int i = 0;
        int j = 0;
        int num_coordinates;

            subregion = sc.nextLine();
            region = sc.nextLine();

            int num_points = sc.nextInt();
            double[] lats;
            double[] longs;
        
        while (i++ < num_subregions && sc.hasNext()) {
            sc.nextLine();
            sc.nextLine();
            subregion = sc.nextLine();
            region = sc.nextLine();
            
            num_coordinates = sc.nextInt();

            longs = new double[num_coordinates];
            lats = new double[num_coordinates];
            
            for (j = 0; j < num_points; j++) {
                longs[j] = sc.nextDouble();
                lats[j] = sc.nextDouble();
                }
            
            Color red = new Color(255, 0, 0);
            Color blue = new Color(0, 0, 255);
            String[] array = line.split(",");
           
            while ((!(array[0].equals(subregion))) && sc_result.hasNextLine()) {
                sc_result.nextLine();
                array = line.split(",");
                int column1 = Integer.parseInt(array[1]);
                int column2 = Integer.parseInt(array[2]);
                if (column1 > column2) {
                    StdDraw.setPenColor(red); // sets color to red
                }
                else {
                    StdDraw.setPenColor(blue); // sets color to blue
                }
                break;
            }
            StdDraw.filledPolygon(longs, lats);
        }
    }
}
