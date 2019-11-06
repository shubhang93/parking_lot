data class ParkingSpots(val position: Int, val car: Car)
data class Car(val color: String, val licensePlate: String)

class ParkingLot(val capacity: Int) {
    val availableSpots = mutableListOf<ParkingSpots>()


    fun parkCar(car: Car) {

    }

}


fun main() {

}