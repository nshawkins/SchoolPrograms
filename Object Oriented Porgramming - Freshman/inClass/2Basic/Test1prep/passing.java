public class passing{

  public static void foo(int[] a){
    //a = -1; first program

    for (int i = 0; i < a.length; i++)
      a[i] = -1;
  }
  public static void main(String[] args){
    int [] arr = {5, 5, 5};

    foo(arr);
    for (int i = 0; i < arr.length; i++)
      System.out.println(arr[i]);
/*
    int num = 5;
    foo(num);

    System.out.println(num);

    foo copies 5 to a different location instead of changing 5.
    a is the differnt location (than num), and a is changed to -1.
    num is then returned*/
  }
}
