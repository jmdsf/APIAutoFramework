package ApiTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.response.SuccessResponseBody;
import resources.Helper;
import resources.RequestDataBuilder;

import java.io.IOException;

public class Employee_POST_Request extends Helper {

    @Test(groups = { "employee", "users" })
    void createEmployee() throws IOException {
        RequestSpecification req = RestAssured.given().spec(baseRequest()).
                body(RequestDataBuilder.userPostRequestBody()).
                auth().basic("ADMIN","SECRETE123");

        SuccessResponseBody response = req.when().
                post(getAPIResource("employeeCreate")).then()
                .assertThat().statusCode(HttpStatus.SC_OK).statusLine("HTTP/1.1 200 OK")
                .extract().as(SuccessResponseBody.class);

        Assert.assertNull(response.getData());
    }
}
