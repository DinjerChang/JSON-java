![Json-Java logo](https://github.com/stleary/JSON-java/blob/master/images/JsonJava.png?raw=true)

<sub><sup>image credit: Ismael Pérez Ortiz</sup></sub>


### < Milestone2 >
<pre>
We wrote eight tests for testing Problem1 and Problem2.  

-----Problem 1-----
1. testM2P1WithNoSlash_1()     //No slash at the end of JSONPointer
2. testM2P1WithNoSlash_2()     //No slash at the end of JSONPointer
3. testM2P1WithSlash()         //With slash at the end of JSONPointer (throws exception: "Invalid Path with '/' ending")
4. testM2P1WrongPath()         //Wrong JSONPointer (throws exception: "Path not found")

-----Problem 2-----
1. testM2P2WithNoSlash_1()     //No slash at the end of JSONPointer
2. testM2P2WithNoSlash_2()     //No slash at the end of JSONPointer
3. testM2P2WithSlash()         //With slash at the end of JSONPointer (throws exception: "Invalid Path with '/' ending")
4. testM2P2WrongPath()         //Wrong JSONPointer (throws exception: "Path not found")

Run "mvn clean test -Dtest=XMLTest" to test XMLTest.java
</pre>

### < Milestone3 >
<pre>
We wrote four tests for testing Milestone 3.  

1. testM3()                        //add "SWE262_" to every keys as prefix
2. testM3WithEmptyString()         //throws exception: "Invalid: transform key to empty string" 
3. testM3WithNull()                //throws exception: "Invalid: transform key to null"
4. testM3WithDuplicateKeyName()    //throws exception: "Invalid: transform key to all the same string"

Run "mvn clean test -Dtest=XMLTest" to test XMLTest.java
</pre>

JSON in Java [package org.json]
===============================

[![Maven Central](https://img.shields.io/maven-central/v/org.json/json.svg)](https://mvnrepository.com/artifact/org.json/json)

**[Click here if you just want the latest release jar file.](https://search.maven.org/remotecontent?filepath=org/json/json/20220924/json-20220924.jar)**


# Overview

[JSON](http://www.JSON.org/) is a light-weight language-independent data interchange format.

The JSON-Java package is a reference implementation that demonstrates how to parse JSON documents into Java objects and how to generate new JSON documents from the Java classes.

Project goals include:
* Reliable and consistent results
* Adherence to the JSON specification 
* Easy to build, use, and include in other projects
* No external dependencies
* Fast execution and low memory footprint
* Maintain backward compatibility
* Designed and tested to use on Java versions 1.6 - 1.11

The files in this package implement JSON encoders and decoders. The package can also convert between JSON and XML, HTTP headers, Cookies, and CDL.

# If you would like to contribute to this project

For more information on contributions, please see [CONTRIBUTING.md](https://github.com/stleary/JSON-java/blob/master/docs/CONTRIBUTING.md)

Bug fixes, code improvements, and unit test coverage changes are welcome! Because this project is currently in the maintenance phase, the kinds of changes that can be accepted are limited. For more information, please read the [FAQ](https://github.com/stleary/JSON-java/wiki/FAQ).

# Build Instructions

The org.json package can be built from the command line, Maven, and Gradle. The unit tests can be executed from Maven, Gradle, or individually in an IDE e.g. Eclipse.
 
**Building from the command line**

*Build the class files from the package root directory src/main/java*
````
javac org/json/*.java
````

*Create the jar file in the current directory*
````
jar cf json-java.jar org/json/*.class
````

*Compile a program that uses the jar (see example code below)*
````
javac -cp .;json-java.jar Test.java (Windows)
javac -cp .:json-java.jar Test.java (Unix Systems)
````

*Test file contents*

````
import org.json.JSONObject;
public class Test {
    public static void main(String args[]){
       JSONObject jo = new JSONObject("{ \"abc\" : \"def\" }");
       System.out.println(jo.toString());
    }
}
````

*Execute the Test file*
```` 
java -cp .;json-java.jar Test (Windows)
java -cp .:json-java.jar Test (Unix Systems)
````

*Expected output*

````
{"abc":"def"}
````

 
**Tools to build the package and execute the unit tests**

Execute the test suite with Maven:
```
mvn clean test
```

Execute the test suite with Gradlew:

```
gradlew clean build test
```

# Notes

For more information, please see [NOTES.md](https://github.com/stleary/JSON-java/blob/master/docs/NOTES.md)

# Files

For more information on files, please see [FILES.md](https://github.com/stleary/JSON-java/blob/master/docs/FILES.md)

# Release history:

For the release history, please see [RELEASES.md](https://github.com/stleary/JSON-java/blob/master/docs/RELEASES.md)
