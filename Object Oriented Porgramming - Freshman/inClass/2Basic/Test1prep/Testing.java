public class Testing{

  public static int hrMinToMin(int hrs, int mins){
    int result = 0;
    result = (hrs * 60) + mins;

    //return mins; gives an error
    return result;
  }
  public static void main(String[] args){
    assert hrMinToMin(0,0) == 0 : "(0,0) should be 0";
    assert hrMinToMin(0,1) == 1 : "(0,1) should be 1";
    assert hrMinToMin(0,99) == 99 : "(0,99) should be 99";
    assert hrMinToMin(1,0) == 60 : "(1,0) should be 60";
    assert hrMinToMin(2,1) == 121 : "(2,1) should be 121";
  }
}
