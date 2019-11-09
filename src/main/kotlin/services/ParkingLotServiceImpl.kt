package services

import dataManager.IParkingLot
import domain.Car
import domain.ParkingSpot

class ParkingLotService(private val parkingLot: IParkingLot) : IParkingLotService {

    private val headerSpacing = " ".repeat(4)
    private val rowSpacing = " ".repeat(11)

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
        println(header + rows)
    }

    override fun printSlotsByColor(color: String) {
        val slotsAsCSV = parkingLot.getOccupiedSlots()
            .filter { it.value.color == color }
            .map { it.key.position }
            .joinToString(",")
        println(slotsAsCSV)
    }

    override fun getSlotNumberByCarLicensePlate(licensePlate: String) {
        val slotsAsCSV = parkingLot.getOccupiedSlots()
            .filter { it.value.licensePlate == licensePlate }
            .map { it.key.position }
            .joinToString { "," }
        println(slotsAsCSV)
    }

    override fun getFreeSlotCount() = parkingLot.getFreeSlots().size


}