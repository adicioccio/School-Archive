//
//  Vehicle.h
//  Lab01
//
//  Created by Adam Di Cioccio on 2022-02-03.
//

#pragma once

#include <stdio.h>
#include <iostream>

using namespace std;

class Vehicle {
private:
    int _w, _d;

public:
    
    int getW();
    int getD();
    
    void setW(int w);
    void setD(int d);
    
    Vehicle();

    Vehicle(int w);

    Vehicle(int w, int d);
    
    ~Vehicle();
    
    void printVehicle();
    
    Vehicle(Vehicle &copy) {
        _w = copy.getW();
        _d = copy.getD();
    
    }
    
    Vehicle(Vehicle *copy) : Vehicle(*copy) {}
    
    //Vehicle (Vehicle &);
    
    //Vehicle (Vehicle *);
    
    //overload assignment operator
    Vehicle operator=(const Vehicle& v);
    
    //overload comparison operator equal
    bool operator==(const Vehicle& v);
    
    //overload comparison operator not equal
    bool operator!=(const Vehicle& v);
    
    //overload postfix inc and dec
    Vehicle operator++(int);
    Vehicle operator--(int);
    
    //overload prefix inc and dec
    Vehicle operator++();
    Vehicle operator--();
    
    friend ostream& operator << (ostream&, const Vehicle& v);
    
};


#ifndef Vehicle_h
#define Vehicle_h


#endif /* Vehicle_h */
