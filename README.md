# appiumProject

### Way to execute the Assignment Maven project locally.

1. Download the project  and save it.
2. Open in Eclipse workspace and In home page  click “File”  click “Import”
3. Click on Maven  Existing Maven Project.
4. Then select the Root folder as saved above “TestAutomationAssignment folder” 
5. Click on check box “/pom.xml”then click Finish
6. appiumProject project will be added in the “project Explorer”
7. Expand the src/test/testNG and right click file  Click Run As  TestNGTest. 
8. TestResults reported in Console.
9. Results of the Extent Report will be in test-output/swagLabsReport_Extent.html
10. Copy the above location path and paste in the chrome browser.  HTML Report will be displayed in the browser.

To execute from the Terminal , navigate to the project directory and run the below command :
mvn clean test -DsuiteXmlFile="./src/test/java/com/resources/testng.xml"


****************************************************************************


###  Technologies used:
1.	Appium
2.	Maven
3.	TestNG
4.	Selenium
5.	Intellij
6.	Android Studio
