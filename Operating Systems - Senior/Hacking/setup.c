#include <stdio.h>

void setup(){
    int check(char * password);
    unsigned char *p = (unsigned char *)&check;
    p[33] = 1;
}