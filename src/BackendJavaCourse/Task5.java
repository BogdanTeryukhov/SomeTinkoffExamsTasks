package BackendJavaCourse;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Digital Cipher
 */

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        char[] chars = str.toCharArray();

        boolean flag = false;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (flag){
                break;
            }
            list.add(chars[i] - 48);

            for (int j = i + 1; j < chars.length; j++) {
                int currentNumber = chars[j] - 48;
                if (i == j){
                    continue;
                }
                if (!(list.contains(currentNumber)) || currentNumber == 15){
                    list.add(currentNumber);
                } else {
                    list.clear();
                    break;
                }
                if (list.size() == 10){
                    flag = true;
                    System.out.println("YES");
                    break;
                }
            }
        }
        if (!flag){
            System.out.println("NO");
        }
    }
}
