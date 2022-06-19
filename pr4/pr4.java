import java.util.Arrays;

public class pr4{
    public static void main(String[] args) {
        int len = 11, row_len = 7, column_len = 4;
        int min = 0, max = 10;
        int[] array_1D = new int[len];
        makeArray1D(array_1D, min, max, 1);
        product(makeArray1D(array_1D, min, max, 0));
        int[][] array_2D = new int[row_len][column_len];
        makeArray2D(array_2D, min, max, 1);
        sum(makeArray2D(array_2D, min, max, 0));
    }
    public static int[] makeArray1D(int[] array, int min, int max, int key) {
        for (int i = 0; i < array.length; i++)
            array[i] = (int) (Math.random() * (max - min + 1) + min);
        if (key == 1)
            System.out.print("OneD array: " + Arrays.toString(array) + "\n");
        return array;
    }
    public static int[][] makeArray2D(int[][] array, int min, int max, int key) {
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array[0].length; j++)
                array[i][j] = (int) (Math.random() * (max - min + 1) + min);
        if (key == 1) {
            System.out.print("TwoD array:\n");
            for (int[] ints : array) {
                for (int j = 0; j < array[0].length; j++)
                    System.out.printf("%4d ", ints[j]);
                System.out.println();
            }
        }
        return array;
    }
    public static void product (int[] array)
    {
        int buff = 1, counter = 0;
        for (int i = 0; i < array.length && array[i] != 0; i++) {
            buff = buff * array[i];
            counter++;
        }
        if (counter == 0)
            System.out.println("Zero element is first");
        else
            System.out.println("Product of non-zero elements: " + buff);
    }
    public static void sum (int [][] array) {
        int buff = 0, counter = 0;
        for (int[] ints : array) {
            for (int j = 0; j < array[0].length; j++) {
                if (ints[j] > 1) {
                    counter++;
                    buff = buff + ints[j]; }
            }
        }
        System.out.print("Number of elements in twoD array which are greater than 1: " + counter + "\nSum of them: " + buff);
    }
}
