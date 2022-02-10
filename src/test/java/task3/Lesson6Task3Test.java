package task3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Lesson6Task3Test {

  private Lesson6Task3 lesson6Task3;

  @BeforeEach
  public void init() {
    lesson6Task3 = new Lesson6Task3();
  }

  @ParameterizedTest
  @MethodSource("dataForArrayAfterTheFour")
  public void testArrayAfterTheFour(int[] array, int[] result) {
    Assertions.assertTrue(Arrays.equals(result, lesson6Task3.getArrayAfterTheFour(array)));
  }

  public static Stream<Arguments> dataForArrayAfterTheFour() {
    List<Arguments> out = new ArrayList<>();
    out.add(Arguments.arguments(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}, new int[]{1, 7}));
    out.add(Arguments.arguments(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{5, 6, 7}));
    out.add(Arguments.arguments(new int[]{1, 2, 3, 5, 5, 6, 4}, new int[]{}));
    return out.stream();
  }

  @Test
  public void checkArrayAfterTheFour() {
    Assertions.assertThrows(RuntimeException.class, () -> {
      lesson6Task3.getArrayAfterTheFour(new int[]{1, 2, 3, 5, 5, 6, 7});
    });
  }

}
