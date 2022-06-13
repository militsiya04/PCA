import java.util.Scanner;
import static java.lang.Math.*;

public class Lab2 {
  public static void main(String[] args) {
    int l = 2;
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter number of interations n: ");
    int n = sc.nextInt();
    sc.close();
    double r = recursion_calc(l, n);
    final long startTime = System.nanoTime();
    System.out.println("Recursive calctulation result: " + "\nr = " + r);
    final long nanoseconds_rec = System.nanoTime() - startTime;
    System.out.printf("%n%nRecursive calculation time:%n%d nanoseconds%n%n", nanoseconds_rec);
    System.out.println("Loop calculation result\n" + loop_calc(2, n));
    final long nanoseconds_loop = System.nanoTime() - startTime;
    System.out.printf("%n%nLoop calculation time:%n%d nanoseconds%n%n", nanoseconds_loop - nanoseconds_rec);
  }

  public static double recursion_calc(int l, int n) {
    if (l == n + 1)
      return 1;
    else
      return sin(l) / pow((l - 1), 2) * recursion_calc(l + 1, n);
  }

  public static double loop_calc(int l, int n) {
    double r = 1;
    for (int i = l; i <= n; i++)
      r = r * (sin(i) / pow((i - 1), 2));
    return r;
  }
}
