public class Reverse{

  public static String reverse(String str){
    String result = "";
    for (int i = str.length()-1; i >= 0; i--){
      result += str.charAt(i);
    }
    return result;
  }

  public static boolean isPalindrome(String str){
    if (str.length() < 2)
      return true;

    int start = 0;
    int last = str.length()-1;

    if (str.charAt(start) == str.charAt(last)) {
      return isPalindrome(str.substring(start + 1, last));
    }

    return false;
  }

  public static void main(String[] args){
    String input = "racecar";
    System.out.println(isPalindrome(input) + " is a palindrome");
  }
}
