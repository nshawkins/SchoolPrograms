#include <stdio.h>
#include <stdint.h>
#include <stdlib.h>
#include <time.h>
#include <unistd.h>
#include <fcntl.h>

//DECLARE GLOBAL VARIABLES----------
    int input;
    int output;
    int readbin;
    int **matVals;

    struct MatSize{
        int row;
        int col;
    };
    struct MatSize *matSize;
//----------------------------------

//FUNCTIONS-------------------------
void read_matrices(){
    matSize = (struct MatSize*)malloc(sizeof(int) * 2); 
    *matVals = (int *)malloc(250000 * sizeof(int));
    
    for(int i = 0; i < 100; i++){
        if (read(input, &matSize[i], 8) != sizeof(matSize)) {
            printf("read size failed\n");
        }

        matVals[i] = (int *)malloc((matSize[i].row * matSize[i].col) * 4);
        if (read(input, matVals[i], (matSize[i].row * matSize[i].col) * 4) != -1);//{ 
            //printf("read vals failed\n");
        //}
    }
    close(input);
}

int cmpfunc (const void * a, const void * b) {
   return ( *(int*)a - *(int*)b );
}

void mult_matrices(){
/*
    int traverse = 0;
    for(int i = 0; i < 100; i++){
        if(matRowCol[i][1] == matRowCol[i+1][0]){
            for(int j = 0; j < matRowCol[i + 1][1]; j++){
                for(int k = 0; k < matRowCol[i][0]; k++, traverse++){
                    if (traverse == 0){
                        matAns[j][k] = matVals[i][traverse] * matVals[i+1][j];
                    }else{
                        matAns[j][k] = matVals[i][traverse] * matVals[i+1][j + (matRowCol[i + 1][1] * k)];
                    }
                }
            }
        //SORT THE ROW
        qsort(matAns[i], matRowCol[i][0], sizeof(int), cmpfunc);
        //------------
        traverse = 0;
        }else{
            continue;
        }
    }*/
}

void show_matrices(){

}
//----------------------------------

//MAIN------------------------------
int main(int argc, char *argv[]){

    //START TIMER FOR WHOLE PROGRAM-----
    uint64_t prog_diff;
    struct timespec prog_start, prog_end;
    clock_gettime(CLOCK_REALTIME, &prog_start);
    //----------------------------------

    //SET VARS TO ARGV[]----------------
    input = open(argv[1], O_RDONLY, 0666);
    if (input < 0) {
        printf("open %s failed\n",argv[1]);
        return 1;
    }
    output = open(argv[2],O_CREAT|O_TRUNC|O_WRONLY,0666);
    if (output < 0) {
        printf("open %s failed\n",argv[2]);
        return 1;
    }
    //----------------------------------

    //START TIMER FOR READ_MATRICIES----
    uint64_t read_diff;
    struct timespec read_start, read_end;
    clock_gettime(CLOCK_REALTIME, &read_start);
    //----------------------------------

    //CALL READ_MATRICIES()-------------

    read_matrices(); //works great (to my knowledge)

    //----------------------------------

    //END TIMER FOR READ_MATRICIES------
    clock_gettime(CLOCK_REALTIME, &read_end);
    read_diff = 1000000000 * (read_end.tv_sec - read_start.tv_sec) + read_end.tv_nsec - read_start.tv_nsec;
    printf("Reading: %9luns\n", read_diff);
    //----------------------------------

    //START TIMER FOR MULT_MATRICIES()--
    uint64_t mult_diff;
    struct timespec mult_start, mult_end;
    clock_gettime(CLOCK_REALTIME, &mult_start);
    //----------------------------------
    
    //CALL MULT_MATRICIES()-------------

    mult_matrices();

    //----------------------------------

    //END TIMER FOR MULT_MATRICIES()----
    clock_gettime(CLOCK_REALTIME, &mult_end);
    mult_diff = 1000000000 * (mult_end.tv_sec - mult_start.tv_sec) + mult_end.tv_nsec - mult_start.tv_nsec;
    printf("Compute: %9luns\n", mult_diff);
    //----------------------------------

    //START TIMER FOR SHOW_MATRICIES----
    uint64_t show_diff;
    struct timespec show_start, show_end;
    clock_gettime(CLOCK_REALTIME, &show_start);
    //----------------------------------

    //CALL SHOW_MATRICIES()-------------

    show_matrices();

    //----------------------------------

    //END TIMER FOR SHOW_MATRICIES()----
    clock_gettime(CLOCK_REALTIME, &show_end);
    show_diff = 1000000000 * (show_end.tv_sec - show_start.tv_sec) + show_end.tv_nsec - show_start.tv_nsec;
    printf("Writing: %9luns\n", show_diff);
    //----------------------------------

    //FREE DATA-------------------------
    
    free(matSize);
    free(matVals);
    close(input);
    close(output);
    //----------------------------------

    //END TIMER FOR ENTIRE PROGRAM------
    clock_gettime(CLOCK_REALTIME, &prog_end);
    prog_diff = 1000000000 * (prog_end.tv_sec - prog_start.tv_sec) + prog_end.tv_nsec - prog_start.tv_nsec;
    printf("Elapsed: %9luns\n", prog_diff);
    //----------------------------------
    return 0;
}