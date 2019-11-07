package services

import domain.Car
import domain.ParkingSpot

object ParkingServiceImpl : ParkingLotService {

    private val availableSpots = mutableListOf<ParkingSpot>()
    private val occupiedSpots = mutableMapOf<ParkingSpot, Car>()
    private var maxSlots: Int = 0

    fun createParkingLot(capacity: Int) {
        maxSlots = capacity
        for (spotPosition in 1..maxSlots) {
            availableSpots.add(ParkingSpot(spotPosition))
        }
    }

    override fun park(car: Car) {
        if (!isParkingLotFull()) {
            val parkingSpot = availableSpots.first()
            availableSpots.removeAt(0)
            occupiedSpots[parkingSpot] = car
            println("Allocated Slot Number ${parkingSpot.position}")
        } else
            println("Cannot Park Car, all parking slots are full")
    }

    override fun isParkingLotFull(): Boolean {
        return availableSpots.size == 0
    }

    override fun getStatus(): List<Map<String, String>> {
        return occupiedSpots.map { parkingSpotEntry ->
            mapOf(
                "slotNumber" to "${parkingSpotEntry.key.position}",
                "registrationNumber" to parkingSpotEntry.value.licensePlate,
                "color" to parkingSpotEntry.value.color
            )
        }.sortedBy { it["slotNumber"] }
    }

    override fun unParkCar(parkingSpot: ParkingSpot) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getSlotsByCarColor(color: String): List<Car> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getSlotsByCarLicensePlate(licensePlate: String): List<Car> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}