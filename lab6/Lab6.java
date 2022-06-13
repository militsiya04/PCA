import java.util.Arrays;
import static java.lang.Math.random;

public class Lab6 {
    public static void main(String[] args) {
        int m = 5, n = 5;
        int min = 0, max = 1;
        int[][] a = new int[m][n];
        int[][] d = new int[a.length][a[0].length];
        int[][] e = new int[m][n-1];
        int counter = 0;
        int[] destination;

        System.out.println("Task 1: ");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                a[i][j] = (int) (random() * (max - min + 1) + min);
                System.out.printf("%4d", a[i][j]);
                if (a[i][j] != 0)
                    counter++;
            }
            System.out.println();
        }


        int[] b = new int[counter];
        int[] c = new int[counter];
        int[] z = new int[a.length];


        for (int i = 0; i < a.length; i++) {
            destination = Arrays.copyOf(a[i], a[i].length);
            z[i] = zero_counter(destination);
        }

        int k = 0;
        fill: {
            for (int[] ints : a) {
                for (int j = 0; j < a[0].length; j++) {
                    if (ints[j] != 0) {
                        b[k] = ints[j];
                        c[k] = j;
                        k++;
                    }
                    if (k == counter)
                        break fill;
                }
            }
        }

        System.out.println("\nNot-zero elements: " + Arrays.toString(b));
        System.out.println("Their indexes:  " +Arrays.toString(c));
        System.out.println("Number of not-zero elements in the row from 0 to n-1: " + Arrays.toString(z));

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) 
                d[i][j] = 0;
        }
        k = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length - z[i]; j++) {
                d[i][c[k]] = b[k];
                k++;
            }
        }

        System.out.println("Restored sparse matrix: " +Arrays.deepToString(d));

        if (Arrays.deepEquals(a, d))
            System.out.println("\nElements of matrixes a,d are equal.\n");
        else
            System.out.println("Elements of matrixes a,d aren't equal.\n");

        for (int i = 0; i < e.length; i++)
            for (int j = 0; j < e[0].length; j++)
                e[i][j] = (int) (random() * (max - min + 1) + min);

        System.out.println("Task 2: \nInitial array: "+ Arrays.deepToString(e));
        if (e[0].length % 2 == 0) {
            for (int i = 0; i < e.length; i++) {
                int l = (e[0].length / 2) - 1;
                int r = e[0].length / 2;
                for (int j = 0; j < Math.ceil((float) e[0].length / 4) - 1; j++) {
                    if (j == 0) {
                        int tmp2 = e[i][l];
                        e[i][l] = e[i][r];
                        e[i][r] = tmp2;
                        l--;
                        r++;
                    }
                    int tmp = e[i][l];
                    e[i][l] = e[i][j];
                    e[i][j] = tmp;
                    tmp = e[i][r];
                    e[i][r] = e[i][e[0].length - (j + 1)];
                    e[i][e[0].length - (j + 1)] = tmp;
                    l--;
                    r++;
                }
            }
        }
        else {
            for (int i = 0; i < e.length; i++) {
                int l = (e[0].length / 2) - 1;
                int r = (e[0].length / 2) + 1;
                for (int j = 0; j < Math.ceil((float) e[0].length / 4) - 1; j++) {
                    int tmp = e[i][l];
                    e[i][l] = e[i][j];
                    e[i][j] = tmp;
                    tmp = e[i][r];
                    d[i][r] = d[i][e[0].length - (j + 1)];
                    d[i][e[0].length - (j + 1)] = tmp;
                    l--;
                    r++;
                }
            }
        }
        System.out.println("Changed array with regards to task: " +Arrays.deepToString(e));
    }

    public static int zero_counter(int[] array) {
        int counter = 0;
        for (int j : array) {
            if (j == 0)
                counter++;
        }
        return counter;
    }
}
