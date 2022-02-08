package races.race_track;

import java.time.LocalTime;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import races.MainClass;
import races.rece_members.Car;

public class Start extends Stage {

  static CyclicBarrier successChecker = new CyclicBarrier(MainClass.CARS_COUNT);

  public Start() {
    this.length = 0;
    this.description = "Стартовая позиция на " + MainClass.CARS_COUNT + " машин";
  }

  @Override
  public void go(Car c) {
    try {
      System.out.println(c.getName() + " готовится");
      Thread.sleep(500 + (int) (Math.random() * 800));
      System.out.println(c.getName() + " готов мчаться на скорости " + c.getSpeed() + " км/ч");
      passedCounter++;
      if (passedCounter == MainClass.CARS_COUNT) {
        System.out.print("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        System.out.println(" На секундомере: " + LocalTime.now());
      }
      successChecker.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (BrokenBarrierException e) {
      e.printStackTrace();
    }
  }

}
