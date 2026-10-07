# Data Structures

Coursework for a university Data Structures module (arrays, linked lists, queues,
stacks, hash tables, binary search trees, DFS/BFS, tree node deletion).

The coursework itself was done in **Java**. The lab sheets and the Java solutions
are university material, so they are not published here.

In parallel I worked through the same exercises in **C++** to learn the language
and to get a feel for manual memory management. That is what this repository
contains. Each program is a single file with its own `main`, and the ported
versions clean up after themselves (destructors, no leaks).

## Contents

| Folder | Topic |
| --- | --- |
| `01_arrays` | array exercises: reverse, matrix multiply, sort, book list, inheritance |
| `02_linked_list` | singly linked list (`LinkedList.h/.cpp` + `main.cpp`), list operations, shopping cart |
| `03_queues` | linked-list queue, vehicle service queue |
| `04_stacks` | linked-list stack, postfix to infix |
| `05_hash_tables` | hash tables with chaining |
| `06_bst` | binary search tree, traversals, search |
| `07_dfs_bfs` | depth-first and breadth-first search |
| `08_bst_deletion` | deleting nodes from a BST |
| `09_assignment` | browser history (linked list + stack) |

## Build

```sh
g++ -std=c++17 -Wall 01_arrays/book_list.cpp -o book_list && ./book_list

# the linked list in 02_linked_list is split over several files
g++ -std=c++17 -Wall 02_linked_list/main.cpp 02_linked_list/LinkedList.cpp -o linkedlist
```
