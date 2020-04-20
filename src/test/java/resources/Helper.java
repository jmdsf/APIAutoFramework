package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.*;
import java.util.Properties;

public class Helper {

    public static RequestSpecification baseRequest;

    public RequestSpecification baseRequest() throws FileNotFoundException {
        // Generating logs
        PrintStream log = new PrintStream(new FileOutputStream(System.getProperty("user.dir") +
                "/src/test/logs/log.txt", true));

        baseRequest = new RequestSpecBuilder().
                setContentType(ContentType.JSON).
                setBaseUri("https://apingweb.com/api/rest/").
                addFilter(RequestLoggingFilter.logRequestTo(log)).
                addFilter(ResponseLoggingFilter.logResponseTo(log)).
                build();

        return baseRequest;
    }

    public String getAPIResource(String resource) throws IOException {
        Properties props = new Properties();
        FileInputStream apiResources = new FileInputStream(System.getProperty("user.dir")
                + "/src/test/java/resources/resources.properties");
        props.load(apiResources);
        return props.getProperty(resource);
    }
}
