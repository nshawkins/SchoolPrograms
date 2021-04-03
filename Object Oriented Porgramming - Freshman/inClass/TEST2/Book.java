public class Book{
    public String title;
    public String content;
    public int pageCount;
    public double printCost;

    public String getTitle(){
        return this.title;
    }

    public String getContents(){
        return this.content;
    }

    public int getPages(){
        return this.pageCount;
    }

    public double getPrintingCost(){
        return this.printCost;
    }

    public void Default(){
        this.title = "";
        this.content = "";
        this.pageCount = 0;
        this.printCost = 0.0;
    }

    public void Book(String body, String title){
        this.title = title;
        this.content = body;
        //this.printCost = body.lenght() * .50;
        int counter = 0;
        
        /*if (body.length() % 5 == 0){
            counter += 1;
            this.pageCount = counter;
            }
        */
    }

    public void Print(){
        System.out.print("Title: " + title);
        System.out.print("Body: " + content);
        System.out.print("Cost: " + printCost);
        System.out.print("Pages: " + pageCount);
    }

    public void encrypt(int key){

}
    public static void main(String[] args){
        Book B = new Book();
        B.Book("A B C D E F G H I J K L M N O P Q R S T U V W X Y Z", "Alphabet");
        B.Print();
    }
}