/*
Name: Nick Hawkins
Class: CS1233
Description: A demo for a scanner library
*/

import java.util.Scanner;
public class PrintBioScanner{
  public static void main(String[] args){
    Scanner myScanner = new Scanner(System.in);
    //system.in = keyboard input
    // to read string: myScanner.next(); reading text until space
    //to read multiple strings or a line: myScanner.nextLine();
    // to read integers: myScanner.nextInt();
    //to read real numbers: myScanner.nextDouble();
    System.out.print("Enter first name: ");
    String firstName = myScanner.nextLine();
    System.out.print("Enter last name: ");
    String lastName = myScanner.nextLine();
    System.out.print("Enter DOB: ");
    String DOB = myScanner.nextLine();
    System.out.print("Enter major: ");
    String major = myScanner.nextLine();
    System.out.println();

    System.out.println("First name:\t" + firstName);
    System.out.println("Last name:\t" + lastName);
    System.out.println("DOB:\t\t" + DOB);
    System.out.println("Major:\t\t" + major);
  }
}
