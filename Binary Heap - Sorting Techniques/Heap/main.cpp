#include <iostream>
#include "Heap/Heap.h"
#include "Heap/Heap.cpp"
#include "sort/header/Sort.h"
#include "priority queue/PriorityQueue.h"
#include "priority queue/PriorityQueue.cpp"

using namespace std;
template <class object>

class Main {
//    to test heap implementation
public:
    void printArray(object *Array, int length) {
        cout << "\n size of array = " << length <<"\n";
        for (int i = 1; i <= length; i++) {
            cout << Array[i] <<"\n";

        }
    }

};


    int main() {
        Main<int> m;
        Heap<int> heap(60);


//        priority queue :
        cout << "QUEUE \n";
        PriorityQueue<int> pq(50);
        pq.push(30);
        pq.push(8);
        pq.push(74);
        pq.push(694);
        m.printArray(pq.getArray(),pq.getSize());
        cout <<"\n max element is : " << pq.pop();
        m.printArray(pq.getArray(),pq.getSize());
        cout <<"\n max element is : " << pq.pop();
        m.printArray(pq.getArray(),pq.getSize());
        cout <<"\n max element is : " << pq.pop();
        m.printArray(pq.getArray(),pq.getSize());



// INSERT
        heap.insertIntoHeap(3);
        m.printArray(heap.getHeapArray(), heap.getHeapsize());
        cout << "\n --------------------------------";
        heap.insertIntoHeap(10);
        m.printArray(heap.getHeapArray(), heap.getHeapsize());
        cout << "\n --------------------------------";
        heap.insertIntoHeap(2);
        m.printArray(heap.getHeapArray(), heap.getHeapsize());
        cout << "\n --------------------------------";
        heap.insertIntoHeap(20);
        m.printArray(heap.getHeapArray(), heap.getHeapsize());
        cout << "\n --------------------------------";
        heap.insertIntoHeap(15);
        m.printArray(heap.getHeapArray(), heap.getHeapsize());
        cout << "\n --------------------------------";

// BUILD
        cout << "\n BUILDING HEAP \n";
        int A[5] = {1,12,70,85,3};
        heap.buildMaxHeap(A, 5);
        m.printArray(heap.getHeapArray(), heap.getHeapsize());

// insert after build

        heap.insertIntoHeap(20);
        m.printArray(heap.getHeapArray(), heap.getHeapsize());
        cout << "\n --------------------------------";
        heap.insertIntoHeap(15);
        m.printArray(heap.getHeapArray(), heap.getHeapsize());
        cout << "\n --------------------------------";

// EXTRACT
        cout << "\n max extracted is : " << (int) heap.extractMax();
        m.printArray(heap.getHeapArray(), heap.getHeapsize());
        cout << "\n --------------------------------";
        cout << "\n max extracted is : " << (int) heap.extractMax();
        m.printArray(heap.getHeapArray(), heap.getHeapsize());
        cout << "\n --------------------------------";
        cout << "\n max extracted is : " << (int) heap.extractMax();
        m.printArray(heap.getHeapArray(), heap.getHeapsize());
        cout << "\n --------------------------------";


//        SORTING

        cout << " \n SORTING :: \n" ;
        int arr[] = {-1, 10, -999, 20, 1, 2, 3, -100, 200, 20000, 99999, -99999};
    int size = sizeof(arr)/sizeof(*arr);
    Sort x(size);
        cout << "bubble sort : ";
    x.bubbleSort(arr,size);
    for (int i=0;i<x.getSize();i++)
        cout<<arr[i]<<",";
    cout<<"\n";
        cout << "insertion sort : ";
    x.insertionSort(arr,size);
    for (int i=0;i<x.getSize();i++)
        cout<<arr[i]<<",";
    cout<<"\n";
        cout << "megerSort sort : ";
    x.mergeSort(arr,size);
    for (int i=0;i<x.getSize();i++)
        cout<<arr[i]<<",";
    cout<<"\n";
        cout << "quick sort : ";
    x.quickSort(arr,size);
    for (int i=0;i<x.getSize();i++)
        cout<<arr[i]<<",";
    cout<<"\n";
        cout << "selection sort : ";
    x.selectionSort(arr,size);
    for (int i=0;i<x.getSize();i++)
        cout<<arr[i]<<",";
    cout<<"\n";
        cout << "heap sort : ";
    x.heapSort(arr,size);
    for (int i=0;i<x.getSize();i++)
        cout<<arr[i]<<",";
    cout<<"\n";

        return 0;
    }
