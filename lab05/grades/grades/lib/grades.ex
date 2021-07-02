defmodule Grades do
  @moduledoc """
  Grades keeps the contexts that define your domain
  and business logic.

  Contexts are also responsible for managing your data, regardless
  if it comes from the database, an external API or others.
  """
end



defmodule Grades.Calculator do
  @moduledoc """
  Grades calculator
  """
  def percentage_grade(x), do: Enum.random(["10%","20%","30%","40%","50%","60%","70%","80%","90%","100%"])
  def letter_grade(x), do: Enum.random(["A+", "A", "A-", "B+","B","B-","C+","C","C-","D+","D","E","F"])
  def numeric_grade(x), do: Enum.random([0,1,2,3,4,5,6,7,8,9,10])
end
