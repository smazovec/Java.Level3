package races.race_track;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import races.MainClass;
import races.rece_members.Car;

public class Race {

  public static final CountDownLatch cdl = new CountDownLatch(MainClass.CARS_COUNT);
  public static volatile Car winner;
  private final ArrayList<Stage> stages;
  private final ArrayList<Car> cars;

  public ArrayList<Stage> getStages() {
    return stages;
  }

  public Race(Car[] cars, Stage... stages) {
    this.cars = new ArrayList<>(Arrays.asList(cars));
    this.cars.forEach(car -> car.setToRace(this));
    this.stages = new ArrayList<>(Arrays.asList(stages));
    this.stages.forEach(stage -> stage.setRace(this));
  }

  public void start() {
    System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
    cars.forEach((car) -> new Thread(car).start());
    try {
      Race.cdl.await();
      System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }

}
