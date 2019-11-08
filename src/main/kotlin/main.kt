import services.ParkingLotServiceImpl


val CREATE_COMMAND_REGEX = Regex("""create_parking_lot \d+""")
val PARK_COMMAND_REGEX = Regex("""park [a-zA-Z]{2}-\d{2}-[a-zA-Z]{2}-\d{4} [a-zA-Z]+""")
val UNPARK_COMMAND_REGEX = Regex("""leave \d+""")
val REG_NUMS_FOR_COLOR_QUERY = Regex("""registration_numbers_for_cars_with_colour [a-zA-Z]+""")
val SLOT_NUM_FOR_REG_NUM_QUERY = Regex("""slot_number_for_registration_number [a-zA-Z]+""")


fun runInteractiveCli(parkingLotServiceImpl: ParkingLotServiceImpl) {
    loop@ while (true) {
        val userInput: String? = readLine()
        if (userInput != null)
            when {
                (userInput == "exit") -> break@loop
                (userInput.matches(CREATE_COMMAND_REGEX)) -> println("$userInput")
                (userInput.matches(PARK_COMMAND_REGEX)) -> println("$userInput")
                else -> println("Invalid Command, please try again")

            }

    }
}

fun main(args: Array<String>) {
    val parkingService = ParkingLotServiceImpl.initializeParkingLot(6)
    when (args.size) {
        0 -> {
            // Interactive Mode
            println("Welcome To Interactive Mode, awaiting User Input: ")
            runInteractiveCli(parkingService)
        }
        1 -> {
            // Read Commands from file
        }
    }
}