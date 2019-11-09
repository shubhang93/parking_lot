package services

import domain.Car
import domain.ParkingSpot

interface IParkingLotService {
    fun park(car: Car)

    fun unParkCar(parkingSpot: ParkingSpot)

    fun printStatus()

    fun printSlotsByColor(color: String)

    fun getSlotNumberByCarLicensePlate(licensePlate: String)

    fun getFreeSlotCount(): Int


}