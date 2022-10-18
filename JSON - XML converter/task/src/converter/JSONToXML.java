package converter;


import java.util.*;

public class JSONToXML {
    public static void convert(String input) {
        Map<String, String> map = new HashMap<>();
        String key = "";

        List<Integer> quoteIndexes = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '"') quoteIndexes.add(i);
        }
        System.out.println(quoteIndexes);
        key = input.substring(quoteIndexes.get(0) + 1, quoteIndexes.get(1));

        map.put(key,
                quoteIndexes.size() == 4 ? input.substring(quoteIndexes.get(2) + 1, quoteIndexes.get(3)) : "null");

        String output = "";

        if (!Objects.equals(map.get(key), "null")) {
            output = String.format("<%s>%s</%s>", key, map.get(key), key);
        } else {
            output = String.format("<%s/>", key);
        }
        System.out.println(output);
    }
}