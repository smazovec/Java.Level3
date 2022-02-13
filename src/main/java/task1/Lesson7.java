package task1;

import task1.annotations.AfterSuite;
import task1.annotations.BeforeSuite;
import task1.annotations.Test;
import task1.launchers.TestLauncher;

public class Lesson7 {

  public static void main(String[] args) {
    Lesson7 testClass = new Lesson7();
    System.out.println("Первый вариант вызова");
    TestLauncher.start(testClass.getClass());
    System.out.println();
    System.out.println("Второй вариант вызова");
    TestLauncher.start("task1.Lesson7");

  }

  @BeforeSuite
  public void testBeforeSuite() {
    System.out.println("Выполнен тест метода testBeforeSuite()");
  }

  @Test(priority = 5)
  public void testMethod5() {
    System.out.println("Выполнен тест метода testMethod5()");
  }

  @Test(priority = 1)
  public void testMethod1() {
    System.out.println("Выполнен тест метода testMethod1()");
  }

  @Test(priority = 2)
  public void testMethod2() {
    System.out.println("Выполнен тест метода testMethod2()");
  }

  @Test(priority = 3)
  public void testMethod3() {
    System.out.println("Выполнен тест метода testMethod3()");
  }

  @AfterSuite
  public void testAfterSuite() {
    System.out.println("Выполнен тест метода testAfterSuite()");
  }

}
