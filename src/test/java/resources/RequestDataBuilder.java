package resources;

import com.github.javafaker.Faker;
import pojo.request.StudentRequestBody;

public class RequestDataBuilder {

    static Faker fake = new Faker();

    // Generate body for user POST request
    public static StudentRequestBody userPostRequestBody(){
        StudentRequestBody studentRequestBody = new StudentRequestBody();
        studentRequestBody.setName(fake.name().firstName());
        studentRequestBody.setAge(String.valueOf(fake.number().numberBetween(18,95)));
        studentRequestBody.setEmail("email@email.com");
        studentRequestBody.setImage("profileImage.png");
        return studentRequestBody;
    }
}
