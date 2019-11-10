package services

import domain.Car
import domain.ParkingSpot

interface IParkingLotService {
    fun park(car: Car)

    fun unParkCar(parkingSpot: ParkingSpot)

    fun printStatus()

    fun printSlotsByColor(color: String)

    fun printSlotNumberByLicensePlate(licensePlate: String)

    fun getFreeSlotCount(): Int

    fun printRegistrationNumbersForColor(color: String)


}