import java.util.Scanner;

public class GroceryItem {
    private int stock;
    private double price;
    private int quantity;
    private double value;   
    
    public void dataEntry() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter stock: ");
        this.stock = sc.nextInt();
        if (stock < 1000 || stock > 9999) {
            System.out.print("Enter stock: ");
            this.stock = sc.nextInt();
        }

        System.out.print("Enter price: ");
        this.price = sc.nextDouble();
        if (price < 0.0) {
            System.out.print("Enter price: ");
            this.price = sc.nextDouble();
        }

        System.out.print("Enter quantity: ");
        this.quantity = sc.nextInt();
        if (quantity < 0.0) {
            System.out.print("Enter quantity: ");
            this.quantity = sc.nextInt();
        }

    this.value = price * quantity;
    }
    
    public void printValues() {
      System.out.println();  
      System.out.println("Stock #: " + stock);
      System.out.printf("Price: $%.2f", price);
      System.out.println();
      System.out.println("Quantity in stock: " + quantity);
      System.out.printf("Total value: $%.2f", value);
    }

    public String toString() {
        String display = "Stock #: " + stock + "  " + "Price: " + price + "  " + "Quantity in stock: " + quantity + "  " + "Total value: " + value;
        return display;
    }

    public static void main(String[] args) {
        GroceryItem A = new GroceryItem();
        A.dataEntry();
        A.printValues();
    }
}