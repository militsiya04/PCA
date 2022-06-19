import java.lang.Math;
import java.util.Arrays;

public class pr3 {
    public static void main(String[] args) {
        int N = 20;
        int[] a = new int[N];
        int[] b = new int[N];

        for (int i = 0; i < N; i++)
            a[i] = (int) (Math.random() * (N - 1) + 1);

        System.out.println("Array a: "+Arrays.toString(a));

        for (int i = 0; i < N; i++) {
            b[i] = a[N - i - 1];
        }
        System.out.println("Array b: "+Arrays.toString(b));
        System.out.println("Sorted array b: "+Arrays.toString(insertionSort(b,N)));
    }

    public static int [] insertionSort (int [] b, int N)
    {
        for (int i = 1; i < N; i++)
        {
            int key = b[i];
            int j = i - 1;

            while (j >= 0 && b[j] > key)
            {
                b[j + 1] = b[j];
                j = j - 1;
            }
            b[j + 1] = key;
        }
        return b;
    }
}
