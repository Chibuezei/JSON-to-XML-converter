package converter;

import org.json.JSONObject;
import org.json.XML;

public class XMLToJSON {
    public static void covert(String line){
        //converting xml to json
        JSONObject obj = XML.toJSONObject(line,true);
        String result = obj.toString();
        if(result.contains("\"\"")){
            int index = result.indexOf("\"\"");
            result = result.substring(0, index) + "null" + result.substring(index + 2);
            System.out.println(result);
        } else {
            System.out.println(result);
        }

    }
}
