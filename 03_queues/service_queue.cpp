// A service-centre queue: vehicles wait in line for their service.
#include <iostream>
#include <string>

struct Vehicle {
    std::string vin;
    std::string vType;
    std::string serviceType;
};

struct QueueNode {
    Vehicle data;
    QueueNode* next = nullptr;
    explicit QueueNode(const Vehicle& v) : data(v) {}
};

class Queue {
    QueueNode* front = nullptr;
    QueueNode* rear = nullptr;

    void enqueue(const Vehicle& v) {
        QueueNode* node = new QueueNode(v);
        if (!front) front = rear = node;
        else {
            rear->next = node;
            rear = node;
        }
    }

public:
    Queue() = default;
    Queue(const Queue&) = delete;
    Queue& operator=(const Queue&) = delete;

    ~Queue() {
        while (front) exitService();
    }

    void enterForService(const std::string& vin, const std::string& type, const std::string& service) {
        enqueue({vin, type, service});
    }

    void exitService() {
        if (!front) return;
        QueueNode* temp = front;
        front = front->next;
        if (!front) rear = nullptr;
        delete temp;
    }

    // How many vehicles are ahead of the given VIN.
    void inLine(const std::string& vin) const {
        int ahead = 0;
        for (QueueNode* cur = front; cur; cur = cur->next, ahead++) {
            if (cur->data.vin == vin) {
                std::cout << "Number of vehicles to be serviced : " << ahead << "\n";
                return;
            }
        }
        std::cout << "Vehicle " << vin << " is not in the queue\n";
    }

    void showQueue() const {
        for (QueueNode* cur = front; cur; cur = cur->next) {
            std::cout << " Vehicle Identification No: " << cur->data.vin << "\n";
            std::cout << " Vehicle type : " << cur->data.vType << "\n";
            std::cout << " Service type : " << cur->data.serviceType << "\n";
        }
    }
};

int main() {
    Queue q;
    q.enterForService("AB200", "SUV", "oil change");
    q.enterForService("CS250", "Van", "Body wash");
    q.enterForService("LK560", "Jeep", "full service");
    q.enterForService("NM301", "Car", "oil change");
    q.enterForService("LK900", "SUV", "Interior cleaning");

    q.inLine("LK560");
    q.showQueue();
    q.exitService();
    std::cout << "++++++++++++++++++++++++++++++++++++++++\n";
    q.showQueue();
    return 0;
}
