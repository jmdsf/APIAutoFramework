package ApiTest;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.response.SuccessResponseBody;
import resources.Helper;

import java.io.IOException;

public class Employees_GET_Request extends Helper {

    @Test(groups = { "employee", "users" })
    void getEmployees() throws IOException {

        RequestSpecification req = RestAssured.given().spec(baseRequest()).auth().basic("ADMIN","SECRETE123");

        SuccessResponseBody response = req.when().get(getAPIResource("allEmployees"))
                .then()
                .assertThat().statusCode(HttpStatus.SC_OK).statusLine("HTTP/1.1 200 OK")
                .extract().as(SuccessResponseBody.class);

        Assert.assertTrue(response.getData().size() > 1);
        Assert.assertNotNull(response.getData().get(0).getEmployee_id());

    }
}
