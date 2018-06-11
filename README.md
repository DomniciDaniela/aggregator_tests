# aggregator_tests framework

This project is based on MAVEN and jUnit.

#Project structure:

-> 'drivers' -> all drivers/browsers required for local run. Example: Firefox, Chrome, InternetExplorer.
-> 'Screenshots' -> the location of screenshots when the test is failed. The screenshot name is a concatenation between the method name and the date when the test failed.
Example: testYouAndYourInsuranceElementsPageVisibility_2018.06.05.12.30.31.png
-> 'src/main/java/helpers' -> includes the classes used for avoid the code duplication and utilities

    The 'TestBase' class contains the logic on opening the browser based on the parameter provided by 'AggregatorsData.xlsx' file
-> 'src/main/java/screens' -> contains methods for each page (home + motor)
-> 'src/test/java/' -> contains all test cases for motor AND home. A testcase corresponds to a single row defined in the 'GoCompareMotorAggregator' and 'ConfusedHomeAggregator' files.

-> 'AggregatorsData.xlsx' is a spreadsheet which contains the test parameters, as follows:
        - TestConfig sheet contains the configuration for the environment and browsers;
        - GoCompareMotorAggregator sheet contains the parameters/data for the motor SOAP request(The template used is GoCompare)
        - ConfusedHomeAggregator sheet contains the parameters/data for the home SOAP request(The template used is Confused)
        - CardDetails sheet contains the data for the payment (card type, card number, card owner, expiry date, cvc)

-> 'pom.xml' -> contains all framework dependencies.

# How to run these tests on other test environments/endpoints than provided in test cases?
You can update the urls from 'TestConfig' sheet, by changing the following values :
~ Soap Test Environment -> the SOAP POST request endpoint (e.g.: http://e1b-eswls-tstd-01.es-dte.co.uk:7012/ibisservice/ibisservice)
~ WebApp Test Environment -> environment for the web aggragator url
~ IsDevEnvironment (Y/N) -> If you want to run on dev environment set the flag Y otherwise N
~ Soap Dev Environment -> the SOAP POST request endpoint (e.g.: http://e1a-eswls-devd-01.es-dte.co.uk:7012/ibisservice/ibisservice)
~ WebApp Dev Environment -> environment for the web aggragator url


#These tests can be run from IDE or from command line(terminal/command prompt).
How to run tests from command line?
You can run the tests locally from command line only if you have set M2_HOME (maven) as an environment variable.
(More info: http://www.baeldung.com/install-maven-on-windows-linux-mac)

Commands:
 - mvn clean verify -> runs all tests
 - mvn clean verify -Dtest=mvn clean verify -Dtest=AggregatorsHomeTest -> runs all tests within AggregatorsHomeTest class
 - mvn clean verify -Dtest=AggregatorsHomeTest#testHomeConfusedAddonNotSelected -> runs testHomeConfusedAddonNotSelected method from AggregatorsHomeTest class
