# Lab 06
| Outline | Value |
| --- | --- |
| Course | SEG 3X03 |
| Date | Summer 2021 |
| Professor | Andrew Forward, aforward@uottawa.ca |
| TA | Zahra Kakavand, zkaka044@uottawa.ca|
| Team | Fatimah Vakily 300125671 |

### MVN
I first downloaded Apache Maven and added its bin folder as my system's PATH  environment variable.
I am running apache maven version 3.8.1

```bash
mvn --version
Apache Maven 3.8.1 (05c21c65bdfed0f71a2f2ada8b84da59348c4c5d)
Maven home: C:\Users\mount\Desktop\seg3101_playground-master\lab06\BookstoreApp\BookstoreApp\apache-maven-3.8.1-bin\apache-maven-3.8.1\bin\..
Java version: 14.0.1, vendor: Oracle Corporation, runtime: C:\Program Files (x86)\jdk-14.0.1_windows-x64_bin\jdk-14.0.1
Default locale: en_CA, platform encoding: Cp1252
OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"
```

Here is a screenshot:

![MVN version](BookstoreApp/BookstoreApp/assets/screenshot1.PNG)


After that, I compiled using
```bash
mvn compile
```
and it compiled successfully.

![MVN compiled](BookstoreApp/BookstoreApp/assets/screenshot2.PNG)

Then I ran the following command:
```bash
mvn package -DskipTests
```
which is a command that packages all the project files into one jar file so it can easily be run. It completed successfully.

![MVN DskipTests](BookstoreApp/BookstoreApp/assets/screenshot3.PNG)


### BookstoreApp

First I tried using

```bash
java -jar ./target/BookstoreApp-0.1.0.jar
```
as instructed in the lab slides, but when I went to http://localhost:8080 it did not work and said it was unable to connect.

![BookstoreApp jar fail](BookstoreApp/BookstoreApp/assets/screenshot4.PNG)
![BookstoreApp jar fail](BookstoreApp/BookstoreApp/assets/screenshot5.PNG)


Afterwards, I tried to use this command:

```bash
java -jar bookstore5.jar
```

and then went to http://localhost:8080 and it worked successfully.

![BookstoreApp jar success](BookstoreApp/BookstoreApp/assets/screenshot6.PNG)
![BookstoreApp jar success](BookstoreApp/BookstoreApp/assets/screenshot7.PNG)


I went to http://localhost:8080/login and logged in with username "admin" and password "password" to reach http://localhost:8080/admin

![BookstoreApp login](BookstoreApp/BookstoreApp/assets/screenshot8.PNG)
![BookstoreApp admin](BookstoreApp/BookstoreApp/assets/screenshot9.PNG)


### MVN Test

I used another command prompt window and used the command
```bash
mvn test
```
to run the tests.

This method allowed them to be run, and they all passed.

![mvn test success](BookstoreApp/BookstoreApp/assets/screenshot10.PNG)


I then added my own test to the ExampleSeleniumTest.java file and ran mvn test again, and all tests passed once again.

![selenium test code](BookstoreApp/BookstoreApp/assets/screenshot12.PNG)
![mvn tests success](BookstoreApp/BookstoreApp/assets/screenshot11.PNG)
