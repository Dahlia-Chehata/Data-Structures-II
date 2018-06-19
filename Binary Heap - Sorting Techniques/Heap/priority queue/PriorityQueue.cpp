#include "PriorityQueue.h"

template <class object>
PriorityQueue<object>::PriorityQueue(int size) {
    heap = new Heap<object>(size);
}

template <class object>
void PriorityQueue<object>::push(object no) {
    heap->insertIntoHeap(no);
}

template <class object>
object PriorityQueue<object>::pop() {
    return heap->extractMax();
}

template <class object>
object *PriorityQueue<object>::getArray() {
    return heap->getHeapArray();
}
template <class object>
int PriorityQueue<object>::getSize() {
    return heap->getHeapsize();
}
