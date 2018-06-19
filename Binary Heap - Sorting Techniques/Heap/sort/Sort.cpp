#include "header/Sort.h"
#include "header/Heapsort.h"

Sort::Sort(int size) {
    this -> size = size;
}

void Sort::bubbleSort(int *list, int siz) {
    BubbleSort bubbleSort(siz);
    bubbleSort.sort(list,siz);
}

void Sort::selectionSort(int *list, int siz) {
    SelectionSort selectionSort(siz);
    selectionSort.sort(list,0);
}

void Sort::insertionSort(int *list, int siz) {
    InsertionSort insertionSort(siz);
    insertionSort.sort(list, siz);
}
void Sort::mergeSort(int list[], int siz) {
    MergeSort mergeSort(siz);
    mergeSort.sort(list,0,siz-1);
}


void Sort::quickSort(int arr[], int siz) {
    QuickSort quickSort(siz);
    quickSort.quickSort(arr, 0, siz-1);
}

void Sort::heapSort(int *list,int siz) {
    Heapsort heapsort(siz);
    heapsort.sort(list,siz);


}

int Sort::getSize() const {
    return size;
}



