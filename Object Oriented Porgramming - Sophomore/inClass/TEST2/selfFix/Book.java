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
        this.printCost = (body.length() * .50) + title.length();
        for (int i = 0; ; i++){
            if (body.length() % 5 == 0){
                double counter = 0;
                body.length() / 5;
                System.out.print(counter);
                this.pageCount = counter;
            }
            else {
                break;
            }
        }
    }

    public void Print(){
        System.out.println("Title: " + title);
        System.out.println("Body: " + content);
        System.out.println("Cost: " + printCost);
        System.out.println("Pages: " + pageCount);
    }

    public void encrypt(int key){

}
    public static void main(String[] args){
        Book B = new Book();
        B.Book("A B C D E F G H I J K L M N O P Q R S T U V W X Y Z", "Alphabet");
        B.Print();
    }
}