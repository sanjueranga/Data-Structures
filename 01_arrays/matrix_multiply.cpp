#include <iostream>

int main() {
    int A[3][3] = {{2, 5, 8}, {4, 8, 3}, {9, 1, 6}};
    int B[3][3] = {{1, 7, 9}, {6, 4, 5}, {2, 8, 3}};
    int C[3][3];

    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            int sum = 0;
            for (int k = 0; k < 3; k++) {
                sum += A[i][k] * B[k][j];
            }
            C[i][j] = sum;
        }
    }

    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            std::cout << C[i][j] << " ";
        }
        std::cout << "\n";
    }
    return 0;
}
