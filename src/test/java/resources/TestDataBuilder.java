package resources;

import com.github.javafaker.Faker;
import pojo.request.StudentRequestBody;

public class TestDataBuilder {

    static Faker fake = new Faker();

    public static StudentRequestBody generateStudentCreationData(){
        StudentRequestBody studentRequestBody = new StudentRequestBody();
        studentRequestBody.setName(fake.name().firstName());
        studentRequestBody.setAge(String.valueOf(fake.number().numberBetween(10,90)));
        studentRequestBody.setEmail("email@email.com");
        studentRequestBody.setImage("profileImage.png");
        return studentRequestBody;
    }
}
