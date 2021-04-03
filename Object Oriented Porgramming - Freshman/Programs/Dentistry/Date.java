public class Date {
    private int month;
    private int day;
    private int year;

    public void Default() {
        month = 1;
        day = 1;
        year = 2000;
    }

    public void Default(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public void Display() {
        System.out.println("" + month + "/" + day + "/" + year);
    }

    public static void main(String[] args) {
        Date A = new Date();
        A.Default();
        A.Display();

        Date B = new Date();
        B.Default(3, 24, 2019);
        B.Display();
    }
}