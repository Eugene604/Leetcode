#include <iostream>
#include "ArrayUtils.h"
using namespace std;


template <typename T>
void printArray(const T* arr, size_t size) {
    cout << "[";
    for (size_t i = 0; i < size; ++i) {
        cout << arr[i];
        if (i < size - 1) {
            cout << ", ";
        }
    }
    cout << "]" << endl;
}//end method

template void printArray<int>(const int*, size_t);


