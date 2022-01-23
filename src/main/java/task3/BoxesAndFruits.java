package task3;

import task3.fruit.Apple;
import task3.fruit.Orange;

public class BoxesAndFruits {

    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        Box<Orange> orangeBox = new Box<>();
        Box<Apple> appleBox2 = new Box<>();

        for (int i = 0; i < 10; i++) {
            appleBox.add(new Apple());
            orangeBox.add(new Orange());
        }

        System.out.println("В первой коробке с яблоками: " + appleBox.getWeight());
        System.out.println("В коробка с апельсинами: " + orangeBox.getWeight());
        System.out.println(appleBox.compare(orangeBox) ? "Коробки равны по весу": "Коробки не равны по весу");
        System.out.println("Добавим в первую коробку яблок");

        for (int i = 0; i < 5; i++) {
            appleBox.add(new Apple());
            appleBox2.add(new Apple());
        }

        System.out.println(appleBox.compare(orangeBox) ? "Коробки равны по весу": "Коробки не равны по весу");

        System.out.println("Пересыпаем яблоки во вторую коробку");
        System.out.println(appleBox.pourInto(appleBox2) ? "Пересыпали успешно" : "нельзя пересыпать");

        System.out.println("В первой коробке с яблоками: " + appleBox.getWeight());
        System.out.println("Во второй коробке с яблоками: " + appleBox2.getWeight());

    }
}
