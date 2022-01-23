/**
 * Написать метод, который преобразует массив в ArrayList
 */
package task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task2 {

    public static void main(String[] args) {
        Integer[] arrayInt = {1, 2, 3, 4, 5, 6};
        List<Integer> integerList = arrayToArrayList(arrayInt);
        integerList.add(7);
        System.out.println(integerList);

    }

    static <T> List<T> arrayToArrayList(T... t) {
        return new ArrayList<>(Arrays.asList(t));
    }
}
