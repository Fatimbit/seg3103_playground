# Lab 05
| Outline | Value |
| --- | --- |
| Course | SEG 3X03 |
| Date | Summer 2021 |
| Professor | Andrew Forward, aforward@uottawa.ca |
| TA | Henry Chen, zchen229@uottawa.ca|
| Team | Fatimah Vakily 300125671 |

### Elixir
I am running Elixir 1.11.4 with Erlang 21

### Grades
I first tried to compile using the following command

```
mix compile
```

This gave me the following errors:
![Grades Result](grades/grades/assets/screenshot1.PNG)




I also used:

```
cd assets && npm install
```
Which gave me this result:
![Grades Result](grades/grades/assets/screenshot2.PNG)




To fix the earlier errors that arose when I tried to use "mix compile", I used:
```
mix deps.get
```
This was then displayed in the cmd:
![Grades Result](grades/grades/assets/screenshot3.PNG)


Now I tried using
```
mix phx.server
```

And then went to http://localhost:4000 and it displayed this:
![Grades Result](grades/grades/assets/screenshot4.PNG)

But gave this result when the "Calculate" button was pressed:
![Grades Result](grades/grades/assets/screenshot5.PNG)


I stubbed the code to display random values:
![Grades Result](grades/grades/assets/screenshot6.PNG)
