package pojo.response;

import com.fasterxml.jackson.annotation.JsonFormat;

public class StudentData {

    private String student_id;
    private String name;
    private String age;
    private String email;
    private String image;
    private String date_created;

    public StudentData(String student_id, String name, String age, String email, String image, String date_created) {
        this.student_id = student_id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.image = image;
        this.date_created = date_created;
    }

    public StudentData() {
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDate_created() {
        return date_created;
    }

    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }
}
