// Insert a value into the first free slot of a fixed-size array.
#include <iostream>

int main() {
    const int size = 5;
    int value = 4;
    int array[size] = {0};

    bool inserted = false;
    for (int i = 0; i < size; i++) {
        if (array[i] == 0) {
            array[i] = value;
            inserted = true;
            break;
        }
    }
    if (!inserted) std::cout << "array is full\n";

    for (int i = 0; i < size; i++) std::cout << array[i] << "\n";
    return 0;
}
