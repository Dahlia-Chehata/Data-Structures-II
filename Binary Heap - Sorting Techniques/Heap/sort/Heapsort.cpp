
#include "header/Heapsort.h"
#include "../Heap/Heap.h"
#include "../Heap/Heap.cpp"

Heapsort::Heapsort(int size) {
    this -> size = size;

}

void Heapsort::sort(int *arrayToBeSorted, int sizeOfArray) {
    Heap<int> heap(sizeOfArray);
    heap.buildMaxHeap(arrayToBeSorted, sizeOfArray);

    for (int i = sizeOfArray - 1; i >= 0; i--) {
        swap(heap.getHeapArray()[0], heap.getHeapArray()[i]);
        int size = heap.getHeapsize();
        size--;
        heap.setHeapSize(size);
        heap.HeapifyDown(i);
    }
}

#include "header/Heapsort.h"
