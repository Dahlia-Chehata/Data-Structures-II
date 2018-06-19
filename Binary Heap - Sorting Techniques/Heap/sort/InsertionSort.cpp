#include "header/InsertionSort.h"

InsertionSort::InsertionSort(int siz) {
    this -> siz = siz;
}

int InsertionSort::sort(int *List, int siz) {
    if (siz <= 1) {
        return siz;
    }
    siz = sort(List, siz -1);
    int key = List[siz];
    int i = siz - 1;
    while ((i >= 0) && (List[i] > key)) {
        List[i+1] = List[i];
        i--;
    }
    List[i+1] = key;
    return siz + 1;
}

