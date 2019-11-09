package services

import domain.Car
import domain.ParkingSpot

interface IParkingLotService {
    fun park(car: Car)

    fun unParkCar(parkingSpot: ParkingSpot)

    fun getStatus(): List<Map<String, String>>

    fun getSlotsByCarColor(color: String): List<Car>

    fun getSlotNumberByCarLicensePlate(licensePlate: String): Int?

    fun isParkingLotFull(): Boolean

    fun getFreeSlotCount(): Int

}