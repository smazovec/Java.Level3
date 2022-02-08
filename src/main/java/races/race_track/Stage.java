package races.race_track;

import races.rece_members.Car;

public abstract class Stage {

  protected int length;
  protected int passedCounter;
  protected String description;
  protected Race race;

  public String getDescription() {
    return description;
  }

  public void setRace(Race race) {
    this.race = race;
  }

  public abstract void go(Car cб);

}
