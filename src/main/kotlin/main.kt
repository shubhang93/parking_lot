data class ParkingSpot(val position: Int)
data class Car(val color: String, val licensePlate: String)

enum class Command(val command: String) {
    CREATE_PARKING_LOT("create_parking_lot"),
    PARK_CAR("park")
}


class ParkingLot(private val capacity: Int) {
    private val availableSpots = mutableListOf<ParkingSpot>()
    private val occupiedSpots = mutableMapOf<Car, ParkingSpot>()


    init {
        for (position in 0..capacity) {
            availableSpots.add(ParkingSpot(position))
        }
        availableSpots.sortBy { it.position }
    }

    private fun isParkingLotFull(): Boolean {
        return availableSpots.size == 0
    }


    fun parkCar(car: Car) {
        if (!isParkingLotFull()) {
            val parkingSpot = availableSpots.first()
            availableSpots.removeAt(0)
            occupiedSpots[car] = parkingSpot
            println("Allocated Slot Number ${parkingSpot.position}")
        } else
            println("Cannot Park call, all parking slots are full")
    }

    fun removeCar(position: Int) {

    }


}


fun main(args: Array<String>) {
    when (args.size) {
        0 -> {
            // Interactive Mode
        }
        1 -> {
            // Read Commands from file
        }
    }
}