# Lab 01

| Outline | Value |
| --- | --- |
| Course | SEG 3X03 |
| Date | Summer 2021 |
| Professor | Andrew Forward, aforward@uottawa.ca |
| TA | James Url, jamesurl@uottawa.ca |
| Team | Andrew Forward 1484511<br>Ayana Forward 9021000 |

## Deliverables

* [https://github.com/aforward/seg3103_playground/tree/main/lab01](https://github.com/aforward/seg3103_playground/tree/main/lab01)
* Shared repo above with TA and Professors

### Java

I am running Java 14.0.1

```bash
java --version
java 14.0.1 2020-04-14
Java(TM) SE Runtime Environment (build 14.0.1+7)
Java HotSpot(TM) 64-Bit Server VM (build 14.0.1+7, mixed mode, sharing)
```

To run the Java program (in `newmath_java`), first I compile it

```bash
javac -encoding UTF-8 --source-path src -d dist src/*.java
```

Then I run it

```bash
java -cp ./dist Main
```

Here is an output of the running program

```bash
Newmath (type 'exit' to exit program)
Numerator: 10
Demoninator: 2
10 / 2 = 5
Numerator: 6
Demoninator: 7
6 / 7 = 0
Numerator: 7
Demoninator: 7
7 / 7 = 1
Numerator: exit
```

With a screenshot from the terminal

![image](https://user-images.githubusercontent.com/55173033/118740953-2176e580-b81b-11eb-9a7d-0cd925060576.png)


### JUnit

I am working with JUnit 5 (via Console standalone 1.7.1)

To run JUnit, I need to compile the application (see above), and then compile the test code

```bash
javac -encoding UTF-8 --source-path test -d dist -cp lib/junit-platform-console-standalone-1.7.1.jar test/*.java src/*.java
```

Then I run the tests using

```
java -jar lib/junit-platform-console-standalone-1.7.1.jar --class-path dist --scan-class-path
```

Here is the output of the tests

```bash
Thanks for using JUnit! Support its development at https://junit.org/sponsoring

[36m.[0m
[36m+--[0m [36mJUnit Jupiter[0m [32m[OK][0m
[36m| '--[0m [36mNewmathTest[0m [32m[OK][0m
[36m|   +--[0m [34mdiv_ok()[0m [32m[OK][0m
[36m|   '--[0m [34mdiv_by_zero()[0m [32m[OK][0m
[36m'--[0m [36mJUnit Vintage[0m [32m[OK][0m

Test run finished after 69 ms
[         3 containers found      ]
[         0 containers skipped    ]
[         3 containers started    ]
[         0 containers aborted    ]
[         3 containers successful ]
[         0 containers failed     ]
[         2 tests found           ]
[         0 tests skipped         ]
[         2 tests started         ]
[         0 tests aborted         ]
[         2 tests successful      ]
[         0 tests failed          ]

```

With a screenshot from the terminal

![Running JUnit in the console](https://user-images.githubusercontent.com/55173033/118740994-3f444a80-b81b-11eb-9cef-94e9f5ecf2c8.png)


### Elixir

I am running Elixir 1.11.4 with Erlang 21

```bash
elixir --version
Erlang/OTP 21 [erts-10.3] [64-bit] [smp:12:12] [ds:12:12:10] [async-threads:1]

Elixir 1.11.4 (compiled with Erlang/OTP 21)
```

To run the Elixir program (in `newmath_ex`), first I compile it

```bash
mix compile
Compiling 1 file (.ex)
Generated newmath_ex app
```

Then I run it

```bash
iex -S mix
```

Here is an output of the running program

```elixir
Interactive Elixir (1.11.4) - press Ctrl+C to exit (type h() ENTER for help)
iex(1)> NewmathEx.div(10,2)
{:ok, 5.0}
iex(2)>
nil
iex(3)> Terminate batch job (Y/N)? y
```

With a screenshot from the terminal

![Running Elixir in the console](https://user-images.githubusercontent.com/55173033/118741045-5d11af80-b81b-11eb-98c4-55742b0b3343.png)

### ExUnit

ExUnit is built directly into Elixir (and compiled like above with `mix compile`)

To run the tests

```
mix test
```

Here is the output of the tests

```bash
Compiling 1 file (.ex)
Generated newmath_ex app
...

Finished in 0.1 seconds
1 doctest, 2 tests, 0 failures

Randomized with seed 386000

```

With a screenshot from the terminal

![Running ExUnit in the console](https://user-images.githubusercontent.com/55173033/118741091-731f7000-b81b-11eb-8415-2238a248dda2.png)
