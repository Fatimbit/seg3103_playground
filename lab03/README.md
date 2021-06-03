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

![running JUnit](https://raw.githubusercontent.com/Fatimbit/seg3101_playground/master/lab03/assets/screenshot1.PNG?token=ANE57KKQGQ5O27VDWAR76V3AXEESW)




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

![Run the agent](https://raw.githubusercontent.com/Fatimbit/seg3101_playground/master/lab03/assets/screenshot2.PNG?token=ANE57KLLENPGYSPY2E3HOBLAXEETY)
![Generate a report](https://raw.githubusercontent.com/Fatimbit/seg3101_playground/master/lab03/assets/screenshot3.PNG?token=ANE57KPLLSP3P6S6VCI5ZILAXEEUS)



The JaCoCo report showed the following result

![Jacoco Result](https://raw.githubusercontent.com/Fatimbit/seg3101_playground/master/lab03/assets/screenshot4.PNG?token=ANE57KO4GLDM3TTWGHG636DAXEEWY)






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

![running JUnit](https://raw.githubusercontent.com/Fatimbit/seg3101_playground/master/lab03/assets/screenshot5.PNG?token=ANE57KODFI3Z7NZLTS23NKLAXEEXS)




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

![Run the agent and generate report](https://raw.githubusercontent.com/Fatimbit/seg3101_playground/master/lab03/assets/screenshot6.PNG?token=ANE57KIOTH6TDNSTONVRDPDAXEEYI)




The JaCoCo report showed the following result

![Jacoco Result](https://raw.githubusercontent.com/Fatimbit/seg3101_playground/master/lab03/assets/screenshot7.PNG?token=ANE57KJKOZQUY3DQLJVLXVDAXEEZA)





### Refactoring Date.java

I attempted to refactor Date.java by introducing new tests that would cover conditions that JaCoCo showed were not being tested. I was able to improve the coverage but not reach 100% statement, branch, condiditon and condiditon/branch coverage. I improved it so that it reached 97% instruction coverage and 83% branch coverage.

The JaCoCo report showed the following results

![Jacoco Result](https://raw.githubusercontent.com/Fatimbit/seg3101_playground/master/lab03/assets/screenshot8.PNG?token=ANE57KJVNMXFKFVE3LUHPVTAXEEZU)

![Jacoco Result](https://raw.githubusercontent.com/Fatimbit/seg3101_playground/master/lab03/assets/screenshot9.PNG?token=ANE57KMAE7DGKSKI7OOSZLLAXEE2Q)
