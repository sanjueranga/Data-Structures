#include <iostream>

int main() {
    const int n = 7;
    double datapoints[n] = {2.5, 19.7, 8.95, 11.0, 28.4, 7.11, 4.16};
    double reversed[n];

    for (int i = 0; i < n; i++) {
        reversed[i] = datapoints[n - 1 - i];
    }

    for (int i = 0; i < n; i++) {
        std::cout << reversed[i] << "\n";
    }
    return 0;
}
