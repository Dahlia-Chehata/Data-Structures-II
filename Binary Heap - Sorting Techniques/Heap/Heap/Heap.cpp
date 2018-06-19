#include <iostream>
#include "Heap.h"

using namespace std;

template <class object>
Heap<object>::Heap(int heapArrayLength) {
    this-> heapArrayLength = heapArrayLength;
    heapArray = new int[heapArrayLength + 1]; // +1 bec we start from index 1 not 0
    heapSize = 0;
}

template <class object>
void Heap<object>::insertIntoHeap(object no) {
    if (heapSize == heapArrayLength) { // heap full
        throw std::exception();
    } else {
        heapSize++;
        heapArray[heapSize] = no;
        HeapifyUp(heapSize);


    }

}

template <class object>
object Heap<object>::extractMax() { // could be template not int <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<,
    object reqNode = heapArray[1];
    heapArray[1] = heapArray[heapSize]; // swapping node 1 with last element
    heapSize--; //delete last element
    HeapifyDown(1);
    return reqNode;

}


/**
to update the tree
*/
template <class object>
void Heap<object>::HeapifyDown(int index)
{
    int LeftIndex =getLeftChildIndex(index);
    int RightIndex=getRightChildIndex(index);
    int temp=index;
    if (LeftIndex <= heapSize&& heapArray[LeftIndex]>heapArray[index])
        temp=LeftIndex;
    if (RightIndex <= heapSize && heapArray[RightIndex]>heapArray[temp])
        temp=RightIndex;
    if (temp!=index)
    {
        swap(heapArray[index],heapArray[temp]);
        HeapifyDown(temp);
    }
}


/**
to build the tree
*/
template <class object>
void Heap<object>::HeapifyUp(int index)
{
    if (index > 1 && heapArray[getParentIndex(index)]< heapArray[index])
    {
        swap(heapArray[index],heapArray[getParentIndex(index)]);
        HeapifyUp(getParentIndex(index));
    }
}

template <class object>
void Heap<object>::setHeapSize(int no) {
//    heapSize = no;
//    cout << "hello";
}


template <class object>
void Heap<object>::buildMaxHeap(object arrayToBeBuilt[], int sizeOfArray) {
    //copies the array
    for (int i = 0; i < sizeOfArray; i++) {
        heapArray[i+1] = arrayToBeBuilt[i];
    }
    //  memcpy (heapArray, arrayToBeBuilt, sizeOfArray);
    for (int k = sizeOfArray/2; k > 0; k--)
    {
        HeapifyDown(k);
    }
    heapSize = sizeOfArray;
}


template <class object>
int Heap<object>::getParentIndex(int nodeNo) {
    return nodeNo / 2;
}
template <class object>
int Heap<object>::getLeftChildIndex(int nodeNo) {
    return nodeNo * 2;

}
template <class object>
int Heap<object>::getRightChildIndex(int nodeNo) {
    return (nodeNo * 2) + 1;

}

template <class object>
object* Heap<object>::getHeapArray() {
    return heapArray;
}

template <class object>
int Heap<object>::getHeapArrayLength() {
    return heapArrayLength;
}

template <class object>
int Heap<object>::getHeapsize() {
    return heapSize;
}

template <class object>
Heap<object>::~Heap()
{
    //dtor
}




