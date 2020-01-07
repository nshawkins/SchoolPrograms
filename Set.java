public class Set <T>{ //creation of generic class (T can be replaced with anything)
    private T[] list;
    private int size;

    // default constructor
    public Set() {
        list = new list[size];
        size = 100;
    }

    // adding a new element
    public void add(T item){
        boolean found = false;
        for (int i = 0; i < size; i++){
            if (list[i].compareTo(item) == 0){ 
                //compare to returns 3 things
                //0 if equal, -1 if before, 1 if after
                found = true;
            }
        }
        if (!found){
            if (list.length == size){ //run out of space
                Object [] temp = new Object[size*2];
                for (int i = 0; i < size; i++){
                    temp[i] = list[i];
                }
            size *= 2;
            }
            
            T[size] = item;
            size++;
        }
    }

    public void remove(T item){
        Object temp [] = new Object[size];
        int index = 0;
        for (int i = 0; i < size; i++){
            if (list[i].compareTo(item) != 0){
                temp[index] = list[i];
            }
        }
        list = temp;
        size = index;
    }
}