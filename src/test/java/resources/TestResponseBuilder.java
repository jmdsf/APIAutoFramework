package resources;

import com.github.javafaker.Faker;
import pojo.response.StudentData;
import pojo.response.StudentResponseBody;

public class TestResponseBuilder {

    static Faker fake = new Faker();

    public static StudentResponseBody generateStudentResponseData(){
        StudentResponseBody responseBody = new StudentResponseBody();
        StudentData StudentData = new StudentData();

        StudentData.setStudent_id("123");
        StudentData.setName("name");
        StudentData.setAge("12");
        StudentData.setEmail("fake@email.com");
        StudentData.setImage("image.png");
        StudentData.setDate_created("");

        responseBody.setSuccess(true);
        responseBody.setMessage("Success");
        responseBody.setError_code(200);

        return responseBody;
    }
}
