#DailyTradeReportingEngine

Test of Code to  JP Morgan

## Getting Started

Clone the repository and import it to a Eclise IDE(with  STS Plugin) and press "Run as Spring Boot App"


Technology Stack used:
1) Spring BOOT
2) Spring
3) GRADLE
4) Java 1.8
5) Junit4

Solution Approach:
1) Created a trade.csv for test data. Parsed the list into an object for further processing in the code. Used BuffereedReader + Java Stream + LambdaExpression to parse and store. This is used to showcase the parsing technique in case of very huge data.
2) Created different models/POJO to store/process the Trade related data.
3) The main Spring Boot Class invokes the service to generate reports.
4) Bean configuration maintained in applicationContext.xml. Used Dependency injection.
5) Written one junit to test the whole application.