#include "header/SelectionSort.h"
#include <iostream>
using namespace std;

SelectionSort::SelectionSort(int siz) {
    this -> siz = siz;
}

void SelectionSort::sort(int *list, int start) {
    if ( start >= siz - 1 )
        return;
    int minIndex = start;
    for ( int i = start + 1; i < siz; i++ ) {
        if (list[i] < list[minIndex] )
            minIndex = i;
    }
    swap(list[start],list[minIndex]);
    sort(list, start + 1);

}
