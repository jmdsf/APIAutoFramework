package ApiTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import resources.Helper;
import resources.TestDataBuilder;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Employee_POST_Request extends Helper {

    @Test(groups = { "employee", "users" })
    void createEmployee() throws IOException {
        RequestSpecification req = RestAssured.given().spec(baseRequest()).
                body(TestDataBuilder.generateStudentCreationData()).
                auth().basic("ADMIN","SECRETE123");
        Response response = req.when().post(getAPIResource("employeeCreate"));

        // status code validation
        Assert.assertEquals(response.getStatusCode(),200, "Status code error");

        // status line
        Assert.assertEquals(response.getStatusLine(),"HTTP/1.1 200 OK", "Status line error");

        // validate message
        Assert.assertEquals(response.jsonPath().get("message"), "Success");

    }
}