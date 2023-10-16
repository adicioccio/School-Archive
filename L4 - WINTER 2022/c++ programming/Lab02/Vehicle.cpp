//
//  Vehicle.cpp
//  Lab01
//
//  Created by Adam Di Cioccio on 2022-02-04.
//
#include "Vehicle.h"

using namespace std;

Vehicle::Vehicle(int w, int d) {
    _w = w;
    _d = d;
    cout << "In constructor with 2 parameters" << endl;
}

Vehicle::Vehicle(int w) : Vehicle(w, 0) {
    cout << "In constructor with 1 parameters, w = " << w << endl;
}

Vehicle::Vehicle() : Vehicle(0) {
    cout << "In constructor with 0 parameters" << endl;
}

Vehicle::~Vehicle() {
    cout << "In destructor" << endl;
}

void Vehicle::setWheels(int w) {
    _w = w;
}
    
int Vehicle::getWheels() {
    return _w;
}

void Vehicle::setDoors(int d) {
    _d = d;
}
int Vehicle::getDoors() {
    return _d;
}

void Vehicle::printVehicle() {
    cout << "VEHICLE: Wheels " << _w << " | Doors " << _d << endl;
}

Vehicle::Vehicle(Vehicle &copy) : Vehicle(copy._w, copy._d) {
    cout << "Inside reference to memory" << endl;
}

Vehicle::Vehicle(Vehicle *copy) : Vehicle(copy->_w, copy->_d) {
    cout << "Inside pointer to memory" << endl;
}




