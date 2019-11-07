import domain.Car
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import services.ParkingLotServiceImpl
import java.io.ByteArrayOutputStream
import java.io.PrintStream


class ParkingLotTest {

    private val parkingLotService = ParkingLotServiceImpl.initializeParkingLot(6);
    private val outContent = ByteArrayOutputStream()
    private val originalOut = System.out


    @Before
    fun setUpStreams() {
        System.setOut(PrintStream(outContent))
    }


    fun restoreStreams() {
        System.setOut(originalOut)
    }

    @Test
    fun itShouldParkCars() {
        val cars = listOf(
            Car("White", "KA-02-EU8901"),
            Car("Blue", "KA-01-AE9099"),
            Car("Yellow", "KA-02-DV8900"),
            Car("Orange", "KA-53-TR1234"),
            Car("Violet", "KA-50-MB9021"),
            Car("Brown", "GJ-01-EW1234")
        )
        val stdoutMessage =
            cars.mapIndexed { index, _: Car -> "Allocated Slot Number ${index+1}" }
                .joinToString("\n")

        cars.forEach { car -> parkingLotService.park(car) }
        assertEquals(stdoutMessage, outContent.toString().trim())
    }
}