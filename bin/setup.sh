# Add script to:
# * Install dependencies
# * Build/Compile
# * Run Test Suit to validate
#
# After this is run, bin/parking_lot
# should Just Work.
cd ../
./gradlew clean build
./run_functional_tests
./bin/parking_lot
