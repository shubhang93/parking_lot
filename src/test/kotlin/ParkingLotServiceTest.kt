import dataManager.InMemoryIParkingLot
import domain.Car
import org.junit.*
import org.junit.runners.MethodSorters
import services.ParkingService
import java.io.ByteArrayOutputStream
import java.io.PrintStream

const val PARKING_LOT_CAPACITY = 6

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class ParkingLotServiceTest {

    private val outContent = ByteArrayOutputStream()
    private val originalOut = System.out


    companion object {
        lateinit var parkingLotService: ParkingService
        @BeforeClass
        @JvmStatic
        fun setup() {
            parkingLotService = ParkingService(InMemoryIParkingLot())
            parkingLotService.createParkingLot(PARKING_LOT_CAPACITY)
            val cars = listOf(
                Car("White", "KA-01-AB-1234"),
                Car("White", "KA-02-BD-9089"),
                Car("Blue", "KA-05-GJ-8765")
            )
            cars.forEach {
                parkingLotService.park(it)
            }
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

}