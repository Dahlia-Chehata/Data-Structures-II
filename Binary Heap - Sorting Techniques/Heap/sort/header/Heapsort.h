#include <iostream>
#ifndef HEAP05_HEAPSORT_H
#define HEAP05_HEAPSORT_H
using namespace std;

class Heapsort {
public:
    Heapsort(int size);
    void sort(int *List, int siz);

private:
    int size;
};


#endif //HEAP05_HEAPSORT_H
