defmodule Grades.CalculatorTest do
  use ExUnit.Case
  alias Grades.Calculator

  describe "percentage_grade/1" do
    test "sample" do
      assert 85 ==
               Calculator.percentage_grade(%{
                 homework: [0.8],
                 labs: [1, 1, 1],
                 midterm: 0.70,
                 final: 0.9
               })
    end
    test "test1" do 
      assert 77 ==
                Calculator.percentage_grade(%{
                  homework: [0.7],
                  labs: [0.75],
                  midterm: 0.7,
                  final: 0.9
                })
    end
    test "test2" do 
      assert 0 ==
                Calculator.percentage_grade(%{
                  homework: [],
                  labs: [],
                  midterm: 0.0,
                  final: 0.0
                })
    end
  end

  describe "letter_grade/1" do 
    test "test3" do 
      assert "EIN" ==
                  Calculator.letter_grade(%{
                    homework: [],
                    labs: [],
                    midterm: 0.3,
                    final: 0.3
                  })
    end
    test "test4" do 
      assert "A+" ==
                  Calculator.letter_grade(%{
                    homework: [0.9],
                    labs: [0.9,0.93,0.9],
                    midterm: 1.0,
                    final: 1.0
                  })
    end
    test "test5" do 
      assert "A" ==
                  Calculator.letter_grade(%{
                    homework: [0.87],
                    labs: [0.89, 0.84, 0.84],
                    midterm: 0.88,
                    final: 0.89
                  })
    end
    test "test6" do 
      assert "A-" ==
                  Calculator.letter_grade(%{
                    homework: [0.82],
                    labs: [0.83, 0.82, 0.81],
                    midterm: 0.83,
                    final: 0.8
                  })
    end
    test "test7" do 
      assert "B+" ==
                  Calculator.letter_grade(%{
                    homework: [0.78],
                    labs: [0.76, 0.75, 0.77],
                    midterm: 0.78,
                    final: 0.76
                  })
    end
    test "test8" do 
      assert "B" ==
                  Calculator.letter_grade(%{
                    homework: [0.71],
                    labs: [0.73, 0.72, 0.7],
                    midterm: 0.74,
                    final: 0.7
                  })
    end
    test "test9" do 
      assert "C+" ==
                  Calculator.letter_grade(%{
                    homework: [0.66],
                    labs: [0.65, 0.68, 0.67],
                    midterm: 0.65,
                    final: 0.66
                  })
    end
     test "test10" do 
      assert "C" ==
                  Calculator.letter_grade(%{
                    homework: [0.6],
                    labs: [0.61, 0.62, 0.6],
                    midterm: 0.61,
                    final: 0.6
                  })
    end
    test "test11" do 
      assert "D+" ==
                  Calculator.letter_grade(%{
                    homework: [0.56],
                    labs: [0.55, 0.56, 0.57],
                    midterm: 0.56,
                    final: 0.55
                  })
    end
    test "test12" do 
      assert "D" ==
                  Calculator.letter_grade(%{
                    homework: [0.51],
                    labs: [0.5, 0.51, 0.52],
                    midterm: 0.51,
                    final: 0.5
                  })
    end
    test "test13" do 
      assert "E" ==
                  Calculator.letter_grade(%{
                    homework: [0.4],
                    labs: [0.45, 0.45, 0.45],
                    midterm: 0.4,
                    final: 0.4
                  })
    end
    test "test14" do 
      assert "F" ==
                  Calculator.letter_grade(%{
                    homework: [0.4],
                    labs: [0.34, 0.35, 0.33],
                    midterm: 0.4,
                    final: 0.4
                  })
    end
  end
   describe "numeric_grade/1" do 
    test "test15" do 
      assert 0 ==
                  Calculator.numeric_grade(%{
                    homework: [],
                    labs: [],
                    midterm: 0.15,
                    final: 0.2
                  })
    end
    test "test16" do 
      assert 10 ==
                  Calculator.numeric_grade(%{
                    homework: [0.95],
                    labs: [0.9,0.92,0.9],
                    midterm: 1.0,
                    final: 1.0
                  })
    end
    test "test17" do 
      assert 9 ==
                  Calculator.numeric_grade(%{
                    homework: [0.87],
                    labs: [0.87, 0.88, 0.87],
                    midterm: 0.89,
                    final: 0.86
                  })
    end
    test "test18" do 
      assert 8 ==
                  Calculator.numeric_grade(%{
                    homework: [0.81],
                    labs: [0.8, 0.81, 0.8],
                    midterm: 0.82,
                    final: 0.83
                  })
    end
    test "test19" do 
      assert 7 ==
                  Calculator.numeric_grade(%{
                    homework: [0.76],
                    labs: [0.75, 0.77, 0.78],
                    midterm: 0.76,
                    final: 0.75
                  })
    end
    test "test20" do 
      assert 6 ==
                  Calculator.numeric_grade(%{
                    homework: [0.72],
                    labs: [0.73, 0.71, 0.7],
                    midterm: 0.72,
                    final: 0.7
                  })
    end
    test "test21" do 
      assert 5 ==
                  Calculator.numeric_grade(%{
                    homework: [0.66],
                    labs: [0.66, 0.65, 0.65],
                    midterm: 0.65,
                    final: 0.65
                  })
    end
    test "test22" do 
      assert 4 ==
                  Calculator.numeric_grade(%{
                    homework: [0.61],
                    labs: [0.61, 0.62, 0.6],
                    midterm: 0.63,
                    final: 0.6
                  })
    end
    test "test23" do 
      assert 3 ==
                  Calculator.numeric_grade(%{
                    homework: [0.56],
                    labs: [0.56, 0.55, 0.57],
                    midterm: 0.56,
                    final: 0.55
                  })
    end
    test "test24" do 
      assert 2 ==
                  Calculator.numeric_grade(%{
                    homework: [0.51],
                    labs: [0.51, 0.52, 0.5],
                    midterm: 0.5,
                    final: 0.5
                  })
    end
    test "test25" do 
      assert 1 ==
                  Calculator.numeric_grade(%{
                    homework: [0.4],
                    labs: [0.45, 0.46, 0.45],
                    midterm: 0.4,
                    final: 0.4
                  })
    end
    test "test26" do 
      assert 0 ==
                  Calculator.numeric_grade(%{
                    homework: [0.4],
                    labs: [0.36, 0.36, 0.35],
                    midterm: 0.4,
                    final: 0.4
                  })
    end
  end
end
