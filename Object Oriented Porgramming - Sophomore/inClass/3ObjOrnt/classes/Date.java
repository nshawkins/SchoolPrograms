public class Date{
    //variables will be assinged 0 by default
    private int month;
    private int day;
    private int year;

    public int getMonth(){
        return month;
    }

    public int getDay(){
        return day;
    }

    public int getYear(){
        return year;
    }

    /*
    //changes the base variable assingments from 0 to respective inputs
    public Date(){
        month = 1;
        day = 1;
        year = 1970;
    }
*/
    //overloading the constructor
    //same name, different inputs
    //this can take user input
    public Date(int m, int d, int y){
        month = m;
        day = d;
        year = y;
    }

    public void print() {
        System.out.println(month + "/" + day + "/" + year);
    }
}