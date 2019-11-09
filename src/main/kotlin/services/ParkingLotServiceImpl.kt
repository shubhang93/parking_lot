package services

import dataManager.IParkingLot
import domain.Car
import domain.ParkingSpot

class ParkingLotService(val parkingLot: IParkingLot) : IParkingLotService {

    private val headerSpacing = " ".repeat(4)
    val rowSpacing = " ".repeat(11)

    override fun park(car: Car) {
        val parkingSpot = parkingLot.park(car)
        if (parkingSpot != null) println("Allocated slot number: ${parkingSpot.position}")
        else println("Sorry, parking lot is full")
    }

    override fun unParkCar(parkingSpot: ParkingSpot) {
        val freeSpot = parkingLot.unpark(parkingSpot)
        println("Slot number ${freeSpot.position} is free")
    }


    override fun printStatus() {
        val header = "Slot No.${headerSpacing}Registration No${headerSpacing}Colour\n"
        val rows = parkingLot.getOccupiedSlots().map {
            "${it.key.position}${rowSpacing}${it.value.licensePlate}${rowSpacing}${it.value.color}\n"
        }
    }

    override fun getSlotsByCarColor(color: String): List<Car> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getSlotNumberByCarLicensePlate(licensePlate: String): Int? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isParkingLotFull(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getFreeSlotCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}