# Lab 07
| Outline | Value |
| --- | --- |
| Course | SEG 3X03 |
| Date | Summer 2021 |
| Professor | Andrew Forward, aforward@uottawa.ca |
| TA | Henry Chen, zchen229@uottawa.ca|
| Team | Fatimah Vakily 300125671 |

I compiled the code with this command:

```bash
javac -encoding UTF-8 --source-path test -d dist -cp lib/junit-platform-console-standalone-1.7.1.jar test/*.java src/*.java
```
Then ran it:
```bash
java -cp ./dist Main
```

Here is a screenshot of the result.

![calculator](calculator/calculator/assets/screenshot1.PNG)



After that, I used this command to run spotbugs:

```bash
java -jar ./lib/spotbugs/lib/spotbugs.jar
```
Here is a screenshot of the spotbugs screen:

![calculator](calculator/calculator/assets/screenshot2.PNG)

I then created a new project:

![calculator](calculator/calculator/assets/screenshot3.PNG)

This is the result of the analysis showing how many bugs the code had at first:

![calculator](calculator/calculator/assets/screenshot4.PNG)

I then fixed the bugs until I got this as the result of the spotbugs analysis:

![calculator](calculator/calculator/assets/screenshot5.PNG)

The only bug I did not fix was the one showing the "Bug kind and pattern: SIC - SIC_INNER_SHOULD_BE_STATIC_ANON" message. I would fix the code by refactoring the inner class on line 53 of the CalCFrameTest.java file into a static named inner class.