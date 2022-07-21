# Parking lot

We at [Sahaj](https://sahaj.ai) use Parking lot problem statement to jam/pair together. This repository presents base code, tests, setup instructions as well as the problem statement to get you started.

## Problem statement overview

Model a parking lot that exhibits following characterstics. 

* A parking lot should be able to park and un-park vehicles
* Parking lot supports 3 vehicle types: Motorcyles, Trucks and Cars
* The spot to accomodate these vehicles in Parking lots are different. They cannot be used interchangably. The number of spots for each type are fixed
* If a spot is available then a parking ticket is issued for the vehicle
* A ticket can be used to unpark the the vehicle 
* There is a base fee of Rs. 100 for parking. Multipliers are applied for different vehicle types to calculate parking charges. They are as follows

| Base rate | Vehicle type | Multiplier |
|-----------|--------------|------------|
| Rs. 100   | Motorcycle   | 1x         |
| Rs. 100   | Car          | 2x         |
| Rs. 100   | Truck.       | 3x         |

## Code Setup

The code can be setup in your favorite code editor. Follow instructions to set it up

### Instructions

* Install Java 11 to setup the code - Code uses Java 11 syntax for the existing code
* Project includes a `gradlew` binary to install gradle locally as needed to manage dependencies
* JUnit 5 - Project uses Junit 5 tests
* `git clone https://github.com/sahajsoft/parking-lot.git`
* Open in a code editor. We prefer [IntelliJ Idea](https://www.jetbrains.com/idea/download/#section=mac), but other code editors that you are comfortable with should work as well. 
* Execute JUnit tests in code editor or command line `./gradlew test`
* All but one test should pass. Currently `shouldUnParkAndUnParkFixedNumberOfCars` test fails. 
* As long as you have reached this point, you are ready to start pairing
* Refactor/update code if you think there are minor improvements can be made. This is not a pre-requisite but don't hold yourself back if you would like to do this

### Additional instructions

* Pairing helps, so please consider setting up [POP remote pairing tool](https://pop.com/) ahead of time for a seamless pairing experience
* Feel free to refactor and change code if you think it can be improved and for pairing exercise your modified version can be the starting base for new changes
* During pairing we prefer Red-Green refactor. It helps us refactor incrementally and keeps code functional at all times. If you are not familiar, please take a moment to read up on different [workflows of refactoring](https://martinfowler.com/articles/workflowsOfRefactoring/) ahead of your pairing
