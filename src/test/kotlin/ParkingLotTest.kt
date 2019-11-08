import domain.Car
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import services.ParkingLotServiceImpl
import java.io.ByteArrayOutputStream
import java.io.PrintStream


class ParkingLotTest {


    private val outContent = ByteArrayOutputStream()
    private val originalOut = System.out


    @Before
    fun setUpStreams() {
        System.setOut(PrintStream(outContent))
    }


    @Test
    fun itShouldParkCars() {
        val parkingLotService = ParkingLotServiceImpl.initializeParkingLot(6);
        val cars = listOf(
            Car("White", "KA-02-EU8901"),
            Car("Blue", "KA-01-AE9099"),
            Car("Yellow", "KA-02-DV8900"),
            Car("Orange", "KA-53-TR1234"),
            Car("Violet", "KA-50-MB9021"),
            Car("Brown", "GJ-01-EW1234")
        )
        val stdoutMessage =
            cars.mapIndexed { index, _: Car -> "Allocated Slot Number ${index + 1}" }
                .joinToString("\n")

        cars.forEach { car -> parkingLotService.park(car) }
        assertEquals(stdoutMessage, outContent.toString().trim())
    }

    @Test
    fun shouldBecomeFullAfterCapacityIsExhausted() {
        val parkingLotService = ParkingLotServiceImpl.initializeParkingLot(3);
        val cars = listOf<Car>(
            Car("Yellow", "KA-04-EM2123"),
            Car("Orange", "KA-21-EF4567"),
            Car("Blue", "KA-06-DS2123")
        )
        cars.forEach { car -> parkingLotService.park(car) }
        val isFull = parkingLotService.isParkingLotFull()
        assertEquals(isFull, true)
    }

}