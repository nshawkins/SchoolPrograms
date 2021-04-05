#define _GNU_SOURCE
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

int main(int argc, char *argv[]){
    int arraySize = 2048;
    char upper[arraySize][arraySize]; //use realloc to grow this array
    char temp[arraySize];
    FILE * fp = NULL;
    char * line = NULL;
    size_t len = 0;
    ssize_t read = 0;
    int upperCount = 0;
    
    for(int i = 0; i < arraySize; i++){
        for(int j = 0; j < arraySize; j++){
            upper[i][j] = 0;
        }
    }

    if(argc < 2){
        //read in the lines via command prompt (scanf or stdin) this handles argc[1] AND piping
        while(/*there is input (not command D)*/getline(&line, &len, stdin) != -1){
            for (int j = 0; j < (int)strlen(line); j++) {
                upper[upperCount][j] = line[j];
            }
            upperCount++;
        }
        free(line);
    }else{
        for(int i = 1; i < argc; i++){
            fp = fopen(argv[i], "r");
            while ((read = getline(&line, &len, fp)) != -1) {
                for (int j = 0; j < (int)strlen(line); j++) {
                    upper[upperCount][j] = line[j];
                }
                upperCount++;
            }
            fclose(fp);
        }
        free(line);
    }

    //Logic Bubble Sort
    
    for(int i = 1; i < upperCount; i++){
        for(int j = 0; j <= upperCount - i - 1; j++){
            if(strcmp(upper[j], upper[j+1]) > 0){ 
                strcpy(temp, upper[j]);
                strcpy(upper[j], upper[j+1]);
                strcpy(upper[j+1], temp);
            }
        }
    }
    for(int i = 0; i < upperCount; i++){
        printf("%s",upper[i]);
    }
}