package com.shubhang

import com.shubhang.dataManager.InMemoryIParkingLot
import com.shubhang.domain.Car
import com.shubhang.domain.ParkingSpot
import org.junit.AfterClass
import org.junit.Assert.assertEquals
import org.junit.BeforeClass
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runners.MethodSorters

const val MAX_PARKING_LOT_CAPACITY = 6

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class ParkingLotTest {

    companion object {
        lateinit var inMemoryIParkingLot: InMemoryIParkingLot
        @JvmStatic
        @BeforeClass
        fun setup() {
            inMemoryIParkingLot = InMemoryIParkingLot()
        }

        @JvmStatic
        @AfterClass
        fun teardown() {
            inMemoryIParkingLot.resetParkingLot()
        }
    }


    @Test(expected = IllegalStateException::class)
    fun A_itShouldInitializeExactlyOnce() {
        inMemoryIParkingLot.createParkingLot(MAX_PARKING_LOT_CAPACITY)
        inMemoryIParkingLot.createParkingLot(5)
    }

    @Test
    fun B_itShouldParkSixCars() {
        val cars = listOf(
            Car("White", "KA-02-EU8901"),
            Car("Blue", "KA-01-AE9099"),
            Car("Yellow", "KA-02-DV8900"),
            Car("Orange", "KA-53-TR1234"),
            Car("Violet", "KA-50-MB9021"),
            Car("Brown", "GJ-01-EW1234"),
            Car("Orange", "CH-02-EB9292")
        )
        val expected = listOf(
            ParkingSpot(1),
            ParkingSpot(2),
            ParkingSpot(3),
            ParkingSpot(4),
            ParkingSpot(5),
            ParkingSpot(6),
            null
        )

        val results = mutableListOf<ParkingSpot?>()

        cars.forEach { car ->
            val parkingSpot = inMemoryIParkingLot.park(car)
            results.add(parkingSpot)
        }

        assertEquals(expected, results)

    }

    @Test
    fun C_itShouldUnParkCarsAtSpotFourAndTwo() {
        val positions = listOf<Int>(2, 4)
        val expected = listOf<ParkingSpot>(
            ParkingSpot(2),
            ParkingSpot(4)
        )
        val results = mutableListOf<ParkingSpot>()
        positions.forEach { position ->
            val parkingSpot = inMemoryIParkingLot.unPark(ParkingSpot(position))
            results.add(parkingSpot)
        }
        assertEquals(expected, results)
    }

    @Test
    fun D_itShouldAllocateTheNearestSpot() {
        val expected = ParkingSpot(2)
        val car = Car("Maroon", "KA-02-AM9098")
        val result = inMemoryIParkingLot.park(car)
        assertEquals(expected, result)
    }

    @Test
    fun E_itShouldReturnParkingLotStatus() {
        val expected: Map<ParkingSpot, Car> = mapOf(
            ParkingSpot(1) to Car("White", "KA-02-EU8901"),
            ParkingSpot(3) to Car("Yellow", "KA-02-DV8900"),
            ParkingSpot(5) to Car("Violet", "KA-50-MB9021"),
            ParkingSpot(6) to Car("Brown", "GJ-01-EW1234"),
            ParkingSpot(2) to Car("Maroon", "KA-02-AM9098")
        )

        val result = inMemoryIParkingLot.getOccupiedSlots()
        assertEquals(expected, result)

    }


}