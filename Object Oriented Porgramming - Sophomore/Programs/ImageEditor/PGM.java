import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PGM extends Image{
    public String file_name;
    public int[][] pixelvals;
   
   public PGM(){
         magic = "--";
        width = 0;
        height = 0;
        depth = 0;
   }

    public PGM(String x){
        file_name = x;
        File input;
        Scanner sc = null;
        try{
            input = new File(file_name);
            sc = new Scanner(input);
        }catch(FileNotFoundException e){
            System.out.println(e);
            System.exit(0);
        }
        magic = sc.nextLine();
        width = sc.nextInt();
        height = sc.nextInt();
        depth = sc.nextInt();
        
        pixelvals = new int[height][width];
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                pixelvals[i][j] = sc.nextInt();
            }
        } 
        sc.close();
    }

    public int[][] getPixels(){
        return this.pixelvals;
    }

    @Override
    public void flip_horizontally(){
        int [][] X = this.pixelvals;
        int [][] Y = new int[this.height][this.width];

        for(int i = 0; i < this.height; i++){
            for(int j = (this.width - 1); j >= 0; j--){
                Y[i][this.width - j - 1] = X[i][j];
            }
        }
        this.pixelvals = Y;
    }

    @Override
    public void flip_vertically(){
        int [][] X = this.pixelvals;
        int [][] Y = new int[this.height][this.width];

        for(int i = (this.height - 1); i >= 0; i--){
            for(int j = 0; j < this.width; j++){
                Y[this.height - i - 1][j] = X[i][j];
            }
        }
        this.pixelvals = Y;
   }

    @Override
    public void rotate_right_90(){
        int [][] X = this.pixelvals;
        int [][] Y = new int[this.width][this.height];
    
        for(int i = 0; i < this.width; i++){
            for(int j = (this.height - 1); j >= 0; j--){
                Y[i][this.height - 1 - j] = X[j][i];
            }
        }
        int temp = width;
        width = height;
        height = temp;
        this.pixelvals = Y;
   }

   public void save(String filename){
       PrintWriter writer = null;
       try{
            writer = new PrintWriter(filename);
       }catch(FileNotFoundException e){
           System.out.println(e);
           System.exit(0);
       }
        writer.println(this.magic);
        writer.printf("%d %d\n",this.width, this.height);
        writer.println(this.depth);
        for(int i = 0; i < this.height; i++){
            for(int j = 0; j < this.width; j++){
                writer.printf("%d ", pixelvals[i][j]);
            }
            writer.print("\n");
        }
        writer.close();
   }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a PGM file name to read: ");
        String file = sc.nextLine();
        sc.close();
        PGM PGMImage = new PGM(file);
        PGMImage.rotate_right_90();
        PGMImage.save("Feep.txt");
        //PGM PGM4 = new PGM(file);
        //PGMImage.flip_horizontally();
        //PGM PGM2 = new PGM();
        //PGM2.pgm(file);
        //PGM2.flip_vertically();
        //PGM PGM3 = new PGM();
        //PGM3.pgm(file); 
    }
}