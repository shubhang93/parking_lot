data class ParkingSpot(val position: Int, val car: Car)
data class Car(val color: String, val licensePlate: String)

class ParkingLot(val capacity: Int) {
    val availableSpots = mutableListOf<ParkingSpot>()


    fun parkCar(car: Car) {

    }

}


fun main() {

}