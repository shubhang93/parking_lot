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

    }

    override fun isParkingLotFull(): Boolean {

    }

    override fun getStatus(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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