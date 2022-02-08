package races.rece_members;

import java.time.LocalTime;
import races.race_track.Race;

public class Car implements Runnable {

  private static int CARS_COUNT;

  static {
    CARS_COUNT = 0;
  }

  private Race race;
  private final int speed;
  private final String name;

  public String getName() {
    return name;
  }

  public int getSpeed() {
    return speed;
  }

  public Car(int speed) {
    this.speed = speed;
    CARS_COUNT++;
    this.name = "Участник #" + CARS_COUNT;
  }

  public void setToRace(Race race) {
    this.race = race;
  }

  @Override
  public void run() {
    race.getStages().forEach(stage -> stage.go(this));

    if (Race.winner == null) {
      Race.winner = this;
      System.out.println(this.getName() + " *** ПОБЕДИТЕЛЬ **** с времением: " + LocalTime.now());
    } else {
      System.out.println(this.getName() + " финишировал в: " + LocalTime.now());
    }
    Race.cdl.countDown();
  }

}
