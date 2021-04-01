public class Grocery2 {
    public static void main(String[] args) {
        String final_display = "";
        for (int i = 0; i < 10; i++) {
            GroceryItem A = new GroceryItem();
            A.dataEntry();
            final_display += A.toString() + ">";
        }
        System.out.println();
        String[] items = final_display.split(">");
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i]);
        }
    }
}