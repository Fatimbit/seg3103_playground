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

![running JUnit](https://user-images.githubusercontent.com/55173033/120686282-d42b8280-c46e-11eb-99b2-0d3549041987.png)




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

![Run the agent](https://user-images.githubusercontent.com/55173033/120686333-dee61780-c46e-11eb-8f60-fe59006e942e.png)
![Generate a report](https://user-images.githubusercontent.com/55173033/120686362-e4436200-c46e-11eb-89fc-7c47955d1ce1.png)



The JaCoCo report showed the following result

![Jacoco Result](https://user-images.githubusercontent.com/55173033/120686394-ea394300-c46e-11eb-9458-72ebaa7fed47.png)






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

![running JUnit](https://user-images.githubusercontent.com/55173033/120686425-f1605100-c46e-11eb-8da3-c81ffc4bf20c.png)




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

![Run the agent and generate report](https://user-images.githubusercontent.com/55173033/120686441-f6bd9b80-c46e-11eb-9d65-78e1ec6a9fad.png)



The JaCoCo report showed the following result

![Jacoco Result](https://user-images.githubusercontent.com/55173033/120686469-fcb37c80-c46e-11eb-9127-32850c4da523.png)





### Refactoring Date.java

I attempted to refactor Date.java by introducing new tests that would cover conditions that JaCoCo showed were not being tested. I was able to improve the coverage but not reach 100% statement, branch, condiditon and condiditon/branch coverage. I improved it so that it reached 97% instruction coverage and 83% branch coverage.

The JaCoCo report showed the following results

![Jacoco Result](https://user-images.githubusercontent.com/55173033/120686487-0341f400-c46f-11eb-8d3a-bad03ed46587.png)

![Jacoco Result](https://user-images.githubusercontent.com/55173033/120686511-0937d500-c46f-11eb-9ffe-82d908579567.png)
