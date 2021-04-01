import java.io.*;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JFileChooser;

public class Estimation{

    public static void sortPub(String pubFileName){
        //scanner for n 
        int n = 0;
        File publications;
        Scanner pubsc = null;
        try{
            publications = new File(pubFileName);
            pubsc = new Scanner(publications);
        }catch(FileNotFoundException e){
            System.out.println(e);
            System.exit(0);
        }
        BufferedReader pubbr = null;
        try{
            publications = new File(pubFileName);
            pubbr = new BufferedReader(new FileReader(publications));
        }catch(FileNotFoundException e){
            System.out.println(e);
            System.exit(0);
        }
        try{
            while (pubbr.readLine() != null){
                //pubsc.nextLine();
                n++;
            }
        }catch(IOException e){
            System.out.println(e);
            System.exit(0);
        }

        //n = determine # of publications

        Pub [] pubarr = new Pub[n];
        for (int i = 0; i < n; i++){
            pubarr[i] = new Pub();
        }

        //import from File
        Scanner pubsc2 = null;
        try {
            publications = new File(pubFileName);
            pubsc2 = new Scanner(publications);
        } catch (FileNotFoundException e) {
            System.out.println(e);
            System.exit(0);
        }
        for (int i = 0; i < n; i++){
            String str = pubsc2.nextLine();
            int r = str.split(",").length;
            String[] ar = new String [r];
            ar = str.split(",");
            pubarr[i].author = ar[0];
            pubarr[i].title = ar[1];
            pubarr[i].confName = ar[2];
            pubarr[i].confLoc = ar[3];
            pubarr[i].year = Integer.parseInt(ar[4]); //parse string to int
        }

        //sort by year
        /*for (int i = 0; i < n; i++){
            int min = i;
            for (int j = 0; j < 20; j++){
                for(int k = i + 1; k < n; k++){
                    if(pubarr[k].year < pubarr[i].year){
                        min = k;
                    }
                }
            }*/
            
            //BUBBLE SORT
            for (int i = 0; i < n-1; i++){ 
                for (int j = 0; j < n-i-1; j++){
                    if (pubarr[j].year > pubarr[j+1].year){ 
                        // swap arr[j+1] and arr[i] 
                        Pub temp = pubarr[j]; 
                        pubarr[j] = pubarr[j+1]; 
                        pubarr[j+1] = temp;
                    }
                } 
            }
        pubsc.close();
        pubsc2.close();
        //export to file
        File sortedPubFile = new File("C://Users//hawki//Documents//1School//Intro to S.E//Estimation//sortedPubFile.txt");
        
        try{
            sortedPubFile.createNewFile();
        }catch (IOException e){
            System.out.println("File cannot be created");
        }
        try {
            PrintWriter pubWriter = new PrintWriter(sortedPubFile);
        for (int i = 0; i < n; i++){
            pubWriter.print(pubarr[i].author + ",");
            pubWriter.print(pubarr[i].title + ",");
            pubWriter.print(pubarr[i].confName + ",");
            pubWriter.print(pubarr[i].confLoc + ",");
            pubWriter.print(pubarr[i].year + ",");
            pubWriter.print(";");
            pubWriter.println();
        }
        pubWriter.close();
        } catch (FileNotFoundException e) {
            System.out.print(e);
            System.exit(0);
    }
}

    public static void sortFac(String facFileName){
        //scanner for n 
        int n = 0;
        File faculty;
        Scanner facsc = null;
        try{
            faculty = new File(facFileName);
            facsc = new Scanner(faculty);
        }catch(FileNotFoundException e){
            System.out.println(e);
            System.exit(0);
        }
        BufferedReader facbr = null;
        try{
            faculty = new File(facFileName);
            facbr = new BufferedReader(new FileReader(faculty));
        }catch(FileNotFoundException e){
            System.out.println(e);
            System.exit(0);
        };
        try{
            while (facbr.readLine() != null){
                //facsc.nextLine();
                n++;
            }

        }catch(IOException e){
            System.out.println(e);
            System.exit(0);
        }

        // n = determine number of publications
        //System.out.println(n);
        Fac [] facarr = new Fac [n];
        for (int i = 0; i < n; i++){
            facarr[i] = new Fac();
        }

        //import 
        Scanner facsc2 = null;
        try{
            faculty = new File(facFileName);
            facsc2 = new Scanner(faculty);
        }catch(FileNotFoundException e){
            System.out.println(e);
            System.exit(0);
        }
        
        for (int i = 0; i < n; i++){
            //System.out.println(" ");
            if (facsc2.hasNextLine()){
                String str = facsc2.nextLine();
                int r = str.split(",").length;
                String[] ar = new String [r];
                ar = str.split(",");
                facarr[i].name = ar[0];
                facarr[i].position = ar[1];
                int m = 0;
                for(int l = 2; l < ar.length; l++){
                    if(ar[l] != null){
                        m++;
                    }
                    else {
                        break;
                    }
                }
                facarr[i].xFac(m - 1);
                String colon = ";";
                for(int k = 2, p = 0; !ar[k].equals(colon); k++, p++){
                    facarr[i].publications[p] = ar[k];
                }
            }else{
                return;
            }
        }

        // sorting algorithm
            //Char atZero = new facarr[i].name.charAt(0);

            /*for (int k = 0; k < n-1; k++){
                    for (int j = 0; j < n-i-1; j++){
                        if (facarr[j].name.charAt(0) > facarr[j+1].name.charAt(0)){ 
                            // swap arr[j+1] and arr[i] 
                            Fac tempStr = atZero;
                            facarr[i] = facarr[i + 1];
                            facarr[i + 1] = tempStr;
                        }
                    }
                } 
                //Fac temp = facarr[min];
                //facarr[min] = facarr[i];
                //facarr[i] = temp;
            }*/
            for (int j = 0; j < n; j++){
            for (int i = 0; i < n; i++){
                int min = i;
               
                    for (int k = i + 1; k < n; k++){
                        //System.out.println(facarr[k].name);
                        //System.out.print(facarr[i].name);
                        if (facarr[k].name.charAt(0) < facarr[i].name.charAt(0)){
                            min = k;
                        Fac temp = facarr[min];
                        facarr[min] = facarr[i];
                        facarr[i] = temp;
                        }   
                        else if (facarr[k].name.charAt(0) == facarr[i].name.charAt(0)){
                           // int p = 0;
                           min = k;
                        }

                            //while (facarr[k].name.charAt(p) == facarr[i].name.charAt(0)){
                             //   p++;
                           // }
                           // if (facarr[k].name.charAt(p) > facarr[i].name.charAt(p)){
                             //   min = k;
                            //}
                        }
                        
                    }
                }
            

        //export 

        File sortedFacFile = new File("C://Users//hawki//Documents//1School//Intro to S.E//Estimation//sortedFacFile.txt");
        
        try{
            sortedFacFile.createNewFile();
        }catch (IOException e){
            System.out.println("File cannot be created");
        }

        try{
            PrintWriter writer = new PrintWriter (sortedFacFile);
            for (int i = 0; i < n; i++){
                writer.print(facarr[i].name + ",");
                //System.out.println(facarr[i].name);
                writer.print(facarr[i].position + ",");
    
    
                for(int p = 0; p < facarr[i].publications.length; p++){
                    writer.print(facarr[i].publications[p] + ",");
                
                }
            writer.print(";");
            writer.println();
            }
    
                writer.close();
            
        
        }catch(FileNotFoundException e){
            System.out.println(e);
            System.exit(0);
        }
        facsc.close();
        facsc2.close();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //"enter file name: "
        System.out.println("Enter the faculty file: ");
        String facFileName = null;
        File facFile = null;
        JFileChooser facChooser = new JFileChooser();

        int facReturnValue = facChooser.showOpenDialog( null );
        if ( facReturnValue == JFileChooser.APPROVE_OPTION){
            facFile = facChooser.getSelectedFile();
        }
        if (facFile != null){
            facFileName = facFile.getPath();
        }
        
        System.out.println("Enter the Publications File: ");
        String pubFileName = null;
        File pubFile = null;
        
        JFileChooser pubChooser = new JFileChooser();
        int pubReturnValue = pubChooser.showOpenDialog(null);
        if ( pubReturnValue == JFileChooser.APPROVE_OPTION){
            pubFile = pubChooser.getSelectedFile();
        }
        if (pubFile != null){
            pubFileName = pubFile.getPath();
        }

        sortFac(facFileName);

        sortPub(pubFileName);

        sc.close();
    }
} 