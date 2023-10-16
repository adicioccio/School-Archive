//
//  main.cpp
//  Lab01
//
//  Created by Adam Di Cioccio on 2022-01-24.
//

#include "Vehicle.h"

using namespace std;

void CreateVehicle(Vehicle &v, int w = 10, int d = 8) {
    v.setWheels(w);
    v.setDoors(d);
}

int main(int argc, const char * argv[]) {
    
    Vehicle original ; //empty constructor no ( )
    Vehicle copy(original); // copy constructor by reference
    Vehicle secondCopy( &original ); //copy constructor by pointer
    copy.printVehicle ();
    
    CreateVehicle(copy, 3); //wheels is 3, everything else is default
    copy.printVehicle();
    CreateVehicle(copy, 3, 6); //wheels is 3, doors is 6
    copy.printVehicle ();
    copy = secondCopy;
    copy.printVehicle(); // copy is same as second copy
    return 0;
    
    
    
}



