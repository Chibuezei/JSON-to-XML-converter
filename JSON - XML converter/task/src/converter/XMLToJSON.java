package converter;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XMLToJSON {
    public static void covert(String input){
        Map<String, String> map = new HashMap<>();
        String key = "";
        List<Integer> leftSlashIndexes = new ArrayList<>();
        List<Integer> rightSlashIndexes = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '<') leftSlashIndexes.add(i);
            if (input.charAt(i) == '>') rightSlashIndexes.add(i);
        }
        key = input.substring(leftSlashIndexes.get(0) + 1, rightSlashIndexes.get(0)).replace("/", "");

        map.put(key,
                leftSlashIndexes.size() == 2 ?
                        input.substring(rightSlashIndexes.get(0) + 1, leftSlashIndexes.get(1)) :
                        null);

        System.out.printf("{\"%s\" : %s}", key, map.get(key) == null ? "null" :
                String.format("\"%s\"", map.get(key)));

    }
}