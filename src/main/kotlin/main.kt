import com.shubhang.cli.commandExecutor
import com.shubhang.dataManager.InMemoryIParkingLot
import com.shubhang.services.ParkingService
import java.io.File


fun runInteractiveCli(parkingLotService: ParkingService) {
    loop@ while (true) {
        val userInput: String? = readLine()
        if (userInput != null) {
            if (userInput == "exit") break@loop
            commandExecutor(userInput, parkingLotService)
        }
    }
}

fun fileInputCli(commandFilepath: String, parkingLotService: ParkingService) {
    val commands = mutableListOf<String>()
    File(commandFilepath).forEachLine { line -> commands.add(line) }
    commands.forEach { command -> commandExecutor(command, parkingLotService) }
}


fun main(args: Array<String>) {
    val parkingLotService = ParkingService(InMemoryIParkingLot())
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

