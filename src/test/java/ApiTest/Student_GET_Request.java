package ApiTest;

import com.sun.istack.NotNull;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import resources.Helper;

import java.io.IOException;

public class Student_GET_Request extends Helper {

    @DataProvider(name = "studentId")
    public Object[][] dataProviderMethod() {
        return new Object[][] { { "/226" }, { "/255" } };
    }

    @Test(groups = { "student", "users" }, dataProvider = "studentId")
    public void getStudentDetailsById(String studentId) throws IOException {
        RequestSpecification req = RestAssured.given().spec(baseRequest());
        Response response = req.when().get(getAPIResource("studentGet")+studentId);
        // status code validation
        Assert.assertEquals(response.getStatusCode(),200, "Status code error");

        // status line
        Assert.assertEquals(response.getStatusLine(),"HTTP/1.1 200 OK", "Status line error");

        // validate message
        Assert.assertEquals(response.jsonPath().get("message"), "Success");

        // Response body check
        String bodyStringValue = response.getBody().asString();
        Assert.assertTrue(bodyStringValue.contains("student_id"));
        Assert.assertTrue(bodyStringValue.contains("email"));
    }
}
