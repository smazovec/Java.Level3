/**
 * Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа)
 */
package task1;

import java.util.Arrays;

public class Task1<T> {

    public static void main(String[] args) {
        Character[] arrayChar = {'q', 'w', 'e', 'r', 't', 'y'};
        System.out.println("До: " + Arrays.toString(arrayChar));
        swapPlaces(arrayChar, 0,1);
        System.out.println("После: " + Arrays.toString(arrayChar));

        Integer[] arrayInt = {1, 2, 3, 4, 5, 6};
        System.out.println("До: " + Arrays.toString(arrayInt));
        swapPlaces(arrayInt, 0,1);
        System.out.println("После: " + Arrays.toString(arrayInt));
        swapPlaces(arrayInt, 3,4);
        System.out.println("После: " + Arrays.toString(arrayInt));
    }

    static <T> T[] swapPlaces(T[] t, int firstElement, int secondElement) {
        if (firstElement >= t.length || secondElement >= t.length) {
            throw new IllegalArgumentException("Элемент за границей массива");
        }

        if (firstElement == secondElement) {
            return t;
        }

        T tmpElement = t[secondElement];
        t[secondElement] = t[firstElement];
        t[firstElement] = tmpElement;

        return t;
    }

}
