
#ifndef HEAP05_MERGESORT_H
#define HEAP05_MERGESORT_H


class MergeSort {
public:

    MergeSort(int siz);
    void sort(int List[],int low, int high);

private:
    void merge(int List[],int low, int mid, int high);
    int siz;



};


#endif //HEAP05_MERGESORT_H
