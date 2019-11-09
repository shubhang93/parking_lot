import dataManager.InMemoryIParkingLot
import domain.Car
import domain.ParkingSpot
import org.junit.*
import org.junit.Assert.assertEquals
import org.junit.runners.MethodSorters
import services.ParkingLotService
import java.io.ByteArrayOutputStream
import java.io.PrintStream

@FixMethodOrder(MethodSorters.JVM)
class ParkingLotTest {

    private val outContent = ByteArrayOutputStream()
    private val originalOut = System.out


    companion object {
        lateinit var parkingLotService: ParkingLotService
        @BeforeClass
        @JvmStatic
        fun setup() {
            parkingLotService = ParkingLotService(InMemoryIParkingLot.createParkingLot(6))
        }

        @AfterClass
        @JvmStatic
        fun teardown() {

        }
    }


    @Before
    fun setUpStreams() {
        System.setOut(PrintStream(outContent))
    }

    @After
    fun clearStreams() {
        System.setOut(null)
    }


    @Test
    fun freeSlotCountTest() {
        assertEquals(parkingLotService.getFreeSlotCount(), 6)
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
            cars.mapIndexed { index, _: Car -> "Allocated Slot number: ${index + 1}" }
                .joinToString("\n")

        cars.forEach { car -> parkingLotService.park(car) }
        assertEquals(stdoutMessage, outContent.toString().trim())
    }

    @Test
    fun shouldBecomeFullAfterCapacityIsExhausted() {
        val cars = listOf<Car>(
            Car("Yellow", "KA-04-EM2123"),
            Car("Orange", "KA-21-EF4567"),
            Car("Blue", "KA-06-DS2123")
        )
        cars.forEach { car -> parkingLotService.park(car) }
        val freeSlots = parkingLotService.getFreeSlotCount()
        assertEquals(0, freeSlots)
    }

    @Test
    fun itShouldUnParkCar() {
        parkingLotService.unParkCar(ParkingSpot(2))

        assertEquals("Slot Number 2 is free", outContent.toString().toString().trim())
    }

    @Test
    fun itShouldReleaseParkingSpotAfterUnPark() {
        parkingLotService.unParkCar(ParkingSpot(1))
        assertEquals(2, parkingLotService.getFreeSlotCount())
    }
}