package task4;

public class Lesson6Task4 {

  public static void main(String[] args) {
  }

  public boolean onlyFoursAndOnes(int[] sourceArray) {
    boolean foursDetected = false;
    boolean onesDetected = false;
    boolean otherDetected = false;
    for (int currentNumber : sourceArray) {
      if (currentNumber == 4) {
        foursDetected = true;
      } else if (currentNumber == 1) {
        onesDetected = true;
      } else {
        otherDetected = true;
      }
    }
    return foursDetected && onesDetected && !otherDetected;
  }

}
