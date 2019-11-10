package services

import dataManager.IParkingLot
import domain.Car
import domain.ParkingSpot

class ParkingLotService(private val parkingLot: IParkingLot) : IParkingLotService {

    private val headerSpacing = " ".repeat(4)
    private val firstColSpacing = " ".repeat(11)
    private val lastColSpacing = " ".repeat(6)

    fun createParkingLot(capacity: Int) {
        parkingLot.createParkingLot(capacity)
    }


    override fun park(car: Car) {
        val parkingSpot = parkingLot.park(car)
        if (parkingSpot != null) println("Allocated slot number: ${parkingSpot.position}")
        else println("Sorry, parking lot is full")
    }

    override fun unParkCar(parkingSpot: ParkingSpot) {
        val freeSpot = parkingLot.unPark(parkingSpot)
        println("Slot number ${freeSpot.position} is free")
    }


    override fun printStatus() {
        val header = "Slot No.${headerSpacing}Registration No${headerSpacing}Colour"
        val rows = parkingLot.getOccupiedSlots()
            .map { (parkingSpot, car) ->
                "${parkingSpot.position}${firstColSpacing}${car.licensePlate}${lastColSpacing}${car.color}"
            }.joinToString("\n")
        println(header + "\n" + rows)
    }

    override fun printSlotsByColor(color: String) {
        val slotsAsCSV = parkingLot.getOccupiedSlots()
            .filter { (_, car) -> car.color == color }
            .map { (parkingSpot, _) -> parkingSpot.position }
            .joinToString(", ")
        println(slotsAsCSV)
    }

    override fun printSlotNumberByLicensePlate(licensePlate: String) {
        val parkingSpot = parkingLot.getOccupiedSlots()
            .filter { (_, car) -> car.licensePlate == licensePlate }
            .map { (parkingSpot, _) -> parkingSpot }
            .firstOrNull()
        if (parkingSpot != null) {
            println(parkingSpot.position)
        } else println("Not found")

    }

    override fun getFreeSlotCount() = parkingLot.getFreeSlots().size

    override fun printRegistrationNumbersForColor(color: String) {
        val licensePlateNumbersAsCSV = parkingLot.getOccupiedSlots().filter { (_, car) -> car.color == color }
            .map { (_, car) -> car.licensePlate }
            .joinToString(", ")
        println(licensePlateNumbersAsCSV)
    }

}