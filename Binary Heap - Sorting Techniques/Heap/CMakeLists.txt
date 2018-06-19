# cmake_minimum_required(VERSION <specify CMake version here>)
project(heap05)

set(CMAKE_CXX_STANDARD 11)

set(SOURCE_FILES main.cpp Heap/Heap.cpp Heap/Heap.h sort/Sort.cpp sort/header/Sort.h sort/MergeSort.cpp sort/header/MergeSort.h sort/QuickSort.cpp sort/header/QuickSort.h sort/BubbleSort.cpp sort/header/BubbleSort.h sort/SelectionSort.cpp sort/header/SelectionSort.h sort/InsertionSort.cpp sort/header/InsertionSort.h "priority queue/PriorityQueue.cpp" "priority queue/PriorityQueue.h" sort/Heapsort.cpp sort/header/Heapsort.h)
add_executable(heap05 ${SOURCE_FILES})