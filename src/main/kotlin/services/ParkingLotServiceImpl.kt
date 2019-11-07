package services

import domain.Car
import domain.ParkingSpot

class ParkingLotServiceImpl(val capacity: Int) : ParkingLotService {

    private val availableSpots = mutableListOf<ParkingSpot>()
    private val occupiedSpots = mutableMapOf<ParkingSpot, Car>()
    private val licensePlateToCarMapping = mutableMapOf<String, ParkingSpot>()
    private var maxSlots: Int = 0


    init {
        for (spotPosition in 1..maxSlots) {
            availableSpots.add(ParkingSpot(spotPosition))
        }
    }


    companion object {
        lateinit var instance: ParkingLotServiceImpl
        fun initializeParkingLot(capacity: Int): ParkingLotServiceImpl {
            if (instance == null) {
                instance = ParkingLotServiceImpl(capacity)
                return instance
            } else return instance
        }
    }

    override fun park(car: Car) {
        if (!isParkingLotFull()) {
            val parkingSpot = availableSpots.first()
            availableSpots.removeAt(0)
            occupiedSpots[parkingSpot] = car
            licensePlateToCarMapping[car.licensePlate] = parkingSpot
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
        occupiedSpots.remove(parkingSpot)
        availableSpots.add(parkingSpot)
        availableSpots.sortBy { it.position }
        println("Slot Number ${parkingSpot.position} is free")
    }

    override fun getSlotsByCarColor(color: String): List<Car> {
        return occupiedSpots.filter { parkingSpotEntry -> parkingSpotEntry.value.color == color }.map { it.value }
    }

    override fun getSlotNumberByCarLicensePlate(licensePlate: String): Int? {
        return licensePlateToCarMapping[licensePlate]?.position
    }
}