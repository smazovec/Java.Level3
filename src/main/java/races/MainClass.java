/**
 * Организуем гонки: Все участники должны стартовать одновременно, несмотря на то, что на подготовку
 * у каждого из них уходит разное время. В туннель не может заехать одновременно больше половины
 * участников (условность). Попробуйте всё это синхронизировать. Только после того как все завершат
 * гонку, нужно выдать объявление об окончании. Можете корректировать классы (в т.ч. конструктор
 * машин) и добавлять объекты классов из пакета util.concurrent.
 */

package races;

import races.race_track.Race;
import races.race_track.Road;
import races.race_track.Start;
import races.race_track.Tunnel;
import races.rece_members.Car;

public class MainClass {

  public static final int CARS_COUNT = 4;

  public static void main(String[] args) {

    // Подготовка машин и трассы
    Car[] cars = new Car[CARS_COUNT];
    for (int i = 0; i < cars.length; i++) {
      cars[i] = new Car(20 + (int) (Math.random() * 30));
    }

    // Стратовую позицию тоже будем рассматривать как этап гонки для универсальности
    Race race = new Race(cars, new Start(), new Road(60), new Tunnel(), new Road(40));

    // Старт гонки
    race.start();
  }
}
