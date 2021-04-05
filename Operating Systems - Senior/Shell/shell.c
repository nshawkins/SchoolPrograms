#include "types.h"
#include "stat.h"
#include "user.h"
#include "parse.h"
#include "fcntl.h"

int main(int argc, char *argv[]){
    command cmd;
    char line[100];
    int background[100];
    int bgsize = 0;
    int frc = 1;
    for(int i = 0; i < 100; i++){
        background[i] = 0;
        line[i] = 0;
    }
    //printf(1, "\n1\n");
    printf(1, "shell> "); //initial prompt print
    while(/*gets(line, 1000)*/ 1){ //takes whole line input as long as there is input
        //printf(1, "\n3\n");
        gets(line, 1000);
        //printf(1, "Line: %s\n", line);
        int rc = parse(line, &cmd); //runs parse command and returns 0 if successful
        //printf(1, "\ncommand.bg = %d, command.argc = %d, command.argv[0] = %s\ncommand.argv = %s, command.input = %s, command.output = %s", cmd.bg, cmd.argc, cmd.argv[0], cmd.argv, cmd.input, cmd.output);
        //printf(1, "\n4\n");
        if(rc == 0){
            //printf(1, "\n5\n");
            if(strcmp(line, "\n") == 0){
                printf(1, "shell> "); 
                continue;
            }
            if(strcmp(line, "exit") == 0){ //kill shell command
                //printf(1, "\n6\n");
                //printf(1, "%d\n", cmd.argc);
                if(cmd.argv[1] || cmd.input || cmd.output){
                    printf(2, "exit usage error\n");
                    printf(1, "shell> "); 
                    continue;
                }if(bgsize != 0){
                    printf(2, "zombie!\n");
                    printf(1, "shell> "); 
                    continue;
                }
                else{
                   
                    free(line);
                    //printf(1, "exit called\n");
                    exit();
                }
            }
            //bg
            if(strcmp(line, "bg") == 0){
                if(cmd.argv[1] || cmd.input || cmd.output){
                    printf(2, "bg usage error\n");
                }else{
                    for(int i = 0; i < bgsize; i++){
                        printf(1, "%d ", background[i]);
                    }
                    printf(1, "\n");
                }
                printf(1, "shell> "); 
                continue;
            }
            //wait
            if(strcmp(line, "wait") == 0){
                if(cmd.argv[1] || cmd.input || cmd.output){
                    printf(2, "wait usage error\n");
                }else{
                    for(int i = 0; i < bgsize; i++){
                        wait();
                    }
                    bgsize = 0;
                }
                printf(1, "shell> "); 
                continue;
            }
            frc = fork(); //forks to execute program
            if(frc < 0){
                printf(2, "Fork failed\n");
            }
            else if(frc == 0){ //is a child process
            
                //file input
                if(cmd.input){
                    close(0); //closes stdin
                    open(cmd.input, O_CREATE | O_RDONLY);
                }
                //file output
                if(cmd.output){
                    close(1); //closes stdout
                    open(cmd.output, O_CREATE | O_WRONLY);
                }
                //then exec()
                if(cmd.bg != 0){
                    //printf(1, "bg init\n");
                    background[bgsize] = getpid();
                    //printf(1, "background[bgsize] %d\n", background[bgsize]);
                    bgsize++;
                }
                exec(cmd.argv[0], cmd.argv); //run process
                printf(2, "exec failed\n");
            }else{
                //printf(1, "\n7\n");
                //printf(1, "Fork ran, parent waiting\n", frc);
                //if(cmd.bg != 0){
                wait();
                bgsize -= 1;
                //}
                //printf(1, "\n8\n");
            }
        }
        else{
            printf(2, "syntax error\n"); //prints if parse failed
        }
        printf(1, "shell> "); //prints next prompt for user input
    }
}