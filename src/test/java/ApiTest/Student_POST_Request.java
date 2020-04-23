package ApiTest;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.response.SuccessResponseBody;
import resources.Helper;
import resources.RequestDataBuilder;
import resources.ResponseDataBuilder;


import java.io.IOException;

public class Student_POST_Request extends Helper {

    @Test(groups = { "student", "users" })
    void createStudent() throws IOException {

        SuccessResponseBody expectedResponse = ResponseDataBuilder.SuccessResponse();

        RequestSpecification req = RestAssured.given().spec(baseRequest()).body(RequestDataBuilder.userPostRequestBody());
        SuccessResponseBody response = req.when().
                post(getAPIResource("studentCreate")).then()
                .assertThat().statusCode(HttpStatus.SC_OK).statusLine("HTTP/1.1 200 OK")
                .extract().as(SuccessResponseBody.class);

        Assert.assertNull(response.getData());
        Assert.assertEquals(expectedResponse, response);
    }

}
