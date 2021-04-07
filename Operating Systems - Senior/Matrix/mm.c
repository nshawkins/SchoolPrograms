#include <stdio.h>
#include <stdint.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <time.h>

//DECLARE GLOBAL VARIABLES----------
    int input;
    int output;
    int readbin;
    int **matVals;
    int **matAnsVals;

    struct MatSize{
        int row;
        int col;
    }*matSize, *matAnsSize;

//FUNCTIONS-------------------------
void read_matrices(){
    matSize = (struct MatSize*)calloc(200, sizeof(int));
    matVals = (int**)calloc(250000, sizeof(int *));
    
    int i = 0;
    while(read(input, &matSize[i], 8) > -1){
        if(matSize[i].row == 0 || matSize[i].col == 0) break;

        //PRINT MATSIZE
        printf("row: %d, col: %d\n", (int8_t)matSize[i].row, (int8_t)matSize[i].col);

        matVals[i] = (int *)calloc((matSize[i].row * matSize[i].col), sizeof(int));
        if (read(input, matVals[i], (matSize[i].row * matSize[i].col) * 4) == -1){ 
            printf("read vals failed\n");
        }

        //PRINT MATVALS
        for(int j = 0; j < matSize[i].row * matSize[i].col; j++){
            if(j % matSize[i].col == 0 && j > 0) printf("\n");  
            printf("%d ", (int8_t)matVals[i][j]);
        }
        printf("\n");  

        i++;
    }
    close(input);
}

int cmpfunc(const void *a, const void *b)
{
   const int *A = a, *B = b;
   return (*A > *B) - (*A < *B);
}

void mult_matrices(){
    matAnsVals = (int**)calloc(250000, sizeof(int *));
    matAnsSize = (struct MatSize*)calloc(200, sizeof(int));
    for(int i = 0; i < 100; i++){ //FOR EACH MATRIX
        if(matSize[i].row == 0 || matSize[i].col == 0) break;
        if(matSize[i].col != matSize[i+1].row) continue;

        matAnsSize[i].row = matSize[i].row; 
        matAnsSize[i].col = matSize[i + 1].col;
        matAnsVals[i] = (int *)calloc((matAnsSize[i].row * matAnsSize[i].col), sizeof(int));

        printf("--------------------------------------------MatNum: %d\n", i);
        
        int ans = 0;
        int ansPos = 0;
        for (int j = 0; j < matAnsSize[i].row * matAnsSize[i].col; j++){ //FOR EACH POSITION IN THE ANS MATRIX
            if(ansPos == (matAnsSize[i].row * matAnsSize[i].col)) goto sorter;
            for(int k = 0; k < matAnsSize[i].col; k++, ansPos++){ //FOR SECOND MATRIX VALUES
                for(int l = 0; l < matSize[i].col; l++){ //FOR FIRST MATRIX VALUES

                    printf("%d * %d\n", (int8_t)matVals[i][(matSize[i].col * j) + l], (int8_t)matVals[i+1][(l * matAnsSize[i].col) + k]);
                    ans += matVals[i][(matSize[i].col * j) + l] * matVals[i+1][(l * matAnsSize[i].col) + k];
                    printf("ANS AFTER: %d\n", (int8_t)ans);
                }
                //SAVE TO ANSWER MATRIX

                printf("= %d\n", (int8_t)ans);
                printf("ANSPOS: %d\n", ansPos);
                printf("-------------\n");

                matAnsVals[i][ansPos] = ans;
                ans = 0;
            }
            //SORT ROW
            sorter:
                qsort(&matAnsVals[i][(matAnsSize[i].col * j)], matAnsSize[i].col, sizeof(int), cmpfunc);
                if(ansPos == (matAnsSize[i].row * matAnsSize[i].col)) break;
        }
        ansPos = 0;
    }
    
    //FREE ALL DATA THAT IS NOW UNUSED
    for(int i = 0; i < (matSize[i].row * matSize[i].col); i++){
        free(matVals[i]);
    }
    free(matVals);
    free(matSize);
}

void show_matrices(){ //LOGIC WORKS
    int i = 0;
    while(write(output, &matAnsSize[i], 8) > -1){

        // PRINT MATSIZE
        printf("row: %d, col: %d\n", (int8_t)matAnsSize[i].row, (int8_t)matAnsSize[i].col);

        if(matAnsSize[i].row == 0 || matAnsSize[i].col == 0) break;

        //PRINT MATVALS
        for(int j = 0; j < matAnsSize[i].row * matAnsSize[i].col; j++){
            if(j % matAnsSize[i].col == 0 && j > 0) printf("\n");  
            printf("%d ", (int8_t)matAnsVals[i][j]);
        }
        printf("\n");

        if (write(output, matAnsVals[i], (matAnsSize[i].row * matAnsSize[i].col) * 4) == -1){ 
            printf("write vals failed\n");
        }
        i++;
    }
    for(int i = 0; i < (matAnsSize[i].row * matAnsSize[i].col); i++){
        free(matAnsVals[i]);
    }
    free(matAnsSize);
    free(matAnsVals);
    close(output);
}

int main(int argc, char *argv[]){

    //START TIMER FOR ENTIRE PROGRAM----
    uint64_t prog_diff;
    struct timespec prog_start, prog_end;
    clock_gettime(CLOCK_REALTIME, &prog_start);

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

    //START TIMER FOR READ_MATRICIES----
    uint64_t read_diff;
    struct timespec read_start, read_end;
    clock_gettime(CLOCK_REALTIME, &read_start);

    read_matrices();

    //END TIMER FOR READ_MATRICIES------
    clock_gettime(CLOCK_REALTIME, &read_end);
    read_diff = 1000000000 * (read_end.tv_sec - read_start.tv_sec) + read_end.tv_nsec - read_start.tv_nsec;
    printf("Reading: %9luns\n", read_diff);

    //START TIMER FOR MULT_MATRICIES()--
    uint64_t mult_diff;
    struct timespec mult_start, mult_end;
    clock_gettime(CLOCK_REALTIME, &mult_start);

    mult_matrices();

    //END TIMER FOR MULT_MATRICIES()----
    clock_gettime(CLOCK_REALTIME, &mult_end);
    mult_diff = 1000000000 * (mult_end.tv_sec - mult_start.tv_sec) + mult_end.tv_nsec - mult_start.tv_nsec;
    printf("Compute: %9luns\n", mult_diff);

    //START TIMER FOR SHOW_MATRICIES----
    uint64_t show_diff;
    struct timespec show_start, show_end;
    clock_gettime(CLOCK_REALTIME, &show_start);

    show_matrices();

    //END TIMER FOR SHOW_MATRICIES()----
    clock_gettime(CLOCK_REALTIME, &show_end);
    show_diff = 1000000000 * (show_end.tv_sec - show_start.tv_sec) + show_end.tv_nsec - show_start.tv_nsec;
    printf("Writing: %9luns\n", show_diff);

    //END TIMER FOR ENTIRE PROGRAM------
    clock_gettime(CLOCK_REALTIME, &prog_end);
    prog_diff = 1000000000 * (prog_end.tv_sec - prog_start.tv_sec) + prog_end.tv_nsec - prog_start.tv_nsec;
    printf("Elapsed: %9luns\n", prog_diff);
}