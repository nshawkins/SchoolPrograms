public class GetAndSet {
    private int number;
 
    public int getNumber() {
        return this.number;
    }
 
    public void setNumber(int num) {
        this.number = num;
    }

    GetAndSet obj = new SimpleGetterAndSetter();
    obj.number = 10;    // compile error, since number is private
    int num = obj.number; // same as above

    SimpleGetterAndSetter obj = new SimpleGetterAndSetter();
 
    obj.setNumber(10);  // OK
    int num = obj.getNumber();  // fine
}