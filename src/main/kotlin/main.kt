import constants.CREATE_COMMAND_REGEX
import constants.PARK_COMMAND_REGEX
import dataManager.InMemoryIParkingLot
import services.ParkingLotService


fun parseCommand(userInput: String): Pair<String, String> {
    val (cmd, argument) = userInput.split(" ")
    return Pair(cmd, argument)
}


fun runInteractiveCli(parkingLotService: ParkingLotService) {
    loop@ while (true) {
        val userInput: String? = readLine()
        if (userInput != null)
            when {
                (userInput == "exit") -> break@loop
                (userInput.matches(CREATE_COMMAND_REGEX)) -> {

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
            println("Welcome To Interactive Mode, awaiting User Input: ")
            runInteractiveCli(parkingLotService)
        }
    }
}