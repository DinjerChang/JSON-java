# Milestone4

### toStream() methods is added in src/main/java/org.json/JSONObject.java at [line 494]

* toStream() method returns a stream of JSONObjects inside the input JSONObject. It returns the elements in DFS manner.  

For example, the input JSONObject is as follows:  
<pre>
{"contact": {
"nick": "Crista",
"address": {
"zipcode": 92614,
"street": "Ave of Nowhere"
},
"name": "Crista Lopes"
}}
</pre>

The expected output stream should look like this:  
<pre>
{"contact":{"nick":"Crista","address":{"zipcode":92614,"street":"Ave of Nowhere"},"name":"Crista Lopes"}}
{"nick":"Crista"}
{"address":{"zipcode":92614,"street":"Ave of Nowhere"}}
{"zipcode":92614}
{"street":"Ave of Nowhere"}
{"name":"Crista Lopes"}
</pre>

### Unit Tests are added in src/test/java/org.json.junit/Milestone4Test.java

`testForEach()` at line 19 ~ 34  
`testFilter()` at line 38 ~ 51   
`testMap()` at line 54 ~ 63

