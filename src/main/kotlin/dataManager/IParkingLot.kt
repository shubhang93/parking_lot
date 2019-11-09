package dataManager

import domain.Car
import domain.ParkingSpot

interface IParkingLot {
    fun park(car: Car): ParkingSpot?
    fun unPark(parkingSpot: ParkingSpot): ParkingSpot
    fun getOccupiedSlots(): Map<ParkingSpot, Car>
    fun getFreeSlots(): List<ParkingSpot>
}