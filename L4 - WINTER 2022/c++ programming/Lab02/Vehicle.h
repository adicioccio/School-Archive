//
//  Vehicle.h
//  Lab01
//
//  Created by Adam Di Cioccio on 2022-02-03.
//

#pragma once

#include <stdio.h>
#include <iostream>

class Vehicle {
private:
    int _w, _d;

public:
    Vehicle();

    Vehicle(int w);

    Vehicle(int w, int d);
    
    ~Vehicle();
    
    void setWheels(int w);
    int getWheels();
    
    void setDoors(int d);
    int getDoors();
    
    void printVehicle();
    
    Vehicle (Vehicle &);
    
    Vehicle (Vehicle *);

};


#ifndef Vehicle_h
#define Vehicle_h


#endif /* Vehicle_h */
