#ifndef HEAP_H
#define HEAP_H


template <class object>

class Heap
{

public:
    Heap(int heapArrayLength);
    void insertIntoHeap(object no);
    object extractMax();
    void HeapifyUp(int index);
    void HeapifyDown(int index);
    void buildMaxHeap(object arrayToBeBuilt[], int sizeOfArray);
    object* getHeapArray();
    int getHeapArrayLength();
    int getHeapsize();
    void setHeapSize(int no);

    virtual ~Heap();

private:
    int heapArrayLength; // length of the array
    int heapSize; // no of elements stored in the heap
    object *heapArray;
    int getParentIndex(int nodeNo);
    int getLeftChildIndex(int nodeNo);
    int getRightChildIndex(int nodeNo);

};


#endif // HEAP_H
