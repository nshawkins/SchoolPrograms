import java.util.Scanner;
import java.io.File;
import java.io.fileNotFoundException;

public class Example {
    public static void readFile(String fileName) throws Exception{
        File file = new File(fileName);
        Scanner fileScanner = new Scanner(file);
        while (fileScanner.hasNext()){
            System.out.println(fileScanner.nextLine());
        }
    }
    //throw or catch are the two options
    public static void main(String[] args) //throws exception (general)
    throws fileNotFoundException
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a file:");
        String fileName = sc.nextLine();

    }
}