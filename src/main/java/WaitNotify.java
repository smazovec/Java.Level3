/**
 * 1. Создать три потока, каждый из которых выводит определенную букву (A, B и C) 5 раз (порядок –
 * ABСABСABС). Используйте wait/notify/notifyAll.
 */

public class WaitNotify {

  private final LettersSequencer mon = new LettersSequencer();

  public static void main(String[] args) {
    WaitNotify wn = new WaitNotify();
    new Thread(() -> wn.printTheLetter('A')).start();
    new Thread(() -> wn.printTheLetter('B')).start();
    new Thread(() -> wn.printTheLetter('C')).start();
  }

  private void printTheLetter(char Letter) {

    synchronized (mon) {
      try {
        for (int i = 0; i < 5; i++) {
          while (mon.currentLetter() != Letter) {
            mon.wait();
          }
          System.out.print(Letter);
          mon.nextLetter();
          mon.notifyAll();
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

}
