import java.util.ArrayList;

public class IntegerSet {
    ArrayList<Integer> items = new ArrayList<Integer>();

    //returns true iff k is one of the integer values contained in S
    public void contains(int k){
        items.get(k);
    }

    //adds k to the set of integer values contained in S
    public void insert(int k){
        items.add(k);
    }

    //removes k from the set of integers contained in S
    public void remove(int k){
        items.remove(k);
    }
    
    //returns true iff S is the empty set
    public void empty(){

    }
    
    //returns the number of elements in S
    public void size(){
        //items.length();
    }

    public static void main (String[] args){
       /* IntegerSet S = new IntegerSet();
        int k = 0;
        S.insert(1);
        S.contains(k);	
        S.insert(k);
        S.remove(k);
        S.empty();
        S.size()*/
    }
}
