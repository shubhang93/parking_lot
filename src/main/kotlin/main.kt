enum class Command(val command: String) {
    CREATE_PARKING_LOT("create_parking_lot"),
    PARK_CAR("park")
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