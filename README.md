## Parking Lot
#### A Parking lot ticketing system


## How to use
- Download the parking_lot-master.zip
- Run the setup.sh from the bin folder to install dependencies, build and test the functional specs. 
```shell script
./bin/setup.sh
```
- Run the parking_lot.sh binary executable from the bin folder to run in interactive mode.
```shell script
./bin/parking_lot.sh
```
- Run the parking_lot.sh with a file input as the argument to process commands from a file
```shell script
./bin/parking_lot.sh /user/command.txt
``` 

### Command file format
#### command.txt
```text
create_parking_lot 6
park KA-01-HH-1234 White
park KA-01-HH-9999 White
park KA-01-BB-0001 Black
park KA-01-HH-7777 Red
park KA-01-HH-2701 Blue
park KA-01-HH-3141 Black
leave 4
status
park KA-01-P-333 White
park DL-12-AA-9999 White
registration_numbers_for_cars_with_colour White
slot_numbers_for_cars_with_colour White
slot_number_for_registration_number KA-01-HH-3141
slot_number_for_registration_number MH-04-AY-1111
```
### Interactive mode usage
- To start create a parking lot with desired capacity using the command: create_parking_lot \<capacity>
- To park a car enter: park \<car_license_plate_number> \<color>
- To view the parking lot status enter: status
- To free a parking spot enter: leave \<slot_number>
- To view license plate numbers of cars for a specific color enter: registration_numbers_for_cars_with_colour \<color>
- To view slots occupied by a specific car color enter: slot_numbers_for_cars_with_colour \<color>
- To view a slot occupied by a car with a specific license plate number enter: slot_number_for_registration_number \<license_plate_number>
- To Quit the CLI enter: exit

