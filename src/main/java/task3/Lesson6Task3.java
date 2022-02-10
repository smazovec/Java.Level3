package task3;

public class Lesson6Task3 {

  public static void main(String[] args) {
  }

  public int[] getArrayAfterTheFour(int[] sourceArray) {
    int[] resultArray = new int[0];
    int j = -1;

    for (int i = 0; i < sourceArray.length; i++) {
      if (sourceArray[i] == 4) {
        resultArray = new int[sourceArray.length - i - 1];
        j = 0;
      } else if (j >= 0) {
        resultArray[j] = sourceArray[i];
        j++;
      }
    }
    if (j == -1) {
      throw new RuntimeException();
    }
    return resultArray;
  }

}
