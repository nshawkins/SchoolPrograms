public class Main{
    public static void main(String[] args){
       /* Animal A = new Animal();
        A.speak();

        Cat C = new Cat();
        C.speak();

        Animal D = C; //polymorphism -- calls child function
        D.speak();

        */ //with animal being abstrace, objects cannot be created from it

        //Cat F = A; CANNOT WORK -- cat cannot be animal, animal can be cat

        Cat C = new Cat();
        C.speak();
    }
} 