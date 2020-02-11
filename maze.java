import java.util.Scanner;

public class maze{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = 0;
        int x = 0;
        int y = 0;
        int count = 0;
        String tmp;
        char tmp2;
        n = sc.nextInt();
        int [] answers = new int[n];
        for (int i = 0; i < n; i++){
            x = sc.nextInt();
            y = sc.nextInt();
            String [][] maze = new String [x][y];
            for (int j = 0; j < x; j++){
                tmp = sc.next();
                for (int k = 0; k < y; k++){
                    tmp2 = tmp.charAt(k);
                    maze[j][k] = Character.toString(tmp2);
                }
            }
            for (int j = 0; j < x; j++){
                for (int k = 0; k < y; k++){
                    if (maze[j][k].equals("-")){
                        count++;
                        try{
                            if ((maze[j+1][k].equals("X") && maze[j-1][k].equals("X")) && (maze[j][k+1].equals("X") || maze[j][k-1].equals("X"))){
                                count += 4;
                            } else if((maze[j+1][k].equals("X") || maze[j-1][k].equals("X")) && (maze[j][k+1].equals("X") && maze[j][k-1].equals("X"))){
                                count += 4;
                            }
                        } catch(ArrayIndexOutOfBoundsException E){
                            continue;
                        }
                    }
                    if(maze[j][k].equals("+")){
                        try{
                            if ((maze[j+1][k].equals("X") && maze[j-1][k].equals("X")) && (maze[j][k+1].equals("X") || maze[j][k-1].equals("X"))){
                                count -= 5;
                            } else if((maze[j+1][k].equals("X") || maze[j-1][k].equals("X")) && (maze[j][k+1].equals("X") && maze[j][k-1].equals("X"))){
                                count -= 5;
                            }
                        } catch(ArrayIndexOutOfBoundsException E){
                            continue;
                        }
                    }
                }
            }
            answers[i] = count;
            count = 0;
        }
        for (int i = 0; i < n; i++){
            System.out.println(answers[i]);
        }
        sc.close();
    }
}