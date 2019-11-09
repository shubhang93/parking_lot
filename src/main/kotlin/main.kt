import constants.CREATE_COMMAND_REGEX
import constants.PARK_COMMAND_REGEX
import dataManager.InMemoryIParkingLot
import services.ParkingLotService


fun commandParser(userInput: String, regex: Regex): List<String> {
    val match = regex.find(userInput)
    return if (match != null) return match.groupValues.joinToString(" ").split(" ") else emptyList()
}


fun runInteractiveCli() {
    loop@ while (true) {
        val userInput: String? = readLine()
        if (userInput != null)
            when {
                (userInput == "exit") -> break@loop
                (userInput.matches(CREATE_COMMAND_REGEX)) -> {
                    val (_, capacity) = commandParser(userInput, CREATE_COMMAND_REGEX)
                    println(capacity)
                    val parkingLot = InMemoryIParkingLot.createParkingLot(capacity.toInt())
                    println("Created a parking lot with $capacity slots")

                }
                (userInput.matches(PARK_COMMAND_REGEX)) -> println("$userInput")
                else -> println("Invalid Command, please try again")

            }

    }
}

fun main(args: Array<String>) {
    val parkingLotService = ParkingLotService(InMemoryIParkingLot.createParkingLot(6))
    when (args.size) {

        1 -> {
            // Read Commands from file
        }
        else -> {
            // Interactive Mode
            println("Welcome To Interactive Mode, Enter exit to quit the Interactive Mode: ")
            runInteractiveCli()
        }
    }
}