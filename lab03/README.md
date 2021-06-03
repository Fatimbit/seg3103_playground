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


### JUnit
I am working with JUnit 5 (via Console standalone 1.7.1)

To run JUnit, I first compiled the application and then compiled the test code

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




###Exercise 2:
To run JUnit, after adding my code to the Java files I compiled the application and then compiled the test code
```bash
javac -encoding UTF-8 --source-path test -d dist -cp lib/junit-platform-console-standalone-1.7.1.jar test/*.java src/*.java
```
Next I ran the tests using this command:

```
java -jar lib/junit-platform-console-standalone-1.7.1.jar --class-path dist --scan-class-path
```
Here is a screenshot from the terminal with the results
![running JUnit]
