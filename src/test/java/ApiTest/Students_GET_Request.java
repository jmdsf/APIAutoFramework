package ApiTest;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import resources.Helper;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Students_GET_Request extends Helper {

    @Test(groups = { "student", "users" })
    void getStudentsDetails() throws IOException {

        RequestSpecification req = RestAssured.given().spec(baseRequest());
        Response response = req.when().get(getAPIResource("allStudents"));

        // status code validation
        Assert.assertEquals(response.getStatusCode(),200, "Status code error");

        // status line
        Assert.assertEquals(response.getStatusLine(),"HTTP/1.1 200 OK", "Status line error");

        // validate message
        Assert.assertEquals(response.jsonPath().get("message"), "Success");

        System.out.println(response.headers().get("Date"));
    }
}
