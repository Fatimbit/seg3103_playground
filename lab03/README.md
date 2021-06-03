# Lab 02
| Outline | Value |
| --- | --- |
| Course | SEG 3X03 |
| Date | Summer 2021 |
| Professor | Andrew Forward, aforward@uottawa.ca |
| TA | Nazanin Bayati Chaleshtari, n.bayati@uottawa.ca|
| Team | Fatimah Vakily 300125671 |



### Java
I am running Java 14.0.1




###Exercise 1:




###JUnit
I am working with JUnit 5 (via Console standalone 1.7.1)

To run JUnit, I compiled the application and then compiled the test code

```bash
javac -encoding UTF-8 --source-path test -d dist -cp lib/junit-platform-console-standalone-1.7.1.jar test/*.java src/*.java
```

Next I ran the tests using this command:

```
java -jar lib/junit-platform-console-standalone-1.7.1.jar --class-path dist --scan-class-path
```


Here is a screenshot from the terminal

![running JUnit]


###Exercise 2:
To run JUnit, after adding my code to the Java files (DateTest.java, DateNextDateOkTest.java, DateNextDateExceptionTest.java) I compiled the application and then compiled the test code
```bash
javac -encoding UTF-8 --source-path test -d dist -cp lib/junit-platform-console-standalone-1.7.1.jar test/*.java src/*.java
```
Next I ran the tests using this command:

```
java -jar lib/junit-platform-console-standalone-1.7.1.jar --class-path dist --scan-class-path
```
Here is a screenshot from the terminal with the results
![running JUnit]
