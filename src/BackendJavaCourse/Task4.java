package BackendJavaCourse;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Build a Server
 */
public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }

        list.sort(Integer::compareTo);

        int maxSum = 0;
        for (int i = 0; i < list.size(); i++) {
            int sum = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                int temp = list.get(j);

                while(!(temp % list.get(i) == 0)){
                    temp--;
                }
                sum += temp;
            }
            if (sum > maxSum){
                maxSum = sum;
            }
        }
        System.out.printf("%d",maxSum);
    }
}
