import java.util.*;

public class valueshashmap {
    public static void printValues(Map<Integer, String> map) {
        Set<String> distinctValues = new LinkedHashSet<>(map.values());
        for (String value : distinctValues) {
            System.out.print(value + " ");
        }
    }

    public static void main(String[] x) {
        Map<Integer, String> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int key;
        String value;
        for (int i = 1; i <= num; i++) {
            key = sc.nextInt();
            value = sc.next();
            map.put(key, value);
        }
        printValues(map);
    }
    
}
