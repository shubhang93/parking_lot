package com.shubhang.cli

import com.shubhang.domain.Car
import com.shubhang.domain.ParkingSpot
import com.shubhang.services.ParkingService

fun commandParser(userInput: String, regex: Regex): List<String> {
    val match = regex.find(userInput)
    return if (match != null) return match.groupValues.joinToString(" ").split(" ") else emptyList()
}


fun commandExecutor(userInput: String, parkingLotService: ParkingService) {
    when {
        (userInput.matches(CREATE_COMMAND_REGEX)) -> {
            val (_, capacity) = commandParser(userInput, CREATE_COMMAND_REGEX)
            parkingLotService.createParkingLot(capacity.toInt())
            println("Created a parking lot with $capacity slots")
        }
        (userInput.matches(PARK_COMMAND_REGEX)) -> {
            val (_, licensePlate, color) = commandParser(
                userInput,
                PARK_COMMAND_REGEX
            )
            parkingLotService.park(Car(color, licensePlate))
        }
        (userInput.matches(UNPARK_COMMAND_REGEX)) -> {
            val (_, slotNumber) = commandParser(userInput, UNPARK_COMMAND_REGEX)
            parkingLotService.unParkCar(ParkingSpot(slotNumber.toInt()))
        }
        (userInput.matches(STATUS_COMMAND_REGEX)) -> {
            parkingLotService.printStatus()
        }
        (userInput.matches(SLOT_NUMS_FOR_COLOR_QUERY_REGEX)) -> {
            val (_, color) = commandParser(userInput, SLOT_NUMS_FOR_COLOR_QUERY_REGEX)
            parkingLotService.printSlotsByColor(color)
        }
        (userInput.matches(SLOT_NUM_FOR_REG_NUM_QUERY_REGEX)) -> {
            val (_, licensePlateNumber) = commandParser(
                userInput,
                SLOT_NUM_FOR_REG_NUM_QUERY_REGEX
            )
            parkingLotService.printSlotNumberByLicensePlate(licensePlateNumber)
        }
        (userInput.matches(REG_NUMBERS_FOR_COLOR_QUERY_REGEX)) -> {
            val (_, color) = commandParser(
                userInput,
                REG_NUMBERS_FOR_COLOR_QUERY_REGEX
            )
            parkingLotService.printRegistrationNumbersForColor(color)
        }
        else -> println("Invalid Command, please try again")
    }

}
