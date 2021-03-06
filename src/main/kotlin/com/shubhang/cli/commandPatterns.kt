package com.shubhang.cli

val CREATE_COMMAND_REGEX = Regex("""create_parking_lot \d+""")
val PARK_COMMAND_REGEX = Regex("""park [a-zA-Z]+-\d+-[a-zA-Z]+-\d+ [a-zA-Z]+""")
val UNPARK_COMMAND_REGEX = Regex("""leave \d+""")
val SLOT_NUMS_FOR_COLOR_QUERY_REGEX = Regex("""slot_numbers_for_cars_with_colour [a-zA-Z]+""")
val SLOT_NUM_FOR_REG_NUM_QUERY_REGEX = Regex("""slot_number_for_registration_number [a-zA-Z]+-\d+-[a-zA-Z]+-\d+""")
val STATUS_COMMAND_REGEX = Regex("""status""")
val REG_NUMBERS_FOR_COLOR_QUERY_REGEX = Regex("""registration_numbers_for_cars_with_colour [a-zA-Z]+""")