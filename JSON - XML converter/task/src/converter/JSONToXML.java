package converter;

import org.json.JSONObject;
import org.json.XML;

public class JSONToXML {
    public static void convert(String line) {
        JSONObject obj = new JSONObject(line);
        //converting json to xml
        String result = XML.toString(obj);
        if (result.contains(">null<")) {
            int index = result.indexOf(">null<");
            result = result.substring(0, index) + "/>";
            System.out.println(result);
        } else {
            System.out.println(result);
        }
    }
}