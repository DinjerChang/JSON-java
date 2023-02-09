import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONPointer;
import org.json.XML;

import java.io.StringReader;
import java.util.function.Function;

public class M3 {
    public static void main(String[] args) {
        String xmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+
                "<contact>\n"+
                "  <nick>Crista </nick>\n"+
                "  <name>Crista Lopes</name>\n" +
                "  <address>\n" +
                "    <street>Ave of Nowhere</street>\n" +
                "    <zipcode>92614</zipcode>\n" +
                "  </address>\n" +
                "</contact>";

        try {

            JSONObject jobj = XML.toJSONObject(new StringReader(xmlString), s -> {
                StringBuilder builder = new StringBuilder(s);
                builder.reverse();
                return builder.toString();
            });
            System.out.println("all keys: " + jobj.keySet());
            System.out.println("res: " + jobj);

        } catch (JSONException e) {
            System.out.println(e);
        }
    }
}
