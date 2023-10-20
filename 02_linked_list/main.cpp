#include "LinkedList.h"
#include <iostream>

int main()
{

    LinkedList list;
    list.append(10);
    list.append(20);
    list.append(30);

    // show memory usage at this point now
    std::cout << "Memory usage: " << sizeof(list) << " bytes\n";

    list.printList();

    return 0;
}