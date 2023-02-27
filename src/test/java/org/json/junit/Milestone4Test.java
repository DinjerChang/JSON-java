package org.json.junit;

import org.json.JSONObject;
import org.json.XML;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;


import static org.junit.Assert.*;

// Add streaming methods to the library that allow the client code to chain operations on JSON nodes

public class Milestone4Test {


    @Test
    public void testForEach() {
        JSONObject obj = XML.toJSONObject("<Books><book><title>AAA</title><author>ASmith</author></book>" +
                "<book><title>BBB</title><author>BSmith</author></book></Books>");

        obj.toStream().forEach(node -> {

            for (String key : node.keySet()) {
//                System.out.println(key);
                Object value = node.get(key);
                node.remove(key);
                node.put(key + "_postfix", value);

            }
            node.keySet().stream().forEach(modifiedKey -> assertTrue(modifiedKey.contains("_postfix")));
//            System.out.println(node);
        });
    }

    @Test
    public void testFilter() {
        JSONObject obj = XML.toJSONObject("<Books><book><title>AAA</title><author>ASmith</author></book>" +
                "<book><title>BBB</title><author>BSmith</author></book></Books>");
        List<JSONObject> JOwithTitles = obj.toStream().filter(node -> node.has("author")).collect(Collectors.toList());
//        System.out.println(JOwithTitles);
        List<JSONObject> expected = new ArrayList<>();
        JSONObject jo1 = XML.toJSONObject("<author>ASmith</author>");
        JSONObject jo2 = XML.toJSONObject("<author>BSmith</author>");
        expected.add(jo1);
        expected.add(jo2);
        for (int i = 0; i < JOwithTitles.size(); i++) {
            assertEquals(expected.get(i).get("author"), JOwithTitles.get(i).get("author"));
        }
    }

    @Test
    public void testMap() {
        JSONObject obj = XML.toJSONObject("<Books><book><title>AAA</title><author>ASmith</author></book>" +
                "<book><title>BBB</title><author>BSmith</author></book></Books>");
        List<String> titles = obj.toStream().map(node ->
                (node.has("title")) ? node.getString("title") : null).filter(res -> res != null).collect(Collectors.toList());
        List<String> expected = new ArrayList<>();
        expected.add("AAA");
        expected.add("BBB");
        assertEquals(expected, titles);
    }
}