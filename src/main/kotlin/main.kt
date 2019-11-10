import constants.*
import dataManager.InMemoryIParkingLot
import domain.Car
import domain.ParkingSpot
import services.ParkingLotService


fun commandParser(userInput: String, regex: Regex): List<String> {
    val match = regex.find(userInput)
    return if (match != null) return match.groupValues.joinToString(" ").split(" ") else emptyList()
}


fun runInteractiveCli(parkingLotService: ParkingLotService) {
    loop@ while (true) {
        val userInput: String? = readLine()
        if (userInput != null)
            when {
                (userInput == "exit") -> break@loop
                (userInput.matches(CREATE_COMMAND_REGEX)) -> {
                    val (_, capacity) = commandParser(userInput, CREATE_COMMAND_REGEX)
                    parkingLotService.createParkingLot(capacity.toInt())
                    println("Created a parking lot with $capacity slots")

                }
                (userInput.matches(PARK_COMMAND_REGEX)) -> {
                    val (_, licensePlate, color) = commandParser(userInput, PARK_COMMAND_REGEX)
                    parkingLotService.park(Car(color, licensePlate))

                }
                (userInput.matches(UNPARK_COMMAND_REGEX)) -> {
                    val (_, slotNumber) = commandParser(userInput, UNPARK_COMMAND_REGEX)
                    parkingLotService.unParkCar(ParkingSpot(slotNumber.toInt()))
                }
                (userInput.matches(STATUS_COMMAND_REGEX)) -> {
                    parkingLotService.printStatus()
                }
                (userInput.matches(REG_NUMS_FOR_COLOR_QUERY_REGEX)) -> {
                    val (_, color) = commandParser(userInput, REG_NUMS_FOR_COLOR_QUERY_REGEX)
                    parkingLotService.printSlotsByColor(color)
                }
                (userInput.matches(SLOT_NUM_FOR_REG_NUM_QUERY_REGEX)) -> {
                    val (_, licensePlateNumber) = commandParser(userInput, SLOT_NUM_FOR_REG_NUM_QUERY_REGEX)
                    parkingLotService.printSlotNumberByLicensePlate(licensePlateNumber)

                }
                else -> println("Invalid Command, please try again")

            }

    }
}

fun main(args: Array<String>) {
    val parkingLotService = ParkingLotService(InMemoryIParkingLot())
    when (args.size) {

        1 -> {
            // Read Commands from file
        }
        else -> {
            // Interactive Mode
            println("Welcome To Interactive Mode, Enter exit to quit the Interactive Mode: ")
            runInteractiveCli(parkingLotService)
        }
    }
}