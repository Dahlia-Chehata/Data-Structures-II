#include "header/BubbleSort.h"
#include <iostream>
using namespace std;
BubbleSort::BubbleSort(int siz) {
    this -> siz = siz;
}

void BubbleSort::sort(int *List, int siz) {
    if (siz == 1) {
        return ;
    }
    for (int i = 0; i < siz-1; i++) {
        if (List[i+1] < List[i]) {
            swap(List[i],List[i+1]);
        }
    }
    sort(List, siz - 1);}
