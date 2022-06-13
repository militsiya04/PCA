import java.util.Arrays;

public class Lab4 {
  public static void main(String[] args) {
    int N = 10, key = 32, min = 1, max = 100, counter = 1;
    double[][] source = new double[N][N];
    double[] destination;

    for (int i = 0; i < N; i++)
      for (int j = 0; j < N; j++)
        source[i][j] = (int) (Math.random() * (max - min + 1) + min);
    System.out.println("Initial NxN matrix: ");
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++)
        System.out.printf("%4.0f ", source[i][j]);
      System.out.println();
    }

    for (int i = 0; i < N; i++) {
      destination = Arrays.copyOf(source[i], source[i].length);
      int[] barrierSearchResult = barrierSearch(destination, N, key, i);
      if (barrierSearchResult[0] == -1)
        System.out.printf("Element in %d row wasn't found.%n", i + 1);
      else
        System.out.printf("Row: %d. Column: %d.\n", barrierSearchResult[1] + 1, barrierSearchResult[0] + 1);
    }
    System.out.println("\nSorted NxN matrix: ");

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        source[i][j] = counter;
        System.out.printf("%4.0f ", source[i][j]);
        counter++;
      }
      System.out.println();
    }
    System.out.println();

    for (int i = 0; i < N; i++) {
      destination = Arrays.copyOf(source[i], source[i].length);
      int[] binarySearchResult = binarySearch(destination, N, key, i);
      if (binarySearchResult[0] == -1)
        System.out.printf("Element in %d row wasn't found.%n", i + 1);
      else
        System.out.printf("Row: %d. Column: %d.\n", binarySearchResult[1] + 1, binarySearchResult[0] + 1);
    }
    int[] binarySearchResultSecond = binarySearchTraditional(source, N, key);
    if (binarySearchResultSecond[0] == -1)
      System.out.print("Element wasn't found in the row.\n");
    else
      System.out.printf("%nBinary search 2:%nRow: %d. Column: %d.\n", binarySearchResultSecond[0] + 1,
          binarySearchResultSecond[1] + 1);
  }

  public static int[] barrierSearch(double[] array, int N, int key, int row) {
    int[] array_2 = new int[N + 1];
    for (int i = 0; i <= N; i++) {
      if (i == N)
        array_2[i] = key;
      else
        array_2[i] = (int) array[i];
    }
    int counter = 0;
    while (array_2[counter] != key)
      counter++;

    return counter == N ? new int[] { -1, -1 } : new int[] { counter, row };
  }

  public static int[] binarySearch(double[] array, int N, int key, int row) {
    int l = 0, r = N - 1, m;
    int[] array_2 = new int[N];
    for (int i = 0; i < N; i++)
      array_2[i] = (int) array[i];

    while (l <= r) {
      m = l + (r - l) / 2;
      if (array_2[m] < key)
        l = ++m;
      else if (array_2[m] > key)
        r = --m;
      else
        return new int[] { m, row };
    }
    return new int[] { -1, -1 };
  }

  public static int[] binarySearchTraditional(double[][] array, int N, int key) {
    int[][] array_2 = new int[N][N];
    for (int i = 0; i < N; i++)
      for (int j = 0; j < N; j++)
        array_2[i][j] = (int) array[i][j];

    int l = 0, r = N - 1, index = 0;
    while (index != key) {
      index = array_2[l][r - 1];
      if (index > key)
        r--;
      else if (index < key)
        l++;
      else
        return new int[] { l, r - 1 };
    }
    return new int[] { -1, -1 };
  }
}
