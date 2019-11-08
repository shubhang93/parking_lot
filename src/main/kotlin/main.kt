import services.ParkingLotServiceImpl


val CREATE_COMMAND_REGEX = Regex("""create_parking_lot \d+""")
val PARK_COMMAND_REGEX = Regex("""park [a-zA-Z]{2}-\d{2}-[a-zA-Z]{2}-\d{4} [a-zA-Z]+""")


fun runInteractiveCli(parkingLotServiceImpl: ParkingLotServiceImpl) {
    loop@ while (true) {
        val userInput: String? = readLine()
        when {
            (userInput == "exit") -> break@loop

            else -> println("Invalid Command, please try again")

        }
    }
}

fun main(args: Array<String>) {
    val parkingService = ParkingLotServiceImpl.initializeParkingLot(6)
    when (args.size) {
        0 -> {
            // Interactive Mode
        }
        1 -> {
            // Read Commands from file
        }
    }
}