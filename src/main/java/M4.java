import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONPointer;
import org.json.XML;

import java.io.StringReader;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class M4 {
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

            JSONObject obj = XML.toJSONObject(xmlString);
            Stream<JSONObject> stream = obj.toStream();

            System.out.println(obj);
            List<JSONObject> l = stream.collect(Collectors.toList());
            for (JSONObject node : l) {
                System.out.println(node.toString());
            }

            /*List<JSONObject> l2 = stream.filter(node -> node.has("tt")).collect(Collectors.toList());
            for (JSONObject j : l2) {
                System.out.println(j.toString());
            }*/

            /*System.out.println(obj.keySet());
            List<Set<String>> l3 = stream.map(node -> node.keySet()).collect(Collectors.toList());
            for (Set<String> s : l3) {
                System.out.println(s.toString());;
            }*/

        } catch (JSONException e) {
            System.out.println(e);
        }
    }
}
