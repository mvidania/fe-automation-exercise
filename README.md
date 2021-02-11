# WEB FE AUTOMATION EXERCISE

Java application based on Spring-Boot, Selenium and Cucumber.

It tests some navigation actions through the following website  https://www.demoblaze.com/index.html:
* Customer navigation through product categories: Phones, Laptops and Monitors
* Navigate to "Laptop" → "Sony vaio i5" and click on "Add to cart". Accept pop up confirmation.
* Navigate to "Laptop" → "Dell i7 8gb" and click on "Add to cart". Accept pop up confirmation.
* Navigate to "Cart" → Delete "Dell i7 8gb" from cart.
* Click on "Place order".
* Fill in all web form fields.
* Click on "Purchase"
* Capture and log purchase Id and Amount.
* Assert purchase amount equals expected.
* Click on "Ok"

## Getting Started

Prerequisites before you run the application:
* Install Java JDK 1.8
* Install Maven
* Chrome

### Installing

Download the project from https://github.com/mvidania/fe-automation-exercise.git

Chrome driver is already attached to the project under /drivers/selenium therefore there is no configuration needed if downloaded.

If the driver is not downloaded, go to https://chromedriver.chromium.org/downloads and download the driver.
Then place it in /drivers/selenium/ folder with the name chromedriver.exe

## Project Structure

### Packages
####main
* constants -> Classes that define web elements from https://www.demoblaze.com
* factories -> Classes to get objects at the time of execution. In this case we get the driver to execute automated actions on the browser.
* pages -> Classes that define web page elements and actions that might be carried out inside these elements. 
* utils -> Classes that define execute common actions across all pages classes like waiting for an element to be loaded or click an element.

####test
* gherkinsteps -> Classes that contains the methods triggered by runner classes.
* runners -> Classes that run the steps defined in gherkinsteps.

####test/resources
* /features -> This folder contains gherkin features that describes the
  scenario and actions executed in gherkinsteps classes.

## Running the tests

Open new terminal from command-Line, go to the project root and execute.

```
mvn test 
```
The test will execute automatically.

You will see the steps and results on the terminal.

## Author

* [Miguel Vidania](https://github.com/mvidania/)

