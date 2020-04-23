package ApiTest;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pojo.response.SuccessResponseBody;
import resources.Helper;

import java.io.IOException;

public class Student_GET_Request extends Helper {

    @DataProvider(name = "studentId")
    public Object[][] dataProviderMethod() {
        return new Object[][] { { "/226" }, { "/361" } };
    }

    @Test(groups = { "student", "users" }, dataProvider = "studentId")
    void getStudent(String studentId) throws IOException {

        RequestSpecification req = RestAssured.given().spec(baseRequest());

        SuccessResponseBody response = req.when().get(getAPIResource("studentGet")+studentId)
                .then()
                .assertThat().statusCode(HttpStatus.SC_OK)
                .assertThat().statusLine("HTTP/1.1 200 OK")
                .extract().as(SuccessResponseBody.class);

        Assert.assertEquals(response.getData().size(), 1);
    }
}
