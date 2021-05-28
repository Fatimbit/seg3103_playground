import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class DateNextDateExceptionTest
{
  public static void main(String[] args) {
  Result outcome = JUnitCore.runClasses(DateTest.class);

        for (Failure failed : outcome.getFailures())   {
           System.out.println(failed.toString());
        }
        System.out.println(outcome.wasSuccessful());
     }


}
