# Lab 03
| Outline | Value |
| --- | --- |
| Course | SEG 3X03 |
| Date | Summer 2021 |
| Professor | Andrew Forward, aforward@uottawa.ca |
| TA | Nazanin Bayati Chaleshtari, n.bayati@uottawa.ca|
| Team | Fatimah Vakily 300125671 |



### Java
I am running Java 14.0.1


### JUnit Coverage
I am working with JUnit 5 (via Console standalone 1.7.1)

To run JUnit within the coverage folder, I first compiled the application and then compiled the test code

```bash
javac -encoding UTF-8 --source-path test -d dist -cp lib/junit-platform-console-standalone-1.7.1.jar test/*.java src/*.java
```

Next I ran the tests using this command:

```
java -jar lib/junit-platform-console-standalone-1.7.1.jar --class-path dist --scan-class-path
```


Here is a screenshot from the terminal showing the results of the commands above

![running JUnit](assets/screenshot1.png)




### Running Coverage Metrics on JUnit

To run the agent, I executed the command below

```
java -javaagent:lib/jacocoagent.jar -jar lib/junit-platform-console-standalone-1.7.1.jar --class-path dist --scan-class-path
```

To generate a report, I then executed the following command
```
java -jar lib/jacococli.jar report jacoco.exec --classfiles dist --sourcefiles src --html report
```

Here are screenshots from the terminal showing the results of the commands above

![Run the agent](assets/screenshot2.png)
![Generate a report](assets/screenshot3.png)



The JaCoCo report showed the following result

![Jacoco Result](assets/screenshot4.png)






### JUnit Date
I am working with JUnit 5 (via Console standalone 1.7.1)

To run JUnit within the date folder, I first compiled the application and then compiled the test code

```bash
javac -encoding UTF-8 --source-path test -d dist -cp lib/junit-platform-console-standalone-1.7.1.jar test/*.java src/*.java
```

Next I ran the tests using this command:

```
java -jar lib/junit-platform-console-standalone-1.7.1.jar --class-path dist --scan-class-path
```


Here is a screenshot from the terminal showing the results of the commands above

![running JUnit](assets/screenshot5.png)




### Running Date on JUnit

To run the agent, I executed the command below

```
java -javaagent:lib/jacocoagent.jar -jar lib/junit-platform-console-standalone-1.7.1.jar --class-path dist --scan-class-path
```

To generate a report, I then executed the following command
```
java -jar lib/jacococli.jar report jacoco.exec --classfiles dist --sourcefiles src --html report
```

Here is a screenshot from the terminal showing the results of the commands above

![Run the agent and generate report](assets/screenshot6.png)




The JaCoCo report showed the following result

![Jacoco Result](assets/screenshot7.png)





### Refactoring Date.java

I attempted to refactor Date.java by introducing new tests that would cover conditions that JaCoCo showed were not being tested. I was able to improve the coverage but not reach 100% statement, branch, condiditon and condiditon/branch coverage. I improved it so that it reached 97% instruction coverage and 83% branch coverage.

The JaCoCo report showed the following results

![Jacoco Result](assets/screenshot8.png)

![Jacoco Result](assets/screenshot9.png)
