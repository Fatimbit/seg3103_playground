defmodule Grades.Calculator do


  def avg(homework, labs) do            #refactored for Question 2.1 (Github commit "Question 2.1 Refactored Complete")
    avg_homework =
      if Enum.count(homework) == 0 do
        0
      else
        Enum.sum(homework) / Enum.count(homework)
    end

  avg_labs =
    if Enum.count(labs) == 0 do
      0
    else
      Enum.sum(labs) / Enum.count(labs)
    end

    {avg_homework,avg_labs}
    end


    def failed_to_participate(avg_homework, avg_exams, num_labs) do       #refactored for Question 2.2 (Github commit "Question 2.2 Refactored Complete")
    avg_homework < 0.4 || avg_exams < 0.4 || num_labs < 3
    end


    def calculate_grade(avg_labs, avg_homework, midterm, final) do          #refactored for Question 2.3 (Github commit "Question 2.3 Refactored Complete")
      0.2 * avg_labs+ 0.3 * avg_homework + 0.2 * midterm + 0.3 * final
    end


    def calculate_numLabs(labs) do                                        #refactored for Question 2.4 (Github commit "Question 2.4 Refactored Part 1/2")
      labs
      |> Enum.reject(fn mark -> mark < 0.25 end)
      |> Enum.count()

    end


    def calculate_avg_exams(midterm, final) do                          #refactored for Question 2.4 (Github commit "Question 2.4 Refactored Part 2/2")
      (midterm + final) / 2
    end





  def percentage_grade(%{homework: homework, labs: labs, midterm: midterm, final: final}) do
    {avg_homework, avg_labs} = avg(homework, labs)
    mark = calculate_grade(avg_labs, avg_homework, midterm, final)
    round(mark * 100)
  end

  def letter_grade(%{homework: homework, labs: labs, midterm: midterm, final: final}) do
   {avg_homework, avg_labs} = avg(homework, labs)
    avg_exams = calculate_avg_exams(midterm, final)

    num_labs = calculate_numLabs(labs)

    if failed_to_participate(avg_homework,avg_exams,num_labs) do
      "EIN"
    else
      mark = calculate_grade(avg_labs, avg_homework, midterm, final)

      cond do
        mark > 0.895 -> "A+"
        mark > 0.845 -> "A"
        mark > 0.795 -> "A-"
        mark > 0.745 -> "B+"
        mark > 0.695 -> "B"
        mark > 0.645 -> "C+"
        mark > 0.595 -> "C"
        mark > 0.545 -> "D+"
        mark > 0.495 -> "D"
        mark > 0.395 -> "E"
        :else -> "F"
      end
    end
  end

  def numeric_grade(%{homework: homework, labs: labs, midterm: midterm, final: final}) do
  {avg_homework, avg_labs} = avg(homework, labs)

    avg_exams = calculate_avg_exams(midterm, final)

    num_labs = calculate_numLabs(labs)

    if failed_to_participate(avg_homework,avg_exams,num_labs) do
      0
    else
      mark = calculate_grade(avg_labs, avg_homework, midterm, final)

      cond do
        mark > 0.895 -> 10
        mark > 0.845 -> 9
        mark > 0.795 -> 8
        mark > 0.745 -> 7
        mark > 0.695 -> 6
        mark > 0.645 -> 5
        mark > 0.595 -> 4
        mark > 0.545 -> 3
        mark > 0.495 -> 2
        mark > 0.395 -> 1
        :else -> 0
      end
    end
  end
end
