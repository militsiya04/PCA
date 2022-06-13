import java.util.Scanner;

public class Lab1 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Task 1. Enter the size of matrix N*N: ");
    int size1 = sc.nextInt();
    int[][] twoDimArray1 = new int[size1][size1];
    int max = 50, min = -50;
    int[][] Matrix = makeMatrix(twoDimArray1, min, max);
    System.out.println("Inital matrix: ");
    printMatrix(Matrix);
    transformMatrix(Matrix);
    System.out.println("Task 2. Enter the size of matrix N*N: ");
    int size2 = sc.nextInt();
    int[][] twoDimArray2 = new int[size2][size2];
    int[][] Matrix2 = makeMatrix(twoDimArray2, min, max);
    System.out.println("Initial matrix: ");
    task2(size2, Matrix2);
    sc.close();
  }

  public static int[][] makeMatrix(int[][] twoDimArray, int min, int max) {
    for (int i = 0; i < twoDimArray.length; i++) {
      for (int j = 0; j < twoDimArray.length; j++)
        twoDimArray[i][j] = (int) (Math.random() * (max - min + 1) + min);
    }
    return twoDimArray;
  }

  public static void printMatrix(int[][] twoDimArray) {
    for (int[] ints : twoDimArray) {
      for (int j = 0; j < twoDimArray.length; j++)
        System.out.printf("%4d ", ints[j]);
      System.out.println();
    }
  }

  public static void transformMatrix(int[][] Matrix) {
    int i, j;
    int temp_var = Matrix[0][0];
    int i_index = 0, j_index = 0;
    int number_of_rows = 0;
    for (i = 0; i < Matrix.length; i++) {
      for (j = 0; j < Matrix.length; j++) {
        if (Matrix[i][j] > temp_var) {
          temp_var = Matrix[i][j];
          i_index = i;
          j_index = j;
          number_of_rows = j--;
        }
      }
    }
    System.out.println("Max element: " + temp_var);
    System.out.printf("His indexes: [%d][%d]%n", i_index, j_index);
    System.out.println("Rows on the left: " + number_of_rows);

    if (number_of_rows > 1) {
      for (int k = 0; k < Matrix.length; k++) {
        for (int p = j_index - 1; p > 0; p--) {
          int buff1 = Matrix[k][p];
          Matrix[k][p] = Matrix[k][p - 1];
          Matrix[k][p - 1] = buff1;
        }
      }
    }

    for (int[] ints : Matrix) {
      for (j = 0; j < Matrix.length; j++)
        System.out.printf("%4d ", ints[j]);
      System.out.println();
    }
  }

  public static void task2(int size2, int[][] twoDimArray2) {
    int N = size2 / 2;

    for (int i = 0; i < size2; i++) {
      for (int j = 0; j < size2; j++)

        System.out.printf("%4d ", twoDimArray2[i][j]);

      System.out.println();
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (i >= j) {
          int temp1 = twoDimArray2[i][j];
          twoDimArray2[i][j] = twoDimArray2[size2 - i - 1][j];
          twoDimArray2[size2 - i - 1][j] = temp1;

          int temp2 = twoDimArray2[i][size2 - j - 1];
          twoDimArray2[i][size2 - j - 1] = twoDimArray2[size2 - i - 1][size2 - j - 1];
          twoDimArray2[size2 - i - 1][size2 - j - 1] = temp2;
        }
      }
    }
    System.out.println("Changed matrix by diagonals: ");

    for (int i = 0; i < size2; i++) {
      for (int j = 0; j < size2; j++)
        System.out.printf("%4d ", twoDimArray2[i][j]);
      System.out.println();
    }
  }
}
