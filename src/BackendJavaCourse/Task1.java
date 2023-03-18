package BackendJavaCourse;

import java.util.*;

/**
 * The old thermometer
 */
public class Task1 {
    public static boolean ValuesIsSameSign(List<String> list){
        long length1 = list.stream().filter(x -> x.equals("-")).count();
        long length2 = list.stream().filter(x -> x.equals("0+")).count();
        return length1 == list.size() || length2 == list.size();
    }

    public static boolean KeysIsSameSign(List<Integer> list){
        long length = list.stream().filter(x -> x >= 0).count();
        return length == 0 || length == list.size();
    }

    public static Integer summer(List<Integer> list){
        int total = 0;
        for (Integer integer : list) {
            total += integer;
        }
        return total;
    }

    public static int counter(Map<Integer,String> map){

        int countDownSpot = 0;
        Integer firstKey = 0;
        String firstValue = "";

        for(Map.Entry<Integer, String> entry: map.entrySet()) {
            firstKey = entry.getKey();
            firstValue = entry.getValue();
            break;
        }

        int total = firstKey;
        int iter = 0;
        for(Map.Entry<Integer, String> entry: map.entrySet()) {
            if (iter==0){
                iter++;
                continue;
            }

            Integer key = entry.getKey();
            String value = entry.getValue();
            if (!value.equals(firstValue)){
                if (value.equals("0+")){
                    countDownSpot = -(total+1);
                }else{
                    countDownSpot = -key - 1 - total;
                }
                break;
            }else {
                total+=key;
            }
            //System.out.println(total);
        }
        //System.out.println(countDownSpot);
        return countDownSpot + summer(map.keySet().stream().toList());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<Integer, String> map = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            int d = scanner.nextInt();
            String temp = scanner.next();
            map.put(d,temp);
        }

        //System.out.println(counter(map));
        boolean flag1 = ValuesIsSameSign(map.values().stream().toList());
        boolean flag2 = KeysIsSameSign(map.keySet().stream().toList());
        List<Integer> keys = map.keySet().stream().toList();
        List<String> values = map.values().stream().toList();

        if (flag1 && flag2 && (keys.get(0) < 0) && (values.get(0).equals("0+"))){
            System.out.println(0);
        }else if (flag1 && flag2){
            System.out.println("inf");
        }else{
            System.out.println(counter(map));
        }
    }
}
