#include "header/QuickSort.h"
#include <iostream>
using namespace std;
QuickSort::QuickSort(int siz) {
    this -> siz = siz;
}

/**
  * Quick sort
  * @param arr
  * @param left
  * @param right
  */
void QuickSort::quickSort(int *arr, int left, int right) {
    int pivot = Partition(arr, left, right);
    if (left < pivot - 1)
        quickSort(arr, left, pivot - 1);
    if (pivot < right)
        quickSort(arr, pivot, right);
}

/**
 * computing pivot for quick sort
 * @param arr
 * @param left
 * @param right
 * @return
 */
int QuickSort::Partition(int *arr, int left, int right) {
    int pivot = arr[(left + right) / 2];
    while (left <= right) {
        while (arr[left] < pivot)
            left++;
        while (arr[right] > pivot)
            right--;
        if (left <= right) {
            swap(arr[left],arr[right]);
            left++;
            right--;
        }
    }
    return left;
}
