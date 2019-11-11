package com.shubhang.cli

fun commandUsagePrinter() {
    val usage = """
        Welcome to Parking Lot CLI
        - To start create a parking lot with desired capacity using the command: create_parking_lot <capacity>
        - To park a car enter: park <car_license_plate_number> <color>
        - To view the parking lot status enter: status
        - To free a parking spot enter: leave <slot_number>
        - To view slots occupied by a specific car color enter: slot_numbers_for_cars_with_colour <color>
        - To view a slot occupied by a car with a specific license plate number enter: slot_number_for_registration_number <license_plate_number>
        - To Quit the CLI enter: exit
    """.trimIndent()
    println(usage)
}