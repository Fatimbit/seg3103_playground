# Lab 02
| Outline | Value |
| --- | --- |
| Course | SEG 3X03 |
| Date | Summer 2021 |
| Professor | Andrew Forward, aforward@uottawa.ca |
| TA | Henry Chen, zchen229@uottawa.ca|
| Team | Andrew Forward 1484511<br>Ayana Forward 9021000 |



### Java
I am running Java 14.0.1




##Exercise 1:

| Test Case  | Espected Results | Actual Results | Verdict (Pass, Fail, Inconclusive) |
|---|---|---|---|
| 1 | registration request accepted | registration request accepted | Pass |
| 2 | registration request accepted | registration request accepted | Pass |
| 3 | registration request accepted | registration request accepted | Pass |
| 4 | registration request accepted | registration request accepted | Pass |
| 5 | Err1  | Err1, Err3 | Fail |
| 6 | Err3  | Err3, Err1 | Fail |
| 7 | Err3  | Err3 | Pass |
| 8 | Err1  | Err1 | Pass |



##JUnit
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

![running JUnit](assets/screenshot1.png)


##Exercise 2:
To run JUnit, after adding my code to the Java files (DateTest.java, DateNextDateOkTest.java, DateNextDateExceptionTest.java) I compiled the application and then compiled the test code
```bash
javac -encoding UTF-8 --source-path test -d dist -cp lib/junit-platform-console-standalone-1.7.1.jar test/*.java src/*.java
```
Next I ran the tests using this command:

```
java -jar lib/junit-platform-console-standalone-1.7.1.jar --class-path dist --scan-class-path
```
Here is a screenshot from the terminal with the results
![running JUnit](assets/screenshot2.png)
