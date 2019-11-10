import cli.commandExecutor
import dataManager.InMemoryIParkingLot
import services.ParkingLotService
import java.io.File


fun runInteractiveCli(parkingLotService: ParkingLotService) {
    loop@ while (true) {
        val userInput: String? = readLine()
        if (userInput != null) {
            if (userInput == "exit") break@loop
            commandExecutor(userInput, parkingLotService)
        }
    }
}

fun fileInputCli(commandFilepath: String, parkingLotService: ParkingLotService) {
    val commands = mutableListOf<String>()
    File(commandFilepath).forEachLine { line -> commands.add(line) }
    commands.forEach { command -> commandExecutor(command, parkingLotService) }
}


fun main(args: Array<String>) {
    val parkingLotService = ParkingLotService(InMemoryIParkingLot())
    when (args.size) {
        1 -> {
            // Read Commands from file
            fileInputCli(args[0], parkingLotService)

        }
        else -> {
            // Interactive Mode
            runInteractiveCli(parkingLotService)
        }
    }
}

