// javac Example.javac
//java Example Nick Hawkins
// 'nick' stored in args[0], 'hawkins' stored in args[1]
public class args {
  public static void main(String[] args) {
    System.out.println("You have passed " + args.length + " arguments");

    System.out.println("First argument: " + args[0]);
    System.out.println("Third argument: " + args[2]);
  }
}
