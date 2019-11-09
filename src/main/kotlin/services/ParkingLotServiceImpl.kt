package services

import dataManager.IParkingLot
import domain.Car
import domain.ParkingSpot

class ParkingLotService(parkingLot: IParkingLot) : IParkingLotService {
    override fun park(car: Car) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun unParkCar(parkingSpot: ParkingSpot) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getStatus(): List<Map<String, String>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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