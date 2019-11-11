package com.shubhang.cli

fun commandUsagePrinter() {
    val usage = """
        Welcome to Parking Lot CLI
        Command                                                         Description
        ------------------------------------------------------------------------------------------------------------------------------
        create_parking_lot <capacity>                                   Create A parking log with desired capacity
        park <license_plate_number> <colour>                            Allocate a parking slot for a Car
        leave <slot_number>                                             Free up a parking slot at the desired position/slot
        status                                                          View the current status of the parking lot
        registration_numbers_for_cars_with_colour <colour>              View license plate numbers of all cars for a specific color
        slot_numbers_for_cars_with_colour <colour>                      View slot numbers where cars with a specific color are parked
        slot_number_for_registration_number <license_plate_number>      View slot number for a particular car
        exit                                                            Exit the CLI
        
    """.trimIndent()
    println(usage)
}