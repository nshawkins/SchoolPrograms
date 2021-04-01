import java.util.LinkedList;

public class primes{
    public static void main(String[] args){
        LinkedList<Integer> primes = new LinkedList<Integer>();
        primes.add(2);
        primes.add(3);
        primes.add(5);

        //for (int i = 0; i < primes.size(); i++){
        //    System.out.println(primes.get(i)); // retrieves element at position i
        //}

        for (Integer i: primes){
            System.out.println(i);
        } // would not work on a regular array, only array list. 

        //primes.get(0); // retrieves element at position 0
    }
}