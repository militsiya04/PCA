public class Lab3 {
    public static void main(String[] args) {
        int N = 10;
        int[][] array_first = new int[N][N];
        int [][] array_second = new int[N][N];
        int row = 0, colm = 0;
        int min = 1, max = 49;
        makeMatrix(array_first, N, min, max);
        printFinalMatrix(array_first, bubbleSort(transposeMatrix(array_first, array_second, N), N), N, 0);
        makeMatrix(array_first, N, min, max);
        printFinalMatrix(array_first, selectionSort(transposeMatrix(array_first, array_second, N), N, row, colm), N, 1);

    }

    public static int [][] makeMatrix (int [][] array_first, int N, int min, int max)
    {
        System.out.println("\nInitial matrix: ");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                array_first[i][j] = (int) (Math.random() * (max - min + 1) + min);
                System.out.printf("%4d ", array_first[i][j]);
            }
            System.out.println();
        }
        return array_first;
    }
    public static int [][] transposeMatrix (int [][] array_first, int[][] array_second, int N)
    {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) 
                array_second[i][j] = array_first[N - j - 1][N - i - 1];
        }
        return array_second;
    }
    public static int [][] bubbleSort (int [][] array_second, int N)
    {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    if (i <= j) {
                        if (array_second[i][k] < array_second[i][j]) {
                            int temp = array_second[i][k];
                            array_second[i][k] = array_second[i][j];
                            array_second[i][j] = temp;
                        }
                    }
                }
            }
        }
        return array_second;
    }
    public static int [][] selectionSort (int [][] array_second, int N, int row, int colm) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = i; k < N; k++) {
                    row = k;
                    colm = j;
                    for (int z = j; z < N; z++) {
                        if (k <= z) {
                            if (array_second[k][z] < array_second[row][colm]) {
                                row = k;
                                colm = z;
                            }
                        }
                    }
                    if (k <= j) {
                        int temp = array_second[k][j];
                        array_second[k][j] = array_second[row][colm];
                        array_second[row][colm] = temp;
                    }
                }
            }
        }
        return array_second;
    }
    public static void printFinalMatrix (int [][] array_first, int [][] array_second, int N, int sortType) {
        String x = (sortType == 0) ? "\nBubbleSorted matrix:" :
                "\nselectionSorted matrix:";
        System.out.println(x);
        for (int i = N - 1; i >= 0; i--) {
            for (int j = N - 1; j >= 0; j--) {
                array_first[i][j] = array_second[j][N - i - 1];
                System.out.printf("%4d ", array_first[i][j]);
            }
            System.out.println();
        }
    }
}
