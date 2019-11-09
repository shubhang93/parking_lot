package dataManager

import domain.Car
import domain.ParkingSpot

class InMemoryIParkingLot() : IParkingLot {
    private val availableSpots = mutableListOf<ParkingSpot>()
    private val occupiedSpots = mutableMapOf<ParkingSpot, Car>()
    private val licensePlateToCarMapping = mutableMapOf<String, ParkingSpot>()


    override fun createParkingLot(size: Int) {
        for (position in 1..size) {
            availableSpots.add(ParkingSpot(position))
        }
    }


    companion object {
        private var instance: InMemoryIParkingLot? = null
        fun invoke(): InMemoryIParkingLot {
            return if (instance == null) {
                instance = InMemoryIParkingLot()
                instance!!
            } else
                instance!!
        }
    }


    override fun getFreeSlots(): List<ParkingSpot> = availableSpots


    override fun getOccupiedSlots(): Map<ParkingSpot, Car> = occupiedSpots


    override fun park(car: Car): ParkingSpot? {
        return if (availableSpots.isNotEmpty()) {
            val parkingSpot = availableSpots.first()
            availableSpots.removeAt(0)
            occupiedSpots[parkingSpot] = car
            licensePlateToCarMapping[car.licensePlate] = parkingSpot
            return parkingSpot
        } else null

    }

    override fun unPark(parkingSpot: ParkingSpot): ParkingSpot {
        return if (occupiedSpots[parkingSpot] != null) {
            occupiedSpots.remove(parkingSpot)
            availableSpots.add(parkingSpot)
            availableSpots.sortBy { it.position }
            parkingSpot
        } else return parkingSpot
    }
}