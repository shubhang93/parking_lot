import dataManager.InMemoryIParkingLot
import org.junit.Assert.assertEquals
import org.junit.Test

class ParkingLotTest {
    @Test
    fun itShouldCreateASingleTonObject() {
        val parkingLot1 = InMemoryIParkingLot().createParkingLot(6)
        val parkingLot2 = InMemoryIParkingLot().createParkingLot(2)
        assertEquals(parkingLot1, parkingLot2)
    }

    @Test(expected = IllegalStateException::class)
    fun itShouldInitializeExactlyOnce() {
        val inMemoryIParkingLot = InMemoryIParkingLot()
        inMemoryIParkingLot.createParkingLot(6)
        inMemoryIParkingLot.createParkingLot(5)

    }
}