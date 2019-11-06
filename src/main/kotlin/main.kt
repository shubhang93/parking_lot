data class ParkingSpot(val position: Int, val car: Car)
data class Car(val color: String, val licensePlate: String)

enum class Command(val command: String) {
    CREATE_PARKING_LOT("create_parking_lot"),
    PARK_CAR("park")
}


class ParkingLot(private val capacity: Int) {
    private val availableSpots = mutableListOf<ParkingSpot>()

    fun isParkingLotFull(): Boolean {
        return availableSpots.size == capacity
    }

    fun parkCar(car: Car) {
        val parkingSpot = ParkingSpot(1, car)
        availableSpots.add(parkingSpot)
        println("Parking Car with License Plate: ${car.licensePlate} and color: ${car.color} at position ${parkingSpot.position}")
    }

}


fun main(args: Array<String>) {

}