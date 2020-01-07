public class Cat extends Animal{

    /*
    @Override //compiler knows youre trying to override parent function. will allow you to catch
              //an error at compile time -- no speak function in parent 
     public void speak(){
        System.out.println("Meow!!");
    }
      public static void speak(){
        System.out.println("Meow!!");
    }
    */

    //must ovveride all abstract functions
    @override public void speak(){
        System.out.println("Meow!!");
    }
}