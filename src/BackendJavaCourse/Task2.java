package BackendJavaCourse;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * Telescopes
 */
public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int telescopes = scanner.nextInt();
        int stars = scanner.nextInt();
        int telescopesModes = scanner.nextInt();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < telescopes; i++) {
            int pi = scanner.nextInt();
            list.add(pi);
        }

        int total = 0;
        for (int i = 0; i < stars; i++) {
            int a = scanner.nextInt() - 1;
            int b = scanner.nextInt() - 1;

            if (!Objects.equals(list.get(a), list.get(b))){
                total++;
            }
        }
        System.out.println(total);
    }
}
