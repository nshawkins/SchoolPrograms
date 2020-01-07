public class Employee{

    //attributes
    private String name;
    private String dept;
    private double salary;
    private String position;

    //default constructor (takes no input)
    public Employee(){
        name = "";
        dept = "";
        salary = 0.0;
        position = "";
    }

    //overloading constructor
    public Employee(String name, String dept, double salary, String position){
        //this.____ references to the current object (line 4 - 7)
        //the second "name" is always referred to as the input (line 18)
        this.name = name; 
        this.dept = dept;
        this.salary = salary;
        this.position = position;
        
    }

    public String toString(){
        String result =  name + " " + dept + " " + salary + " " + position;
        return result; 
    }

    public void print(){
        System.out.println(this);
    }
    public static void main(String[] args){
        Employee E = new Employee("Tom", "ENG.", 1000, "Software Dev.");
        E.print();
    }
}