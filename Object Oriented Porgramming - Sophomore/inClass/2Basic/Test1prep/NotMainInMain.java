public class NotMainInMain{

  public final double PI = 3.14; //global variable (inside brackets)


//two functions are the same if they have:
//same name
//same return type
//same number and type of inputs
  public static int sum(int x, int y){
    int result = x + y;
    return result; //end of a function. last thing a function will read
    //or return x + y;
  }

  //overloading the function name 'sum'
  public static String sum(String x, String y){
    return x + y;
  }

  public static void main(String[] args){
    int a = 10;
    int b = 5;

    String str1 = "Hello";
    String str2 = " world!";

    System.out.println("a+b= " + sum(a,b));
    System.out.println("S1+s2= " + sum(str1, str2));
  }

  //HERE
}
