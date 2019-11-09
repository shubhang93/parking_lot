package domain

interface IParkingLot {
    fun park(car: Car): ParkingSpot?
    fun unpark()
    fun getOccupiedSlots(): Map<ParkingSpot, Car>
    fun getFreeSlots(): List<ParkingSpot>
}