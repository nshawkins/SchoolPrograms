public class Student{
    //instance variables (aka attributes)
    private String name;
    private String LUID;
    private double GPA;
    private String classification;
    private Date DOB;

    private String getName() {
        return name;
    }

    public String getLUID(){
        return LUID;
    }

    public double getGPA(){
        return GPA;
    }

    public String getClassification(){
        return classification;
    }

    public String getDOB(){
        return DOB;
    }

    public void setName(String newName){
        name = newName;
    }

    public void setLUID(String newLUID){
        LUID = newLUID;
    }

    public void setGPA(double newGPA){
        GPA = newGPA;
    }

    public void setClassification(String newClassification){
        classification = newClassification;
    }

    public void setDOB(String newDOB){
        DOB = newDOB;
    }
}