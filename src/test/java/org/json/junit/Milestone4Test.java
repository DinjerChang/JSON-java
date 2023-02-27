package org.json.junit;

import org.json.JSONObject;
import org.json.XML;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

// Add streaming methods to the library that allow the client code to chain operations on JSON nodes

public class Milestone4Test {
    @Test
    public void streamTestPrint() {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<contact>\n" +
                "  <nick>Crista </nick>\n" +
                "  <name>Crista Lopes</name>\n" +
                "  <address>\n" +
                "    <street>Ave of Nowhere</street>\n" +
                "    <zipcode>92614</zipcode>\n" +
                "  </address>\n" +
                "</contact>";

        String xml1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<nick>Crista </nick>\n";
        String xml2 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "  <address>\n" +
                "    <street>Ave of Nowhere</street>\n" +
                "    <zipcode>92614</zipcode>\n" +
                "  </address>\n";
        String xml3 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<zipcode>92614</zipcode>\n";
        String xml4 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<street>Ave of Nowhere</street>\n";
        String xml5 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<name>Crista Lopes</name>\n";

        JSONObject[] xmlArray = {XML.toJSONObject(xml),
                XML.toJSONObject(xml1),
                XML.toJSONObject(xml2),
                XML.toJSONObject(xml3),
                XML.toJSONObject(xml4),
                XML.toJSONObject(xml5),
        };
        JSONObject jsonObject =
                XML.toJSONObject(xml);
        Stream<JSONObject> stream = jsonObject.toStream();
        List<JSONObject> l = stream.collect(Collectors.toList());
        int i = 0;
        for (JSONObject node : l) {
            assertEquals(node.toString(), xmlArray[i].toString());
            i++;
        }
    }

    @Test
    public void streamTestfilter() {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<person>\n" +
                "<contact>\n" +
                "  <nick>Crista </nick>\n" +
                "  <name>Crista Lopes</name>\n" +
                "  <address>\n" +
                "    <street>Ave of Nowhere</street>\n" +
                "    <zipcode>92614</zipcode>\n" +
                "  </address>\n" +
                "</contact>" +
                "<contact>\n" +
                "  <nick>Eric </nick>\n" +
                "  <name>Eric</name>\n" +
                "  <address>\n" +
                "    <street>Verano</street>\n" +
                "    <zipcode>92617</zipcode>\n" +
                "  </address>\n" +
                "</contact>" +
                "</person>";


        String xml1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<zipcode>92617</zipcode>\n";


        JSONObject[] xmlArray = {
                XML.toJSONObject(xml1),
        };
        JSONObject jsonObject =
                XML.toJSONObject(xml);
        Stream<JSONObject> stream = jsonObject.toStream();
        int i = 0;
        List<JSONObject> l = stream.filter(node -> node.has("zipcode")).collect(Collectors.toList());
        for (JSONObject j : l) {
            assertEquals(xmlArray[i].toString(), j.toString());
            i++;
        }
    }

    @Test
    public void streamGetKey() {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<contact>\n" +
                "  <nick>Crista </nick>\n" +
                "  <name>Crista Lopes</name>\n" +
                "  <address>\n" +
                "    <street>Ave of Nowhere</street>\n" +
                "    <zipcode>92614</zipcode>\n" +
                "  </address>\n" +
                "</contact>";
        List<Set<String>> expect = new ArrayList<>();
        Set<String> set1 = new HashSet<>(Arrays.asList("contact"));
        Set<String> set2 = new HashSet<>(Arrays.asList("nick"));
        Set<String> set3 = new HashSet<>(Arrays.asList("address"));
        Set<String> set4 = new HashSet<>(Arrays.asList("zipcode"));
        Set<String> set5 = new HashSet<>(Arrays.asList("street"));
        Set<String> set6 = new HashSet<>(Arrays.asList("name"));
        expect.add(set1);
        expect.add(set2);
        expect.add(set3);
        expect.add(set4);
        expect.add(set5);
        expect.add(set6);
        JSONObject jsonObject =
                XML.toJSONObject(xml);
        Stream<JSONObject> stream = jsonObject.toStream();
        int i = 0;
        List<Set<String>> l = stream.map(node -> node.keySet()).collect(Collectors.toList());
        for (Set<String> s : l) {
            assertEquals(expect.get(i), s);
            i++;
        }
    }
}