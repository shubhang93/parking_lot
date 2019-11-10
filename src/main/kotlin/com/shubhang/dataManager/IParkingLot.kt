package com.shubhang.dataManager

import com.shubhang.domain.Car
import com.shubhang.domain.ParkingSpot

interface IParkingLot {
    fun park(car: Car): ParkingSpot?
    fun unPark(parkingSpot: ParkingSpot): ParkingSpot
    fun getOccupiedSlots(): Map<ParkingSpot, Car>
    fun getFreeSlots(): List<ParkingSpot>
    fun createParkingLot(size: Int)
    fun resetParkingLot()
}