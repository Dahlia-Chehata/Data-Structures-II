//#ifndef HEAP05_BUBBLESORT_H
//#define HEAP05_BUBBLESORT_H

#include "BubbleSort.h"
#include "QuickSort.h"
#include "MergeSort.h"
#include "SelectionSort.h"
#include "InsertionSort.h"

class Sort {
public:
    Sort(int size);
    void bubbleSort(int *list, int size);
    void selectionSort(int list[], int size);
    void insertionSort(int list[], int size);
    void mergeSort(int list[], int size);
    void quickSort(int arr[], int size);
    void heapSort(int list[], int size);

private:
    int size;
public:
    int getSize() const;

};

//#endif //HEAP05_BUBBLESORT_H
