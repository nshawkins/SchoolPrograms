import java.util.*;

public class Tester {
    public static void main(String[] args)
    {
        IntegerSet S = new IntegerSet();
        System.out.println(S.empty() ? "S is empty":"S is not empty");
        S.insert(3);
        S.insert(4);
        S.remove(2);
        S.remove(3);

        System.out.println("|S| = " + S.size());
        System.out.println(S.contains(4) ? "S contains 4":"S does not contain 4");
        System.out.println(S.contains(3) ? "S contains 3":"S does not contain 3");
    }
}