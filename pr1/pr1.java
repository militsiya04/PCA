import java.util.Scanner;
import static java.lang.Math.*;

public class pr1 {
    public static void main (String [] args) {
        double i,j,y;
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter i (with comma if float): ");
        i = sc.nextDouble();
        System.out.println("Enter j (with comma if float): ");
        j = sc.nextDouble();

        if (sin(i + j) <= 0)
            y = PI * pow(sin(i - j), 3);
        else
            y = cbrt(((i + j) / (7 * i + 1) + j) - 3.7 * (i + j));
        System.out.println(y);
    }
}
