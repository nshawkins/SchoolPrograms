public class Book{

    private String title;
    private String contents;
    private double cost;
    private int pages;

    // default constructor
    public Book(){

    }

    public Book (String c, String t){
        title = t;
        contents = c;

        String temp = t+c;
        pages = temp.length()/5;
        if (temp.length() % 5 > 0){
            pages+=1;

            //printing cost

            tp = temp.replace("\\s","");
            cost = 0.5*temp.length();
        }
        
    }

    public String getTItle(){
        return title;
    }

    public String getContents(){
        return contents;
    }

    public double getPrintingCost(){
        return 0.0;
    }

    public int getPages(){
        return 0; 
    }

    public void print(){
        
    }
}