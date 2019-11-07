package services

import domain.Car
import domain.ParkingSpot

interface ParkingLotService {
    fun park(car: Car)

    fun unParkCar(parkingSpot: ParkingSpot)

    fun getStatus(): List<Map<String, String>>

    fun getSlotsByCarColor(color: String): List<Car>

    fun getSlotsByCarLicensePlate(licensePlate: String): List<Car>

    fun isParkingLotFull(): Boolean


}