# Add script to:
# * Install dependencies
# * Build/Compile
# * Run Test Suit to validate
#
# After this is run, bin/parking_lot
# should Just Work.
DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" >/dev/null && pwd)"

cd "$DIR/../" &&
  ./gradlew clean build
./bin/run_functional_tests
