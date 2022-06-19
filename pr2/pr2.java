import java.util.Arrays;
import java.util.Scanner;

public class pr2 {
    public static void main(String[] args) {
        int len, min, max, key, result;
        Scanner sc = new Scanner(System.in);
        System.out.print("How many elements in the array: ");
        len = sc.nextInt();
        int[] array = new int[len];
        min = 1; max = 50;
        System.out.print("Enter the value for searching: ");
        key = sc.nextInt();
        System.out.print((Arrays.toString(makeArray(array, min, max))));
        result = linearSearch(array, key);
        if (result == -1)
            System.out.println ("\nThere is no such element with the key entered.");
        else
            System.out.println ("\nIndex of element found: " +result);
    }
    public static int [] makeArray (int[] array, int min, int max)
    {
        for (int i = 0; i < array.length; i++)
            array[i] = (int) (Math.random() * (max - min + 1) + min);
        return array;
    }
    public static int linearSearch (int[] array, int key)
    {
        int counter = 0;
        while (counter < array.length && array[counter] != key) {
            counter++;
            if (counter == array.length)
                return -1; }
        return counter;
    }
}
