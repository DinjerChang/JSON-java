package org.json.junit;

import org.json.JSONObject;
import org.json.XML;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.function.Consumer;
import java.util.function.Function;

// Add asynchronous methods to the library that allow the client code to proceed, while specifying what to do when the JSONObject becomes available.
public class Milestone5Test {
    /**
     * Test on "Future<JSONObject> toJSONObjectMS5(Reader reader, Function<String, String> f, Consumer<Exception> c)"
     * Test whether the function can handle with XML successfully and return the correct output
     */

    String xml ="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+
            "<contact>\n"+
            "  <nick>Crista </nick>\n"+
            "  <name>Crista Lopes</name>\n" +
            "  <address>\n" +
            "    <street>Ave of Nowhere</street>\n" +
            "    <zipcode>92614</zipcode>\n" +
            "  </address>\n" +
            "</contact>";

    String expect = "{\"SWE262_contact\":{\"SWE262_name\":\"Crista Lopes\",\"SWE262_nick\":\"Crista\",\"SWE262_address\":{\"SWE262_street\":\"Ave of Nowhere\",\"SWE262_zipcode\":92614}}}";

    @Test
    public void testSuccess(){
        try {
            Reader reader = new StringReader(xml);
            Function<String, String> f = (key) -> "SWE262_" + key;
            Consumer<Exception> c = (e) -> e.printStackTrace();

            // call the method to get future
            Future<JSONObject> future = XML.toJSONObject(reader, f, c);
            JSONObject current = future.get();

            // check equals
            assertEquals(current.toString(), expect);

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Test on "Future<JSONObject> toJSONObjectMS5(Reader reader, Function<String, String> k, Consumer<Exception> c)"
     * Test the exception occasion, expect print "No input function!" and future return NULL
     */
    @Test
    public void shouldThrowExecutionException() {
        Reader reader = new StringReader(xml);
        Consumer<Exception> c = (e) -> System.out.println("No input function!");
        Future<JSONObject> future = XML.toJSONObject(reader, null, c);
        assertNull(future);
    }
}