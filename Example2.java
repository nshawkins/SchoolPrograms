import java.util.Scanner;
import java.io.File;

public class Example {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a file:");
        String fileName = sc.nextLine();

        try{
            File file = new File(fileName);
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNext()){
                System.out.println(fileScanner.nextLine());
            }
        }
        catch (Exception ex){
            System.out.println(ex.toString());
            System.exit(-1);
        }

    }
}