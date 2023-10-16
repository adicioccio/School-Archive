//
//  Vehicle.cpp
//  Lab01
//
//  Created by Adam Di Cioccio on 2022-02-04.
//
#include "Vehicle.h"

using namespace std;

int Vehicle::getD() {
    return _d;
}

int Vehicle::getW() {
    return _w;
}

void Vehicle::setD(int d) {
    _d = d;
}

void Vehicle::setW(int w) {
    _w = w;
}

Vehicle::Vehicle(int w, int d) {
    _w = w;
    _d = d;
    //cout << "In constructor with 2 parameters" << endl;
}

Vehicle::Vehicle(int w) : Vehicle(w, 8) {
    //cout << "In constructor with 1 parameters, w = " << w << endl;
}

Vehicle::Vehicle() : Vehicle(8) {
    //cout << "In constructor with 0 parameters" << endl;
}

Vehicle::~Vehicle() {
    //cout << "In destructor" << endl;
}

void Vehicle::printVehicle() {
    cout << "VEHICLE: Wheels " << _w << " | Doors " << _d << endl;
}

//overload assignment operator
Vehicle Vehicle::operator=(const Vehicle& v) {
    _d = v._d;
    _w = v._w;
    return *this;
}

//overload comparison operator
bool Vehicle::operator==(const Vehicle& v) {
    return (_d == v._d && _w == v._w);
}

bool Vehicle::operator!=(const Vehicle& v) {
    return (_d != v._d && _w != v._w);
}

//overload postfix dec
Vehicle Vehicle::operator--() {
    --_w;
    --_d;
    return *this;
}

//overload postfix inc
Vehicle Vehicle::operator++() {
    ++_w;
    ++_d;
    return *this;
}

//overload prefix dec
Vehicle Vehicle::operator--(int) {
    Vehicle v(*this);
    _w--;
    _d--;
    return v;
}

//overload prefix inc
Vehicle Vehicle::operator++(int) {
    Vehicle v(*this);
    _w++;
    _d++;
    return v;
}

ostream& operator << (ostream&, const Vehicle& v) {
    return cout << "VEHICLE: Wheels " << v._w << " | Doors " << v._d << endl;
}




