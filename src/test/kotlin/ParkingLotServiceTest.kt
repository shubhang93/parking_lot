import dataManager.InMemoryIParkingLot
import domain.Car
import domain.ParkingSpot
import org.junit.*
import org.junit.Assert.assertEquals
import org.junit.runners.MethodSorters
import services.ParkingLotService
import java.io.ByteArrayOutputStream
import java.io.PrintStream

const val PARKING_LOT_CAPACITY = 6

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class ParkingLotServiceTest {

    private val outContent = ByteArrayOutputStream()
    private val originalOut = System.out


    companion object {
        lateinit var parkingLotService: ParkingLotService
        @BeforeClass
        @JvmStatic
        fun setup() {
            parkingLotService = ParkingLotService(InMemoryIParkingLot())
            parkingLotService.createParkingLot(PARKING_LOT_CAPACITY)
        }

        @AfterClass
        @JvmStatic
        fun teardown() {

        }
    }


    @Before
    fun setupStreams() {
        System.setOut(PrintStream(outContent))
    }

    @After
    fun clearStreams() {
        System.setOut(null)
    }


    @Test
    fun AitShouldInitializeParkingLot() {
        assertEquals(PARKING_LOT_CAPACITY, parkingLotService.getFreeSlotCount())
    }


    @Test
    fun BitShouldParkCars() {
        val cars = listOf(
            Car("White", "KA-02-EU8901"),
            Car("Blue", "KA-01-AE9099"),
            Car("Yellow", "KA-02-DV8900"),
            Car("Orange", "KA-53-TR1234"),
            Car("Violet", "KA-50-MB9021"),
            Car("Brown", "GJ-01-EW1234")
        )
        val stdoutMessage =
            cars.mapIndexed { index, _: Car -> "Allocated slot number: ${index + 1}" }
                .joinToString("\n")

        cars.forEach { car -> parkingLotService.park(car) }
        assertEquals(stdoutMessage, outContent.toString().trim())
    }

    @Test
    fun CshouldBecomeFullAfterCapacityIsExhausted() {
        val cars = listOf(
            Car("Yellow", "KA-04-EM2123"),
            Car("Orange", "KA-21-EF4567"),
            Car("Blue", "KA-06-DS2123")
        )
        cars.forEach { car -> parkingLotService.park(car) }
        val freeSlots = parkingLotService.getFreeSlotCount()
        assertEquals(0, freeSlots)
    }

    @Test
    fun DitShouldUnParkCar() {
        parkingLotService.unParkCar(ParkingSpot(2))
        assertEquals("Slot number 2 is free", outContent.toString().toString().trim())
    }

    @Test
    fun EitShouldReleaseParkingSpotAfterUnPark() {
        parkingLotService.unParkCar(ParkingSpot(1))
        assertEquals(2, parkingLotService.getFreeSlotCount())
    }
}