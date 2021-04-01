import java.util.*;

public class Tester
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a PGM file name to read: ");
        String file = sc.nextLine();

        PGM PGMImage = new PGM (file);
        PGMImage.flip_vertically ();
        PGMImage.save("vert.pgm");

        PGM PGMImage2 = new PGM (file);
        PGMImage.flip_horizontally ();
        PGMImage.save("horiz.pgm");

        PGM PGMImage3 = new PGM (file);
        PGMImage.rotate_right_90 ();
        PGMImage.save("r90.pgm");
    }
}