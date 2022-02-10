package task4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Lesson6Task4Test {

  private Lesson6Task4 lesson6Task4;

  @BeforeEach
  public void init() {
    lesson6Task4 = new Lesson6Task4();
  }

  @ParameterizedTest
  @MethodSource("dataForOnlyFoursAndOnes")
  public void testOnlyFoursAndOnes(int[] array, boolean result) {
    Assertions.assertEquals(result, lesson6Task4.onlyFoursAndOnes(array));
  }

  public static Stream<Arguments> dataForOnlyFoursAndOnes() {
    List<Arguments> out = new ArrayList<>();
    out.add(Arguments.arguments(new int[]{1, 1, 1, 4, 4, 1, 4, 4}, true));
    out.add(Arguments.arguments(new int[]{1, 1, 1, 1, 1, 1}, false));
    out.add(Arguments.arguments(new int[]{4, 4, 4, 4,}, false));
    out.add(Arguments.arguments(new int[]{1, 4, 4, 1, 1, 4, 3}, false));
    return out.stream();
  }

}
