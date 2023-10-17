// Inheritance exercise: each genre pays artists a rate per song.
#include <iostream>

class Artist {
    int artistId;
    int numberOfSongs;

public:
    Artist(int id = 0, int songs = 0) : artistId(id), numberOfSongs(songs) {}
    int getArtistId() const { return artistId; }
    int getNumberOfSongs() const { return numberOfSongs; }
};

class Genre {
protected:
    int id = 0;
    int hourlyRate = 0;
    Artist artists[10];
    int artistCount = 0;

public:
    void addWork(int artistId, int songs) {
        if (artistCount == 10) return;
        artists[artistCount++] = Artist(artistId, songs);
    }

    int getPayment(int artistNo) const {
        for (int i = 0; i < artistCount; i++) {
            if (artists[i].getArtistId() == artistNo) {
                return artists[i].getNumberOfSongs() * hourlyRate;
            }
        }
        return 0;
    }
};

struct Rock : Genre { Rock() { id = 1; hourlyRate = 600; } };
struct EDM : Genre { EDM() { id = 2; hourlyRate = 800; } };
struct HipHop : Genre { HipHop() { id = 3; hourlyRate = 400; } };
struct Jazz : Genre { Jazz() { id = 4; hourlyRate = 500; } };
struct DeathMetal : Genre { DeathMetal() { id = 5; hourlyRate = 700; } };

int main() {
    Rock rock;
    EDM edm;
    HipHop hipHop;
    Jazz jazz;
    DeathMetal deathMetal;

    Genre* genres[] = {&rock, &edm, &hipHop, &jazz, &deathMetal};
    int artistNos[] = {1001, 2001, 3001, 4001, 5001, 6001};

    rock.addWork(1001, 8);
    rock.addWork(2001, 4);
    rock.addWork(3001, 3);

    edm.addWork(2001, 7);
    edm.addWork(3001, 5);
    edm.addWork(1001, 6);

    hipHop.addWork(1001, 5);
    hipHop.addWork(2001, 6);
    hipHop.addWork(4001, 4);

    jazz.addWork(6001, 8);
    jazz.addWork(4001, 6);
    jazz.addWork(5001, 7);

    deathMetal.addWork(5001, 5);
    deathMetal.addWork(3001, 7);
    deathMetal.addWork(6001, 4);

    for (int n : artistNos) {
        int salary = 0;
        for (Genre* g : genres) salary += g->getPayment(n);
        std::cout << n << "\n";
        std::cout << "Total Salary:" << salary << "\n";
    }
    return 0;
}
