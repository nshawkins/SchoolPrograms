public class Person{
    private String lastName;
    private String firstName;
    private String zipCode;

    public void Default(){
        firstName = "X";
        lastName = "X";
        zipCode = "X";
    }

     public void Default(String lastName, String firstName, String zipCode){
        this.firstName = firstName;
        this.lastName = lastName;
        this.zipCode = zipCode;
    }

    public void Display(){
        System.out.println(lastName + ", " + firstName + "  " + zipCode);
    }

    public static void main(String[] args){
        Person A = new Person();
        A.Default();
        A.Display();

        Person B = new Person();
        B.Default("Doe", "John", "37377");
        B.Display();

    }
}