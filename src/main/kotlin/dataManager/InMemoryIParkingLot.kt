package dataManager

import domain.Car
import domain.ParkingSpot

class InMemoryIParkingLot(capacity: Int) : IParkingLot {
    private val availableSpots = mutableListOf<ParkingSpot>()
    private val occupiedSpots = mutableMapOf<ParkingSpot, Car>()
    private val licensePlateToCarMapping = mutableMapOf<String, ParkingSpot>()

    init {
        for (spotPosition in 1..capacity) {
            availableSpots.add(ParkingSpot(spotPosition))
        }
    }

    companion object {
        private var instance: InMemoryIParkingLot? = null
        fun createParkingLot(capacity: Int): InMemoryIParkingLot {
            return if (instance == null) {
                instance = InMemoryIParkingLot(capacity)
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

    override fun unpark(parkingSpot: ParkingSpot): ParkingSpot {
        return if (occupiedSpots[parkingSpot] != null) {
            occupiedSpots.remove(parkingSpot)
            availableSpots.add(parkingSpot)
            availableSpots.sortBy { it.position }
            parkingSpot
        } else return parkingSpot
    }
}