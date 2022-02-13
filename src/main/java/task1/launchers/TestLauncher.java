/**
 * Создать класс, который может выполнять «тесты», в качестве тестов выступают классы с наборами
 * методов с аннотациями @Test. Для этого у него должен быть статический метод start(), которому в
 * качестве параметра передается или объект типа Class, или имя класса. Из «класса-теста» вначале
 * должен быть запущен метод с аннотацией @BeforeSuite, если такой имеется, далее запущены методы с
 * аннотациями @Test, а по завершению всех тестов – метод с аннотацией @AfterSuite. К каждому тесту
 * необходимо также добавить приоритеты (int числа от 1 до 10), в соответствии с которыми будет
 * выбираться порядок их выполнения, если приоритет одинаковый, то порядок не имеет значения. Методы
 * с аннотациями @BeforeSuite и @AfterSuite должны присутствовать в единственном экземпляре, иначе
 * необходимо бросить RuntimeException при запуске «тестирования».
 */

package task1.launchers;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import task1.annotations.AfterSuite;
import task1.annotations.BeforeSuite;
import task1.annotations.Test;

public class TestLauncher {

  public static void start(String ClazzName) {
    try {
      start(Class.forName(ClazzName));
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  public static void start(Class Clazz) {
    Method beforeSuiteMethod = null;
    Set<Method> priorityTestMethods = new TreeSet<>(new TestComparator<>());
    Method afterSuiteMethod = null;

    Method[] methods = Clazz.getDeclaredMethods();
    for (Method method : methods) {

      // Check @BeforeSuite annotation
      if (method.getAnnotation(BeforeSuite.class) != null) {
        if (beforeSuiteMethod == null) {
          beforeSuiteMethod = method;
        } else {
          throw new RuntimeException("The method with @BeforeSuite in should be the only one!");
        }
      }

      // Check @AfterSuite annotation
      if (method.getAnnotation(AfterSuite.class) != null) {
        if (afterSuiteMethod == null) {
          afterSuiteMethod = method;
        } else {
          throw new RuntimeException("The method with @AfterSuite in should be the only one!");
        }
      }

      if (method.getAnnotation(Test.class) != null) {
        priorityTestMethods.add(method);
      }
    }

    try {

      // Создаем объект, на котором будут вызываться тесты
      Object testObject = Clazz.newInstance();

      // Первым должен быть запущен метод с аннотацией @BeforeSuite, если такой имеется
      if (beforeSuiteMethod != null) {
        beforeSuiteMethod.invoke(testObject);
      }

      // Далее должны быть запущены методы с аннотациями @Test
      // К каждому тесту добавлен приоритет (от 1 до 10), в соответствии с которыми выбираесся
      // порядок их выполнения. Если приоритет одинаковый, то порядок не имеет значения.
      for (Method testMethod : priorityTestMethods) {
        testMethod.invoke(testObject);
      }

      // Последним должен быть запущен метод с аннотацией @AfterSuite
      if (afterSuiteMethod != null) {
        afterSuiteMethod.invoke(testObject);
      }

    } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
      e.printStackTrace();
    }
  }

  private static class TestComparator<T extends Method> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
      return o1.getAnnotation(Test.class).priority() - o2.getAnnotation(Test.class).priority();
    }

  }

}
