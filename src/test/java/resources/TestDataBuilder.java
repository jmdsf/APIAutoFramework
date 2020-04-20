package resources;

import pojo.Student;

public class TestDataBuilder {

    public static Student generateStudentCreationData(){
        Student student = new Student();
        student.setName("Juan");
        student.setAge("35");
        student.setEmail("email@email.com");
        student.setImage("profileImage.png");
        return student;
    }
}
