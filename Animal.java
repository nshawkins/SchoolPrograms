public abstract class Animal{ //must have abstract in the name if abstract function
    protected String name;

/*    public static void speak(){
        System.out.println("I am an animal");
    }*/
    /*public void speak(){
        System.out.println("I am an animal");
    }
    */

    public abstract void speak(); //abstract function

    //cannot create an object out of an abstract class

    public void anotherFunction(){
        //this function will not have to be overriden because it is not abstract
    }
}