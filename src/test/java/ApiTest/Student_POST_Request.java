package ApiTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.response.StudentResponseBody;
import resources.Helper;
import resources.TestDataBuilder;


import java.io.IOException;

public class Student_POST_Request extends Helper {

    @Test(groups = { "student", "users" })
    void createStudent() throws IOException {
        RequestSpecification req = RestAssured.given().spec(baseRequest()).body(TestDataBuilder.generateStudentCreationData());
        Response response = req.when().post(getAPIResource("studentCreate"));

        // status code validation
        Assert.assertEquals(response.getStatusCode(),200, "Status code error");

        // status line
        Assert.assertEquals(response.getStatusLine(),"HTTP/1.1 200 OK", "Status line error");

        // validate message
        Assert.assertEquals(response.jsonPath().get("message"), "Success");
    }

    @Test
    void createStudentPojo() throws IOException {
        RequestSpecification req = RestAssured.given().spec(baseRequest()).body(TestDataBuilder.generateStudentCreationData());
        StudentResponseBody response = req.when().
                post(getAPIResource("studentCreate")).then()
                .assertThat().statusCode(HttpStatus.SC_OK)
                .extract().as(StudentResponseBody.class);
        System.out.println(response);
    }

}
