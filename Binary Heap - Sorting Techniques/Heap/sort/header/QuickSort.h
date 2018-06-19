#ifndef HEAP05_QUICKSORT_H
#define HEAP05_QUICKSORT_H

class QuickSort {
public:
    int siz;
    QuickSort(int siz);
    void quickSort(int arr[], int left, int right);

private:
    int Partition(int arr[], int left, int right);

};


#endif //HEAP05_QUICKSORT_H
