package SummerJavaCourse2023.Tasks;

import java.util.*;


public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            list.add(scanner.nextInt());
        }
        if (lineUp(list)){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }

    public static boolean lineUp(List<Integer> list){
        int i = 0;
        int count = 0;

        while (list.get(i) <= list.get(i+1)){
            count++;
            if (count == 3){
                return true;
            }
            i++;
        }

        i = 0;
        count = 0;
        while (list.get(i) >= list.get(i+1)){
            count++;
            if (count == 3){
                return true;
            }
            i++;
        }
        return false;
    }
}

