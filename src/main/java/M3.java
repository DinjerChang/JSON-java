import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONPointer;
import org.json.XML;

import java.io.StringReader;
import java.util.function.Function;

public class M3 {
    public static void main(String[] args) {
        String xmlString ="<?xml version=\"1.0\"?>\n" +
                "<catalog>\n" +
                "    <book id=\"bk101\">\n" +
                "        <author>Gambardella, Matthew</author>\n" +
                "        <title>XML Developer's Guide</title>\n" +
                "        <genre>Computer</genre>\n" +
                "        <price>44.95</price>\n" +
                "        <publish_date>2000-10-01</publish_date>\n" +
                "        <description>An in-depth look at creating applications\n" +
                "            with XML.</description>\n" +
                "    </book>\n" +
                "    <book id=\"bk102\">\n" +
                "        <author>Ralls, Kim</author>\n" +
                "        <title>Midnight Rain</title>\n" +
                "        <genre>Fantasy</genre>\n" +
                "        <price>5.95</price>\n" +
                "        <publish_date>2000-12-16</publish_date>\n" +
                "        <description>A former architect battles corporate zombies,\n" +
                "            an evil sorceress, and her own childhood to become queen\n" +
                "            of the world.</description>\n" +
                "    </book>\n" +
                "    <book id=\"bk103\">\n" +
                "        <author>Corets, Eva</author>\n" +
                "        <title>Maeve Ascendant</title>\n" +
                "        <genre>Fantasy</genre>\n" +
                "        <price>5.95</price>\n" +
                "        <publish_date>2000-11-17</publish_date>\n" +
                "        <description>After the collapse of a nanotechnology\n" +
                "            society in England, the young survivors lay the\n" +
                "            foundation for a new society.</description>\n" +
                "    </book>\n" +
                "</catalog>";

        try {

            JSONObject jobj = XML.toJSONObject(new StringReader(xmlString), s -> {
                StringBuilder builder = new StringBuilder(s);
                builder.reverse();
                return builder.toString();
            });

            //JSONObject jobj = XML.toJSONObject(new StringReader(xmlString), s -> "swe262p_" + s);
            System.out.println("all keys: " + jobj.keySet());
            System.out.println("res: " + jobj);

        } catch (JSONException e) {
            System.out.println(e);
        }
    }
}
