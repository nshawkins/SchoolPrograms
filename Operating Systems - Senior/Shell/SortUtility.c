#define _GNU_SOURCE
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

/*static int compare_function(const void *a,const void *b) {
    return strcmp(*(const char**)a, *(const char**)b);
}*/

int main(int argc, char *argv[]){
    int arraySize = 2048;
    char upper[arraySize][arraySize]; //use realloc to grow this array_________________________________________________________
    //memset(upper, 0, arraySize);
    //char lower[1024][1024];
    char temp[arraySize];
    FILE * fp = NULL;
    char * line = NULL;
    size_t len = 0;
    ssize_t read = 0;
    int upperCount = 0;
    //int lowerCount = 0;
    
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
                //printf("%s \n", upper[upperCount]);
            }
            upperCount++;
        }
        free(line);
    }else{
        for(int i = 1; i < argc; i++){
            fp = fopen(argv[i], "r");
            while ((read = getline(&line, &len, fp)) != -1) {
                //if(isupper(line[0])){
                    //printf("%s", "-------\n");
                    //printf("%s", line);
                    //printf("%s", "-------\n");
                    for (int j = 0; j < (int)strlen(line); j++) {
                        upper[upperCount][j] = line[j];
                        //printf("%s \n", upper[upperCount]);
                    }
                    upperCount++;
                //}
                /*
                if(islower(line[0])){
                    //printf("%s", "-------\n");
                    //printf("%s", line);
                    //printf("%s", "-------\n");
                    for (int j = 0; j < (int)strlen(line); j++) {
                        lower[lowerCount][j] = line[j];
                        //printf("%s %s \n", "lower: ", lower[lowerCount]);
                    }
                    lowerCount++;
                }*/
            }
            fclose(fp);
        }
        free(line);
    }
    
    //qsort(upper, upperCount, sizeof(char*), /*(int (*)(const void*, const void*))strcmp*/compare_function);
    //qsort(lower, lowerCount, sizeof(char*), /*(int (*)(const void*, const void*))strcmp*/compare_function);
    /*
    char tmp;
    for(int i = 0, j = 0; i < upperCount; i++){ //sort uppercase array
        for(int k = 0; j < upperCount; k++){
            if(i == j){
                j++;
            }
            else{
                if(strcmp(upper[i][k], upper[j][k]) < 0){

                }
                else if(strcmp(upper[i][k], upper[j][k]) > 0){

                }
                else{

                }
            }    
        }
        j = 0;
    }*/

    //Logic Bubble Sort
    
    for(int i = 1; i < upperCount; i++){
        for(int j = 0; j <= upperCount - i - 1; j++){
            //printf("J: %d\n", j);
            //printf("Upper[j]: %s", upper[j]);
            //printf("Upper[j+1] %s", upper[j+1]);
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
    /*
    for(int i=1;i<=lowerCount;i++){
        for(int j=0;j<=lowerCount-i;j++){
            if(strcmp(lower[j],lower[j+1])>0)
            { 
                strcpy(temp,lower[j]);
                strcpy(lower[j],lower[j+1]);
                strcpy(lower[j+1],temp);
            }
        }
    }
    for(int i=0;i<=lowerCount;i++){
        printf("%s",lower[i]);
    }*/
    /*
    for(int i = 0; i < upperCount; i++){
        //puts("upper: "); puts(upper[i]); puts("\n");
        printf("Upper: %s \n", upper[i]);
    }
    for(int i = 0; i < lowerCount; i++){
        printf("Lower: %s \n", lower[i]);
    }
    */
}