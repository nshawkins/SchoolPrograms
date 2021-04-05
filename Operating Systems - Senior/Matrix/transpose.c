#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>

struct MatSize{
    int row;
    int col;
};

int main(int argc, char *argv[]){

    int input = open(argv[1], O_RDONLY, 0666);
    if (input < 0) {
        printf("open %s failed\n",argv[1]);
        return 1;
    }
    int output = open(argv[2],O_CREAT|O_TRUNC|O_WRONLY,0666);
    if (output < 0) {
        printf("open %s failed\n",argv[2]);
        return 1;
    }

    struct MatSize matSize;
    int *matVal = (int *)malloc(250000 * sizeof(int));

    //READ FROM A FILE
    if (read(input, &matSize, 8) != sizeof(matSize)) {
        printf("read failed\n");
        return -1;
    }
    if (read(input, matVal, (matSize.row * matSize.col) * 4) != -1); //return -1;
    close(input);

    //DO TRANSPOSE
    int tmp = matSize.row;
    matSize.row = matSize.col;
    matSize.col = tmp;

    int transpose[matSize.row][matSize.col];

    int count = 0;
    for(int i = 0; i < matSize.col; i++){
        for(int j = 0; j < matSize.row; j++, count++){
            transpose[j][i] = matVal[count];
        }
    }

    //WRITE TO A FILE
    if(write(output, &matSize, 8) != sizeof(matSize)){
        printf("write failed\n");
        return -1;
    }
    if(write(output, *transpose, (matSize.row * matSize.col) * sizeof(int)) != -1);// return -1;

    free(matVal);
    close(output);
    return 0;
}