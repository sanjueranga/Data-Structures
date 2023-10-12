// Remove one entry from a 2D array of (name, value) pairs, then sort by value.
#include <iostream>
#include <string>
#include <utility>

int main() {
    std::string names[8][2] = {
        {"Cargils", "100000"}, {"Uniion Bank", "300000"}, {"Laugh Gas", "200000"},
        {"Odel", "400000"},    {"Melstacorp", "600000"},  {"Kingsbury", "150000"},
        {"Hemas", "250000"},   {"Brandix", "450000"}};

    std::string revised[7][2];
    int count = 0;
    for (int i = 0; i < 8; i++) {
        if (names[i][0] != "Melstacorp") {
            revised[count][0] = names[i][0];
            revised[count][1] = names[i][1];
            count++;
        }
    }

    for (int i = 0; i < count; i++) {
        for (int j = i + 1; j < count; j++) {
            if (std::stoi(revised[i][1]) > std::stoi(revised[j][1])) {
                std::swap(revised[i][0], revised[j][0]);
                std::swap(revised[i][1], revised[j][1]);
            }
        }
    }

    for (int i = 0; i < count; i++) {
        std::cout << revised[i][0] << ":" << revised[i][1] << "\n";
    }
    return 0;
}
