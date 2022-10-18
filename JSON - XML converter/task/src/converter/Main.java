package converter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        String path = System.getProperty("user.dir") + "/JSON - XML converter/task/src/converter/text.txt";

//        String input = scanner.nextLine();
        String input = null;
        try {
            input = Files.readString(Paths.get(path));
        } catch (IOException ex) {
            System.out.printf("save exception occurred %s", ex.getMessage());
        }
        assert input != null;
        System.out.println(input);
        main.convert(input);
    }

    private void convert(String input) {
        switch (input.charAt(0)) {
            case '{' -> JSONToXML.convert(input);
            case '<' -> XMLToJSON.covert(input);
            default -> System.out.println("Unsupported operation!");
        }
    }
}
