
#include "header/MergeSort.h"

MergeSort::MergeSort(int siz) {
    this -> siz = siz;
}
/**
 * merge sort
 * @param low
 * @param high
 */
void MergeSort::sort(int *List, int low, int high) {
    if (low < high) {
        int mid = (low + high)/2;
        sort(List,low, mid);
        sort(List,mid + 1, high);
        merge(List,low, mid, high);
    }

}

void MergeSort::merge(int *List, int low, int mid, int high) {
    int h = low, i = low, j = mid+1, k;

    int aux [siz] ;

    while ((h <= mid) && (j <= high)) {
        if (List[h] <= List[j]) {
            aux[i] = List[h];
            h++;
        } else {
            aux[i] = List[j];
            j++;
        }
        i++;
    }

    if (h > mid) {
        for (k=j; k<=high; k++) {
            aux[i] = List[k];
            i++;
        } } else {
        for (k=h; k<=mid; k++) {
            aux[i] = List[k];
            i++;
        }
    }
    for (k=low; k<=high; k++)
        List[k] = aux[k];

}
