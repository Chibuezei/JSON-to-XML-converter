package converter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().trim();
        char xmlOrJson = line.charAt(0);
        switch (xmlOrJson){
            case '<' -> XMLToJSON.covert(line);
            case '{' -> JSONToXML.convert(line);
        }

    }
}