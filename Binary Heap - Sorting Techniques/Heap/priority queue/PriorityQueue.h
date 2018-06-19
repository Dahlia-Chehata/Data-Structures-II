

#ifndef HEAP05_PRIORITYQUEUE_H
#define HEAP05_PRIORITYQUEUE_H


#include <queue>
#include "../Heap/Heap.h"

template <class object>
class PriorityQueue{
public:
    PriorityQueue(int size);
    void push(object no);
    object pop();
    object* getArray();
    int getSize();


private:
    Heap<object>* heap;
    int size;


};


#endif //HEAP05_PRIORITYQUEUE_H
