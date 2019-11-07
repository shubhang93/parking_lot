package services

import domain.Car
import domain.ParkingSpot

class ParkingServiceImpl:ParkingLotService {
    override fun park(car: Car) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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